package com.example.demo.controller;

import com.example.demo.pojo.UserLogin;
import com.example.demo.services.UserLoginService;
import com.example.demo.services.impl.UserLoginServiceImpl;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Api(tags = "测试登陆")
@RequestMapping("/user")
public class MyController {
    @Autowired
    UserLoginService userLoginService;

    @GetMapping("/queryAll")
    public List<UserLogin> queryAll(){
        return userLoginService.queryAll();
    }

}
