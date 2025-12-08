package com.figmonie.services;


import com.figmonie.data.models.User;
import com.figmonie.dtos.request.AccountRequest;
import com.figmonie.dtos.request.RegisterRequest;
import com.figmonie.dtos.responses.UserResponse;
import org.springframework.stereotype.Service;

public interface UserService {

    User saveUser(User user);
    UserResponse createAccount(AccountRequest request);
    UserResponse setTransactionPin(String userId, String pin);
    User findById(String email);
    User findByUsername(String username);
    UserResponse findByAccountNumber(String accountNumber);
    UserResponse updateImage(String userId, String image);
}
