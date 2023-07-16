package com.example.demo.controller;

import com.example.demo.mapper.UserMapper;
import com.example.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class DemoController {
    @Autowired
    private UserMapper userMapper;

    @GetMapping("/hello")
    public List<User> hello(){
        List<User> users = userMapper.selectUserList();
        return users;
    }

    @GetMapping("/getlist/{username}")
    public User getList(@PathVariable String username){
        User user = userMapper.selectByName(username);
        return user;
    }
}
