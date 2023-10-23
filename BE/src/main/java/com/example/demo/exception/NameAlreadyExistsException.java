package com.example.demo.exception;

public class NameAlreadyExistsException extends RuntimeException{
    public NameAlreadyExistsException(String msg) {
        super(msg);
    }
}
