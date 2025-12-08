package com.figmonie.exceptions;

public class InvalidPinFormatException extends RuntimeException {
    public InvalidPinFormatException(String message) {
        super(message);
    }
}
