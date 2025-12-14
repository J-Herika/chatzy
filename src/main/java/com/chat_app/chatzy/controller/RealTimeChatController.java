package com.chat_app.chatzy.controller;

import com.chat_app.chatzy.dto.MessageDTO;
import com.chat_app.chatzy.model.Message;
import com.chat_app.chatzy.service.MessageService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Controller;
import org.springframework.messaging.simp.SimpMessagingTemplate;

@Controller
public class RealTimeChatController {

    private final SimpMessagingTemplate simpMessagingTemplate;
    private final MessageService messageService;


    public RealTimeChatController(MessageService messageService,SimpMessagingTemplate simpMessagingTemplate) {
        this.messageService = messageService;
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    @MessageMapping("/private-messages")
    public Message receiveMessage(@Payload com.chat_app.chatzy.model.Message message){
        com.chat_app.chatzy.model.Message savedMessage = messageService.sendMessage(message);

        // 2. Push to the Receiver
        // Format: /topic/user/{userId}
        // Example: If receiver is 5, topic is /topic/user/5
        simpMessagingTemplate.convertAndSend("topic/user/" + message.getReceiverId(), savedMessage);

        // 3. Optional: Push to the Sender too (so their own screen updates instantly)
        simpMessagingTemplate.convertAndSend("topic/user/" + message.getSenderId(), savedMessage);

        return savedMessage;
    }
}
