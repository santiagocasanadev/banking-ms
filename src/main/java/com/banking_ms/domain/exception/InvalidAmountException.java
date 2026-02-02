package com.banking_ms.domain.exception;

public class InvalidAmountException extends RuntimeException {

    public InvalidAmountException() {
        super("Invalid amount");
    }
}
