package com.chat_app.chatzy.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long senderID;
    private long receiverID;
    private String message;
    private LocalDateTime timeStamp;

    public Message() {}

    public Message(String message,long senderID,long receiverID){
        this.message = message;
        this.senderID = senderID;
        this.receiverID = receiverID;
    }

    @PrePersist
    public void setTIme(){
        this.timeStamp = LocalDateTime.now();
    }


    public String getMessage() {return this.message;}
    public void setMessage(String message) {this.message = message;}

    public long getSenderID(){ return this.senderID;}
    public long getId() {return this.id;}
}
