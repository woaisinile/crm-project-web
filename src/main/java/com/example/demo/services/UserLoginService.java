package com.example.demo.services;

import com.example.demo.pojo.UserLogin;

import java.util.HashMap;
import java.util.List;

public interface UserLoginService {
    public List<UserLogin> queryAll();
    public int addUser(UserLogin userLogin);
    public UserLogin queryByName(String userName);

    UserLogin getUserInfo(HashMap<String, Object> queryMap);
}
