package com.chat_app.chatzy.repository;

import com.chat_app.chatzy.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MessageRepository extends JpaRepository<Message, Long> {
}
