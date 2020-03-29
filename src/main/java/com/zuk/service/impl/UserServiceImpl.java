package com.zuk.service.impl;

import com.zuk.dao.impl.UserDaoImpl;
import com.zuk.entity.User;
import com.zuk.service.UserService;

public class UserServiceImpl implements UserService {
    UserDaoImpl userDao = new UserDaoImpl();
    @Override
    public String login(User user) {
        User findUser = userDao.findByLogin(user.getLogin());
        if(findUser!=null){
            if(findUser.getPassword().equals(user.getPassword())){
                return "life is beautiful";
            }
        }
        return "do not give up";
    }

    @Override
    public String registration(User user) {
        User findUser = userDao.findByLogin(user.getLogin());
        if(findUser==null) {
            userDao.save(user);
            return "life is beautiful";
        }
        return "this login is not available";
    }
}
