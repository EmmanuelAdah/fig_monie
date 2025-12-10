package com.figmonie.utils;

import com.figmonie.exceptions.*;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidAmountException.class)
    public Map<String, String> handleInvalidAmountException(InvalidAmountException ex) {
        Map<String, String> message = new HashMap<>();
        message.put("message", ex.getMessage());
        return message;
    }

    @ExceptionHandler(InvalidCredentialsException.class)
    public Map<String, String> handleInvalidCredentialsException(InvalidCredentialsException ex) {
        Map<String, String> message = new HashMap<>();
        message.put("message", ex.getMessage());
        return message;
    }

    @ExceptionHandler(InvalidEmailFormatException.class)
    public Map<String, String> handleInvalidEmailFormatException(InvalidEmailFormatException ex) {
        Map<String, String> message = new HashMap<>();
        message.put("message", ex.getMessage());
        return message;
    }

    @ExceptionHandler(InvalidNameFormatException.class)
    public Map<String, String> handleInvalidNameFormatException(InvalidNameFormatException ex) {
        Map<String, String> message = new HashMap<>();
        message.put("message", ex.getMessage());
        return message;
    }

    @ExceptionHandler(InvalidPinFormatException.class)
    public Map<String, String> handleInvalidPinFormatException(InvalidPinFormatException ex) {
        Map<String, String> message = new HashMap<>();
        message.put("message", ex.getMessage());
        return message;
    }

    @ExceptionHandler(UserAlreadyExistException.class)
    public Map<String, String> handleUserAlreadyExistException(UserAlreadyExistException ex) {
        Map<String, String> message = new HashMap<>();
        message.put("message", ex.getMessage());
        return message;
    }
}
