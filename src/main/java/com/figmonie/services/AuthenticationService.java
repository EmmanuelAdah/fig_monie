package com.figmonie.services;

import com.figmonie.data.models.User;
import com.figmonie.dtos.request.LoginRequest;
import com.figmonie.dtos.request.RegisterRequest;
import com.figmonie.dtos.responses.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static com.figmonie.utils.Mapper.map;
import static com.figmonie.utils.Validator.isValidRequest;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserServiceImpl userService;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    public UserResponse register(RegisterRequest request) {
        request.setPassword(passwordEncoder.encode(request.getPassword()));
        isValidRequest(request);

        User savedUser = userService.saveUser(map(request));
        String token = jwtService.generateToken(savedUser);

        return response(savedUser, token);
    }

    public UserResponse login(LoginRequest request) {
        User user = userService.findByUsername(request.getUsername());

        String token = jwtService.generateToken(user);
        return response(user, token);
    }

    private UserResponse response(User user, String token) {
        return UserResponse.builder()
                .token(token)
                .email(user.getEmail())
                .username(user.getUsername())
                .build();
    }
}
