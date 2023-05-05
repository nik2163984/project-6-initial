package com.example.dictionary.exception;

public class WordNotFoundException extends Exception {

    public WordNotFoundException() {
    }

    public WordNotFoundException(String message) {
        super(message);
    }

    public WordNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public WordNotFoundException(Throwable cause) {
        super(cause);
    }
}
