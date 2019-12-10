package com.maning.foodstoreweb.service.impl;

import com.maning.foodstoreweb.dto.auto.UserMapper;
import com.maning.foodstoreweb.model.entities.User;
import com.maning.foodstoreweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private  UserMapper userMapper;
    @Override
    public User queryUserCfg(String username) {
        return userMapper.selectByUsername(username);
    }
}
