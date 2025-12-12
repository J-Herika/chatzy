package com.chat_app.chatzy.controller;

import com.chat_app.chatzy.dto.UserDTO;
import com.chat_app.chatzy.model.User;
import com.chat_app.chatzy.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class UserController {

    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public List<UserDTO> getUsers(){
        return userService.getUsers();
    }

    @PostMapping
    public UserDTO createUser(@RequestBody User newUser){
        return userService.createUser(newUser);
    }

}
