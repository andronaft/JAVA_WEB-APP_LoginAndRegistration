package com.zuk.service;

import com.zuk.entity.User;

public interface UserService {
    String login(User user);
    String registration(User user);
}
