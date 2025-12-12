package com.chat_app.chatzy.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String message;
    String sender;
    LocalDateTime timeStamp;

    public Message() {}

    public Message(String message,String sender){
        this.message = message;
        this.sender = sender;
    }

    @PrePersist
    public void setTIme(){
        this.timeStamp = LocalDateTime.now();
    }


    public String getMessage() {return this.message;}
    public void setMessage(String message) {this.message = message;}

    public String getSender(){ return this.sender;}
    public long getId() {return this.id;}
}
