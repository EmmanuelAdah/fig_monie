package com.figmonie.utils;

import com.figmonie.dtos.request.RegisterRequest;
import com.figmonie.exceptions.InvalidEmailFormatException;
import com.figmonie.exceptions.InvalidNameFormatException;
import java.util.regex.Pattern;

public class Validator {

    public static void isValidRequest(RegisterRequest request) {
        isValidName(request.getFirstname(), "Firstname");
        isValidName(request.getLastname(), "Lastname");
        isValidEmail(request.getEmail());
    }

    public static void isValidName(String name, String field) {
        String regex = "^[A-Za-z]+\\${3,20}";
        boolean pattern = Pattern.matches(regex, name);
        if(!pattern)
            throw new InvalidNameFormatException("Invalid name format for " + field);
    }

    public static void isValidEmail(String email) {
        String regex = "^[a-zA-Z0-9._%+-]+@([a-zA-Z0-9-]{4,10})\\.[a-zA-Z]{2,3}$";
        boolean pattern = Pattern.matches(regex, email);
        if(!pattern)
            throw new InvalidEmailFormatException("Invalid email format for " + email);
    }
}
