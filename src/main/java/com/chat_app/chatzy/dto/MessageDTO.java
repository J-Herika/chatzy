package com.chat_app.chatzy.dto;

public record MessageDTO(long id, String message,long senderId,long receiverId) {
}
