package com.chat_app.chatzy.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    long senderID;
    String message;
    LocalDateTime timeStamp;

    public Message() {}

    public Message(String message,long senderID){
        this.message = message;
        this.senderID = senderID;
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
