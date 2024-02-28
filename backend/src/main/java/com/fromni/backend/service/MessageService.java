package com.fromni.backend.service;

import com.fromni.backend.dto.MessageDto;
import com.fromni.backend.entity.Channel;
import com.fromni.backend.entity.Message;
import com.fromni.backend.entity.User;

import java.util.List;

public interface MessageService {
    MessageDto createMessage(MessageDto messageDto);
    List<MessageDto> getMessagesByUser(User user);
    MessageDto updateMessage(MessageDto messageDto);
}