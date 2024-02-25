package com.fromni.backend.service;

import com.fromni.backend.dto.MessageDto;
import com.fromni.backend.entity.Channel;
import com.fromni.backend.entity.Message;
import com.fromni.backend.entity.User;

import java.util.List;

public interface MessageService {
    Message createMessage(MessageDto messageDto);
    List<Message> getMessageByUserAndChannel(User user, String channelName);
}