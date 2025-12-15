package com.figmonie.services;

import com.figmonie.data.models.BankCode;
import com.figmonie.data.models.Transaction;
import com.figmonie.data.models.User;
import com.figmonie.data.repositories.TransactionRepository;
import com.figmonie.dtos.request.TransactionRequest;
import com.figmonie.dtos.responses.TransactionResponse;
import com.figmonie.exceptions.InvalidAmountException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;

import static com.figmonie.utils.Mapper.map;
import static com.figmonie.utils.Mapper.mapResponse;
import static com.figmonie.utils.Validator.isValidAmount;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class TransactionServiceImpl implements TransactionService{
    private TransactionRepository transactionRepository;
    private UserServiceImpl userService;
    private PasswordEncoder passwordEncoder;
    private BankVerificationServiceImpl bankVerificationService;

    @Override
    @Transactional
    public TransactionResponse transfer(TransactionRequest request) {
        User user = userService.findById(request.getUserId());
        if (user == null)
            throw new UsernameNotFoundException("User not found");

        BankCode bankCode = BankCode.valueOf(request.getRecipientBank().toUpperCase());
        bankVerificationService.verifyAccount(bankCode.toString(), request.getRecipientAccountNumber());

        String savedPin = user.getAccount().getTransactionPin();
        isPasswordValid(request.getTransactionPin(), savedPin);

        BigDecimal balance = user.getAccount().getBalance();
        BigDecimal amount = request.getAmount();

        isValidAmount(amount, balance);
        user.getAccount().setBalance(balance.subtract(amount));

        User savedUser = userService.saveUser(user);
        Transaction savedTransaction = transactionRepository.save(map(savedUser, request, "TRANSFER"));

        return mapResponse(savedUser, savedTransaction);
    }

    public void isPasswordValid(String pin, String savedPin){
        if (!passwordEncoder.matches(pin, savedPin))
            throw new InvalidAmountException("Invalid transaction pin");
    }
}
