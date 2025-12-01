package com.figmonie.services;


import com.figmonie.data.models.User;
import com.figmonie.dtos.request.RegisterRequest;
import com.figmonie.dtos.responses.UserResponse;
import org.springframework.stereotype.Service;

public interface UserService {

    User saveUser(RegisterRequest request);
    User findById(String email);
    User findByUsername(String username);
    UserResponse updateImage(String userId, String image);
}
