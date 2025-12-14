package com.chat_app.chatzy.service;

import com.chat_app.chatzy.dto.MessageDTO;
import com.chat_app.chatzy.model.Message;
import com.chat_app.chatzy.repository.MessageRepository;
import com.chat_app.chatzy.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    private final MessageRepository messageRepo;
    private final UserRepository userRepo;


    public MessageService(MessageRepository messageRepo, UserRepository userRepo) {
        this.messageRepo = messageRepo;
        this.userRepo = userRepo;
    }

    public List<Message> getFilteredMessage(long senderId,long receiverId){
        return  messageRepo.findBySenderIdAndReceiverIdOrSenderIdAndReceiverIdOrderByTimeStampAsc(senderId,receiverId,receiverId,senderId);
    }

//    Messages API functions
    public List<MessageDTO> getMessages(long senderID, long recevierid){
        List<Message> allMessages = getFilteredMessage(senderID,recevierid);
        return allMessages.stream().
                map( message ->
                        new MessageDTO(message.getId(), message.getMessage(),message.getSenderId(), message.getReceiverId())).toList();
    }

    public Message sendMessage(Message message){
        if(message.getMessage() == null || message.getMessage().trim().isEmpty()){
            throw new IllegalArgumentException("You cant send an empty message.");
        } else if (!userRepo.existsById(message.getSenderId())) {
            throw new IllegalArgumentException("username not found please create one.");
        }
        return messageRepo.save(message);
    }


}
