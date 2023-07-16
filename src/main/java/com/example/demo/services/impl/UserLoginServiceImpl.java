package com.example.demo.services.impl;

import com.example.demo.mapper.UserLoginMapper;
import com.example.demo.pojo.UserLogin;
import com.example.demo.services.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserLoginServiceImpl implements UserLoginService {

    @Autowired
    UserLoginMapper userLoginMapper;

    @Override
    public List<UserLogin> queryAll() {
        return userLoginMapper.queryAll();
    }

    @Override
    public int addUser(UserLogin userLogin) {
        return userLoginMapper.addUser(userLogin);
    }

    @Override
    public UserLogin queryByName(String userName) {
        return userLoginMapper.queryUser(userName);
    }
}
