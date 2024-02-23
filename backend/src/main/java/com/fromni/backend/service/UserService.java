package com.fromni.backend.service;

import com.fromni.backend.dto.UserDto;

public interface UserService {
    public boolean checkUser(UserDto userDto);
    public boolean addUser(UserDto userDto);

}
