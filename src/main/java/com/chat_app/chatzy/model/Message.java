package com.chat_app.chatzy.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long senderId;
    private long receiverId;
    private String message;
    private LocalDateTime timeStamp;

    public Message() {}

    public Message(String message,long senderId,long receiverId){
        this.message = message;
        this.senderId = senderId;
        this.receiverId = receiverId;
    }

    @PrePersist
    public void setTIme(){
        this.timeStamp = LocalDateTime.now();
    }


    public String getMessage() {return this.message;}
    public void setMessage(String message) {this.message = message;}

    public long getSenderId(){ return this.senderId;}
    public long getId() {return this.id;}

    public long getReceiverId() {return receiverId;}
    public void setReceiverId(long receiverID) {this.receiverId = receiverID;}
}
