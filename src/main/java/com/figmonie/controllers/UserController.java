package com.figmonie.controllers;

import com.figmonie.dtos.request.AccountRequest;
import com.figmonie.dtos.request.SetPinRequest;
import com.figmonie.dtos.responses.UserResponse;
import com.figmonie.services.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import static com.figmonie.utils.Mapper.map;
import static com.figmonie.utils.Validator.isValidPin;

@RestController(value = "/api/user")
@RequiredArgsConstructor
public class UserController {
    private final UserServiceImpl userService;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("find/{userId}")
    public ResponseEntity<UserResponse> findById(@PathVariable String userId) {
        return ResponseEntity.ok(map(userService.findById(userId)));
    }

    @PutMapping("/create/account")
    public ResponseEntity<UserResponse> createAccount(@RequestBody AccountRequest request){
        return ResponseEntity.ok(userService.createAccount(request));
    }

    @GetMapping("/find/account/{accountNumber}")
    public ResponseEntity<UserResponse> findByAccountNumber(@PathVariable String accountNumber){
        return ResponseEntity.ok(userService.findByAccountNumber(accountNumber));
    }

    @PutMapping("/set-pin/{userId}")
    public ResponseEntity<UserResponse> setTransactionPin(@PathVariable String userId,
                                                          @RequestBody SetPinRequest request){
        isValidPin(request.getPin());
        String password = passwordEncoder.encode(request.getPin());
        return ResponseEntity.ok(userService.setTransactionPin(userId, password));
    }

    @PutMapping("/update/image/{userId}")
    public ResponseEntity<UserResponse> updateImage(@PathVariable String userId, @RequestBody String filePath){
        return ResponseEntity.ok(userService.updateImage(userId, filePath));
    }
}
