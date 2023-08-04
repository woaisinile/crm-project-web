package com.yyds.crm.services;

import com.yyds.crm.pojo.User;

import java.util.HashMap;
import java.util.List;

public interface UserService {
    public List queryAllUser();

    User qryUser(HashMap<String, Object> qryMap);
}
