package com.example.exception;

public class MessageParametersInvalidException extends RuntimeException{
    public MessageParametersInvalidException(final String msg){
        super(msg);
    }
}
