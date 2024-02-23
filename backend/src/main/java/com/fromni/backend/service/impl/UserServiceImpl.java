package com.fromni.backend.service.impl;

import com.fromni.backend.dto.UserDto;
import com.fromni.backend.entity.User;
import com.fromni.backend.logic.UserValidator;
import com.fromni.backend.mapper.UserMapper;
import com.fromni.backend.repository.UserRepository;
import com.fromni.backend.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    @Override
    public boolean checkUser(UserDto userDto) {
        User user = UserMapper.mapToUser(userDto);
        if(!UserValidator.isValid(user)) return false;
        User userFromTable = userRepository.findByLogin(user.getLogin()).orElse(null);
        if(userFromTable == null){
            return false;
        }
        return passwordEncoder.matches(user.getPassword(), (userFromTable.getPassword()));
    }

    @Override
    public boolean addUser(UserDto userDto) {
        User user = UserMapper.mapToUser(userDto);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User userFromTable = userRepository.findByLogin(user.getLogin()).orElse(null);
        if(userFromTable != null){
            return false;
        }
        User savedUser = userRepository.save(user);
        return true;
    }
}
