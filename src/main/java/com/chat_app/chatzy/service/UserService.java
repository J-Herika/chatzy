package com.chat_app.chatzy.service;

import com.chat_app.chatzy.dto.UserDTO;
import com.chat_app.chatzy.model.User;
import com.chat_app.chatzy.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class UserService {

    UserRepository userRepo;

    public UserService(UserRepository userRepo){
        this.userRepo = userRepo;
    }

    public List<UserDTO> getUsers(){
        return userRepo.findAll().stream().
                map( user -> new UserDTO(user.getId(), user.getUsername())).toList();
    }

    public UserDTO createUser( User newUser){
        if(newUser.getUsername() == null || newUser.getUsername().trim().isEmpty()){
            throw new IllegalArgumentException("Username cannot be empty");
        }
        User nUser = userRepo.save(newUser);
        return new UserDTO(nUser.getId(),nUser.getUsername());
    }

}
