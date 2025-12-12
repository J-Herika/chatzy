package com.chat_app.chatzy.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String message;

    public Message() {}

    public Message(String message){
        this.message = message;
    }


    public String getMessage() {return message;}
    public void setMessage(String message) {this.message = message;}

    public long getId() {return id;}
}
