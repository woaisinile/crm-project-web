package com.yyds.crm.services.impl;

import com.yyds.crm.mapper.UserMapper;
import com.yyds.crm.pojo.User;
import com.yyds.crm.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public List queryAllUser() {
        return userMapper.selectAllUser();
    }

    @Override
    public User qryUser(HashMap<String, Object> qryMap) {
        return userMapper.selectUser(qryMap);
    }
}
