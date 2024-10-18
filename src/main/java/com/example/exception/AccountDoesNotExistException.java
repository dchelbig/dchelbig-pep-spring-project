package com.example.exception;

public class AccountDoesNotExistException extends RuntimeException{
    public AccountDoesNotExistException(final String msg){
        super(msg);
    }
}
