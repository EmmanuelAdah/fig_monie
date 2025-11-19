package com.figmonie.services;

import com.figmonie.data.models.User;
import com.figmonie.dtos.request.LoginRequest;
import com.figmonie.dtos.request.RegisterRequest;
import com.figmonie.dtos.responses.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserServiceImpl userService;
    private final JwtService jwtService;

    public UserResponse register(RegisterRequest request) {
        User user = userService.saveUser(request);
        String token = jwtService.generateToken(user);

        return response(user, token);
    }

    public UserResponse login(LoginRequest request) {

    }

    private UserResponse response(User user, String token) {
        return UserResponse.builder()
                .token(token)
                .email(user.getEmail())
                .username(user.getUsername())
                .build();
    }
}
