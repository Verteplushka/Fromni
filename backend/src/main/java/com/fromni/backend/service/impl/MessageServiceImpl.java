package com.fromni.backend.service.impl;

import com.fromni.backend.dto.MessageDto;
import com.fromni.backend.entity.Button;
import com.fromni.backend.entity.Channel;
import com.fromni.backend.entity.Message;
import com.fromni.backend.entity.User;
import com.fromni.backend.logic.UserValidator;
import com.fromni.backend.repository.ButtonRepository;
import com.fromni.backend.repository.ChannelRepository;
import com.fromni.backend.repository.MessageRepository;
import com.fromni.backend.repository.UserRepository;
import com.fromni.backend.service.MessageService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MessageServiceImpl implements MessageService {
    private MessageRepository messageRepository;
    private UserRepository userRepository;
    private ChannelRepository channelRepository;
    private ButtonRepository buttonRepository;
    private PasswordEncoder passwordEncoder;

    @Override
    public Message createMessage(MessageDto messageDto) {
        User foundUser = findAndCheckuser(messageDto.getUser());
        if(foundUser == null){
            return null;
        }
        Channel foundChannel = findChannel(messageDto.getChannelName());
        Message message = new Message(foundUser.getId(), foundChannel.getId(), messageDto.getMessage());
        Message savedMessage = messageRepository.save(message);
        saveButtons(messageDto.getButtons(), message.getId());
        return savedMessage;
    }

    @Override
    public List<Message> getMessageByUserAndChannel(User user, String channelName) {
        User foundUser = findAndCheckuser(user);
        if(foundUser == null) return null;
        Channel foundChannel = findChannel(channelName);

        return messageRepository.findAllByUserIdAndChannelId(foundUser.getId(), foundChannel.getId()).orElse(null);
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

    private void saveButtons(List<Button> buttons, Long id){
        for(Button button : buttons){
            button.setMessageId(id);
            createButton(button);
        }
    }

    private Button createButton(Button button){
        return buttonRepository.save(button);
    }
}
