package com.fromni.backend.service;

import com.fromni.backend.entity.User;

public interface UserService {
    public boolean checkUser(User user);
    public boolean addUser(User user);

}
