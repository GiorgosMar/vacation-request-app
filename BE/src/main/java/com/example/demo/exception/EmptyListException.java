package com.example.demo.exception;

public class EmptyListException extends RuntimeException{
    public EmptyListException(String msg) {
        super(msg);
    }
}
