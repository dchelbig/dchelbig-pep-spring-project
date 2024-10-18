package com.example.service;

import org.springframework.stereotype.Service;
import com.example.repository.MessageRepository;
import com.example.entity.Message;
import com.example.exception.MessageDoesNotExistException;
import com.example.exception.MessageParametersInvalidException;

import java.util.Optional;
import java.util.List;

@Service
public class MessageService {
    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository){
        this.messageRepository = messageRepository;
    }
    
    public Message postNewMessage(Message message){
        if(message.getMessageText().isBlank() || message.getMessageText().length() > 255){
            throw new MessageParametersInvalidException("Message text does not meet requirements");
        }      
        return messageRepository.save(message);
    }

    public List<Message> getMessages(){
        return messageRepository.findAll();
    }

    public Message getMessageById(int id){
        Optional<Message> message = messageRepository.findById(id);
        if(message.isEmpty()){
            return null;
        }
        return message.get();
    }

    public Integer deleteMessageById(int id){
        Optional<Message> message = messageRepository.findById(id);
        if(message.isEmpty()){
            return null;
        }
        messageRepository.deleteById(id);
        return 1;
    }

    public Integer patchMessageById(int id, Message messageText){
        Optional<Message> optionalMessage = messageRepository.findById(id);
        if(optionalMessage.isEmpty()){
            throw new MessageDoesNotExistException("Message specified by messageId does not exist.");
        }
        if(messageText.getMessageText().isBlank() || messageText.getMessageText().length() >= 255){
            throw new MessageParametersInvalidException("New message text does not meet requirements.");
        }

        Message message = optionalMessage.get();
        message.setMessageText(messageText.getMessageText());
        return 1;
    }

    public List<Message> getMessagesByPostedBy(int postedBy){
        return messageRepository.findAllByPostedBy(postedBy);
    }
}
