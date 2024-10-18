package com.example.exception;

//import org.h2.security.auth.AuthenticationException;

public class InvalidParametersAuthenticationException extends RuntimeException{
    public InvalidParametersAuthenticationException(final String msg){
        super(msg);
    }
}
