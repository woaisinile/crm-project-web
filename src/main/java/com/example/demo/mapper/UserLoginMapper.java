package com.example.demo.mapper;

import com.example.demo.pojo.UserLogin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Mapper
@Repository
public interface UserLoginMapper {

    public UserLogin selectUser(HashMap<String, Object> queryMap);
    public List<UserLogin> queryAll();
    public int addUser(UserLogin userLogin);
    public UserLogin queryUser(String userName);
}
