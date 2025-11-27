package com.figmonie.services;

import com.figmonie.data.models.User;
import com.figmonie.data.repositories.TransactionRepository;
import com.figmonie.dtos.request.TransactionRequest;
import com.figmonie.dtos.responses.TransactionResponse;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class TransactionServiceImpl implements TransactionService{
    private TransactionRepository transactionRepository;
    private UserServiceImpl userService;

    @Override
    public TransactionResponse transfer(TransactionRequest request) {
        User user = userService.findById(request.getUserId());
        if (user == null)
            throw new UsernameNotFoundException("User not found");

        return new TransactionResponse();
    }
}
