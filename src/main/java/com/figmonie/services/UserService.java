package com.figmonie.services;


import com.figmonie.data.models.User;
import com.figmonie.dtos.request.RegisterRequest;
import org.springframework.stereotype.Service;

public interface UserService {

    User saveUser(RegisterRequest request);
    User findByUsername(String username);
}
