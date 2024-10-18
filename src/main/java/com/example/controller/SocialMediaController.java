package com.example.controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import com.example.service.AccountService;
import com.example.entity.Account;
import com.example.service.MessageService;
import com.example.entity.Message;
import com.example.exception.MessageParametersInvalidException;

import java.util.List;
import java.util.Optional;

@Controller
public class SocialMediaController {

    private AccountService accountService;
    private MessageService messageService;

    public SocialMediaController(AccountService accountService, MessageService messageService) {
        this.accountService = accountService;
        this.messageService = messageService;
    }

    @PostMapping("/register")
    public @ResponseBody Account postAccount(@RequestBody Account register){
        return accountService.postNewAccount(register);
    }

    @PostMapping("/login")
    public @ResponseBody Account getAccount(@RequestBody Account login){
        return accountService.getExistingAccount(login);
    }

    @PostMapping("/messages")
    public @ResponseBody Message postMessage(@RequestBody Message newPost){
        Optional<Account> acc = accountService.getAccountById(newPost.getPostedBy());
        if(acc.isEmpty()){
            throw new MessageParametersInvalidException("Parameter postedBy does not match an existing account.");
        }
        return messageService.postNewMessage(newPost);
    }

    @GetMapping("/messages")
    public @ResponseBody List<Message> getAllMessages(){
        return messageService.getMessages();
    }

    @GetMapping("/messages/{messageId}")
    public @ResponseBody Message getMessageById(@PathVariable int messageId){
        return messageService.getMessageById(messageId);
    }

    @DeleteMapping("/messages/{messageId}")
    public @ResponseBody Integer deleteMessageById(@PathVariable int messageId){
        return messageService.deleteMessageById(messageId);
    }

    @PatchMapping("/messages/{messageId}")
    public @ResponseBody Integer patchMessageById(@PathVariable int messageId, @RequestBody Message newText){
        return messageService.patchMessageById(messageId, newText);
    }

    @GetMapping("/accounts/{accountId}/messages")
    public @ResponseBody List<Message> getMessagesByPostedBy(@PathVariable int accountId){
        return messageService.getMessagesByPostedBy(accountId);
    }
}
