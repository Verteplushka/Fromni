package com.fromni.backend.service;

import com.fromni.backend.dto.MessageDto;
import com.fromni.backend.entity.Message;

public interface MessageService {
    Message createMessage(MessageDto messageDto);
}