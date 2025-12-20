package com.figmonie.exceptions;

public class UnrecognizedBankNameException extends RuntimeException {
    public UnrecognizedBankNameException(String message) {
        super(message);
    }
}
