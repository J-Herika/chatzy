package com.chat_app.chatzy.controller;

import com.chat_app.chatzy.dto.MessageDTO;
import com.chat_app.chatzy.model.Message;
import com.chat_app.chatzy.service.MessageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService){
        this.messageService = messageService;
    }

    @GetMapping("/api/messages")
    public List<MessageDTO> getMessages(@RequestParam long senderID,@RequestParam long receiverID){
    return messageService.getMessages(senderID,receiverID);
    }

    @PostMapping("/api/messages")
    public Message sendMessage(@RequestBody Message newMessage){
        return messageService.sendMessage(newMessage);
    }
}
