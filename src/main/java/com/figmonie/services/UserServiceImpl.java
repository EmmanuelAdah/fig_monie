package com.figmonie.services;

import com.figmonie.data.models.User;
import com.figmonie.data.repositories.UserRepository;
import com.figmonie.dtos.request.AccountRequest;
import com.figmonie.dtos.responses.UserResponse;
import com.figmonie.utils.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.figmonie.utils.Mapper.map;
import static com.figmonie.utils.Validator.isValidAccountNumber;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public UserResponse createAccount(AccountRequest request){
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        isValidAccountNumber(request.getAccountNumber());

        user.getAccount().setAccountNumber(request.getAccountNumber());
        User saveduser = userRepository.save(user);
        return map(saveduser);
    }

    @Override
    @Transactional
    public UserResponse setTransactionPin(String userId, String password){
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        user.getAccount().setTransactionPin(password);
        User saveduser = userRepository.save(user);
        return map(saveduser);
    }

    @Override
    public User findByUsername(String username) {
        User user = userRepository.findByUsername(username);
        if(user == null)
            throw new UsernameNotFoundException("User not found");
        return user;
    }

    @Override
    public User findById(String userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    @Override
    public UserResponse findByAccountNumber(String accountNumber){
        return userRepository.findByAccount_AccountNumber(accountNumber)
                .map(Mapper::map)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

    }

    @Override
    public UserResponse updateImage(String userId, String filePath) {
        return new UserResponse();
    }
}
