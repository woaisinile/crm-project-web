package com.yyds.crm.mapper;

import com.yyds.crm.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    public List selectAllUser();

    User selectUser(HashMap<String, Object> qryMap);
}
