package com.figmonie.utils;

import com.figmonie.data.models.Role;
import com.figmonie.data.models.User;
import com.figmonie.dtos.request.RegisterRequest;
import com.figmonie.dtos.responses.TransactionResponse;
import com.figmonie.dtos.responses.UserResponse;

public class Mapper {

    public static User map(RegisterRequest request) {
        User user = new User();
        user.setFirstName(request.getFirstname());
        user.setLastName(request.getLastname());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setRole(Role.valueOf(request.getRole()
                .toUpperCase()
                .trim()));

        return user;
    }

    public static UserResponse map(User user) {
        return UserResponse.builder()
                .email(user.getEmail())
                .username(user.getUsername())
                .build();
    }

    public static TransactionResponse mapResponse(User user){
        TransactionResponse response = new TransactionResponse();
        return response;
    }
}
