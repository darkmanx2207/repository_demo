package com.javaguru.shoppinglist.service.validation;


public class ValidationException extends RuntimeException {
    public ValidationException(String message) {
        super(message);
    }
}