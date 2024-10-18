package com.example.service;

import org.springframework.stereotype.Service;
import com.example.repository.AccountRepository;
import com.example.entity.Account;
import com.example.exception.UserExistsAuthenticationException;
import com.example.exception.AccountDoesNotExistException;
import com.example.exception.InvalidParametersAuthenticationException;

import java.util.Optional;

@Service
public class AccountService {
    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    public Account postNewAccount(Account account){
        
        Optional<Account> userAlreadyExists = accountRepository.findByUsername(account.getUsername());
        
        if(userAlreadyExists.isPresent()){
            throw new UserExistsAuthenticationException("User is already present in database.");
        } 
        if(account.getUsername().isBlank() || account.getPassword().length() < 4){
            throw new InvalidParametersAuthenticationException("User input does not meet username or password requirements.");
        }

        return accountRepository.save(account);
    }

    public Account getExistingAccount(Account account){
        Optional<Account> userExists = accountRepository.findByUsernameAndPassword(account.getUsername(), account.getPassword());
        if(userExists.isEmpty()){
            throw new AccountDoesNotExistException("Account does not exist.");
        }
        return userExists.get();
    }

    public Optional<Account> getAccountById(int id){
        return accountRepository.findById(id);
    }

}
