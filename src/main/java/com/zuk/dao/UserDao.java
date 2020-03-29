package com.zuk.dao;

import com.zuk.entity.User;

public interface UserDao {
    User findByLogin(String login);
    Boolean save(User user);
}
