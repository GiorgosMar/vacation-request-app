package com.vacationRequest.exception;

public class NameAlreadyExistsException extends RuntimeException{
    public NameAlreadyExistsException(String msg) {
        super(msg);
    }
}
