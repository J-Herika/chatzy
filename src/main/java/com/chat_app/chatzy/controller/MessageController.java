package com.chat_app.chatzy.controller;

import com.chat_app.chatzy.dto.MessageDTO;
import com.chat_app.chatzy.model.Message;
import com.chat_app.chatzy.service.MessageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService){
        this.messageService = messageService;
    }

    @GetMapping("/api/messages")
    public List<MessageDTO> getMessages(){
        return messageService.getMessages();
    }

    @PostMapping("/api/messages")
    public void sendMessage(@RequestBody Message newMessage){
        messageService.sendMessage(newMessage);
    }
}
