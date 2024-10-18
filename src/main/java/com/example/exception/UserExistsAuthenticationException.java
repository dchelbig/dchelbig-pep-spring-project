package com.example.exception;

//import org.h2.security.auth.AuthenticationException;

public class UserExistsAuthenticationException extends RuntimeException{
    public UserExistsAuthenticationException(final String msg){
        super(msg);
    }
    
}
