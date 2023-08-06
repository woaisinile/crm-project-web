package com.yyds.crm.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Mapper
@Repository
public interface ActivityMapper {
    Integer insertActivity(Map<String, Object> insertInfo);
}
