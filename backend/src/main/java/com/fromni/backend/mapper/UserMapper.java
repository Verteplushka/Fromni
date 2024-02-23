package com.fromni.backend.mapper;

import com.fromni.backend.dto.UserDto;
import com.fromni.backend.entity.User;

public class UserMapper {
    public static UserDto mapToDtoUser(User user){
        return new UserDto(user.getId(), user.getLogin(), user.getPassword());
    }

    public static User mapToUser(UserDto userDto){
        return new User(userDto.getId(), userDto.getLogin(), userDto.getPassword());
    }
}
