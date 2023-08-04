package com.yyds.crm.controller;


import com.yyds.crm.common.result.Result;
import com.yyds.crm.pojo.User;
import com.yyds.crm.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/queryAllUsers")
    public Result queryAllUsers(){
        List Users = userService.queryAllUser();
        return Result.ok(Users);
    }

    @GetMapping("/login")
    public Result getLogin(@RequestParam("loginAct") String loginAct,
                           @RequestParam("loginPwd") String loginPwd) {
        HashMap<String, Object> qryMap = new HashMap<>();
        qryMap.put("loginAct", loginAct);
        qryMap.put("loginPwd", loginPwd);
        User user = userService.qryUser(qryMap);
        return Result.ok(user);
    }
}
