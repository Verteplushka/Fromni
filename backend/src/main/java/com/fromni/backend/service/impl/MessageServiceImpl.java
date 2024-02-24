package com.fromni.backend.service.impl;

import com.fromni.backend.dto.MessageDto;
import com.fromni.backend.entity.Channel;
import com.fromni.backend.entity.Message;
import com.fromni.backend.entity.User;
import com.fromni.backend.logic.UserValidator;
import com.fromni.backend.repository.ChannelRepository;
import com.fromni.backend.repository.MessageRepository;
import com.fromni.backend.repository.UserRepository;
import com.fromni.backend.service.MessageService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MessageServiceImpl implements MessageService {
    private MessageRepository messageRepository;
    private UserRepository userRepository;
    private ChannelRepository channelRepository;
    private PasswordEncoder passwordEncoder;

    @Override
    public Message createMessage(MessageDto messageDto) {
        User foundUser = findAndCheckuser(messageDto.getUser());
        if(foundUser == null){
            return null;
        }
        Channel foundChannel = findChannel(messageDto.getChannelName());
        Message message = new Message(foundUser.getId(), foundChannel.getId(), messageDto.getMessage());
        return messageRepository.save(message);
    }

    private User findAndCheckuser(User user) {
        if(!UserValidator.isValid(user)) return null;
        User foundUser = userRepository.findByLogin(user.getLogin()).orElse(null);
        if (foundUser == null) return null;
        if (passwordEncoder.matches(user.getPassword(), (foundUser.getPassword()))){
            return foundUser;
        }
        return null;
    }

    private Channel findChannel(String channelName){
        return channelRepository.findByName(channelName).orElse(null);
    }
}
