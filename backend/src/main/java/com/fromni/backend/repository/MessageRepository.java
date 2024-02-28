package com.fromni.backend.repository;

import com.fromni.backend.entity.Channel;
import com.fromni.backend.entity.Message;
import com.fromni.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MessageRepository extends JpaRepository<Message, Long> {
    Optional<Message> findByUserIdAndChannelId(Long userId, Long channelId);
    Optional<List<Message>> findByUserId(Long userId);

}
