package com.example.demo.controller;

import com.example.demo.common.result.Result;
import com.example.demo.pojo.UserLogin;
import com.example.demo.services.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@CrossOrigin
public class LoginController {

    @Autowired
    UserLoginService userLoginService;

    @GetMapping("/login")
    public Result getUserInfo(@RequestParam("username") String username, @RequestParam("password") String password) {

        HashMap<String, Object> queryMap = new HashMap<>();
        queryMap.put("username", username);
        queryMap.put("password", password);
        UserLogin userLogin = userLoginService.getUserInfo(queryMap);
        return Result.ok(userLogin);
    }

}
