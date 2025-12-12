package com.chat_app.chatzy.repository;

import com.chat_app.chatzy.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}
