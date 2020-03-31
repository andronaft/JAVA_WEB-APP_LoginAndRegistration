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
            if(DigestUtils.md5DigestAsHex((user.getPassword()).getBytes()).equals(findUser.getPassword())){
                return "life is beautiful," + "your Id: " + findUser.getId();
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
