package com.chat_app.chatzy.service;

import com.chat_app.chatzy.dto.MessageDTO;
import com.chat_app.chatzy.model.Message;
import com.chat_app.chatzy.repository.MessageRepository;
import com.chat_app.chatzy.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class MessageService {

    private final MessageRepository messageRepo;
    private final UserRepository userRepo;


    public MessageService(MessageRepository messageRepo, UserRepository userRepo) {
        this.messageRepo = messageRepo;
        this.userRepo = userRepo;
    }

//    Messages API functions

    public List<MessageDTO> getMessages(){
        List<Message> allMessages = messageRepo.findAll();
        return allMessages.stream().
                map( message -> new MessageDTO(message.getId(), message.getMessage(),message.getSenderID())).toList();
    }

    public void sendMessage(@RequestBody Message message){
        if(message.getMessage() == null || message.getMessage().trim().isEmpty()){
            throw new IllegalArgumentException("You cant send an empty message.");
        } else if (!userRepo.existsById(message.getSenderID())) {
            throw new IllegalArgumentException("username not found please create one.");
        }
        messageRepo.save(message);
    }


}
