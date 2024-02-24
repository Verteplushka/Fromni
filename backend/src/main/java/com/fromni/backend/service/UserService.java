package com.fromni.backend.service;

import com.fromni.backend.entity.User;

public interface UserService {
    boolean checkUser(User user);
    boolean addUser(User user);

}
