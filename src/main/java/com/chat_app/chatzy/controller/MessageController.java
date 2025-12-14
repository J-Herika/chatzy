package com.chat_app.chatzy.controller;

import com.chat_app.chatzy.dto.MessageDTO;
import com.chat_app.chatzy.model.Message;
import com.chat_app.chatzy.service.MessageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class MessageController {

    private MessageService messageService;

    public MessageController(MessageService messageService){
        this.messageService = messageService;
    }

    @GetMapping
    public List<MessageDTO> getMessages(){
        return messageService.getMessages();
    }

    @PostMapping
    public void sendMessage(@RequestBody Message newMessage){
        messageService.sendMessage(newMessage);
    }
}
