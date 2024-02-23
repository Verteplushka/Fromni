package com.fromni.backend.logic;

import com.fromni.backend.entity.User;

public class UserValidator {
    public static boolean isValid(User user){
        return user.getLogin() != null && user.getPassword() != null;
    }
}
