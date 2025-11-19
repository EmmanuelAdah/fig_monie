package com.figmonie.exceptions;

public class InvalidNameFormatException extends RuntimeException {
    public InvalidNameFormatException(String message) {
        super(message);
    }
}
