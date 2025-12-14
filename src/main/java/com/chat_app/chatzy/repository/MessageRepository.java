package com.chat_app.chatzy.repository;

import com.chat_app.chatzy.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findBySenderIdAndReceiverIdOrSenderIdAndReceiverIdOrderByTimeStampAsc(
            Long sender1, Long receiver1,
            Long sender2, Long receiver2
    );
}
