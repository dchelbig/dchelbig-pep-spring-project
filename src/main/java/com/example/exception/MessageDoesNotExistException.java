package com.example.exception;

public class MessageDoesNotExistException extends RuntimeException{
    public MessageDoesNotExistException(final String msg){
        super(msg);
    }
    
}
