package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionHandlingController {
    
    @ExceptionHandler(UserExistsAuthenticationException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public @ResponseBody String handleUserExistsAuth(UserExistsAuthenticationException ex){
        return ex.getMessage();
    }

    @ExceptionHandler(InvalidParametersAuthenticationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody String handleUserExistsAuthenticationException(InvalidParametersAuthenticationException ex){
        return ex.getMessage();
    }

    @ExceptionHandler(AccountDoesNotExistException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public @ResponseBody String handleAccountDoesNotExistException(AccountDoesNotExistException ex){
        return ex.getMessage();
    }

    @ExceptionHandler(MessageParametersInvalidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody String handleMessageParametersInvalidException(MessageParametersInvalidException ex){
        return ex.getMessage();
    }

    @ExceptionHandler(MessageDoesNotExistException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody String handleMessageDoesNotExistException(MessageDoesNotExistException ex){
        return ex.getMessage();
    }
}
