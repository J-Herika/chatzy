package com.chat_app.chatzy.model;

import jakarta.persistence.*;

@Entity(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(unique = true, nullable = false)
    String username;

    public User(){}

    public User(String username){
        this.username = username;
    }

    public String getUsername() {return this.username;}
    public void setUsername(String username) {this.username = username;}

    public long getId() {return id;}
}
