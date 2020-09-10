package com.example.exception;

public class ExchangeValueNotFound extends RuntimeException {

    public ExchangeValueNotFound(String message) {
        super(message);
    }

}
