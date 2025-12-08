package com.figmonie.utils;

import com.figmonie.dtos.request.RegisterRequest;
import com.figmonie.exceptions.InvalidAmountException;
import com.figmonie.exceptions.InvalidEmailFormatException;
import com.figmonie.exceptions.InvalidNameFormatException;
import com.figmonie.exceptions.InvalidPinFormatException;

import java.math.BigDecimal;
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
        if(!Pattern.matches(regex, email))
            throw new InvalidEmailFormatException("Invalid email format for " + email);
    }

    public static void isValidPin(String pin){
        String regex = "^[0-9]{4}$";
        if(pin.length() != 4 || !pin.matches(regex))
            throw new InvalidPinFormatException("Pin must contain 4 digits only");
    }

    public static void isValidAccountNumber(String amountNumber){
        String regex = "^[0-9]{11}$";
        if(amountNumber.length() != 11 || !amountNumber.matches(regex))
            throw new InvalidPinFormatException("Account number must contain 11 digits only");
    }

    public static void isValidAmount(BigDecimal amount, BigDecimal balance){
        if (amount.compareTo(BigDecimal.ZERO) <= 0)
            throw new InvalidAmountException("Amount must be greater than zero");

        if (amount.compareTo(balance) > 0)
            throw new InvalidAmountException("Insufficient funds");
    }
}
