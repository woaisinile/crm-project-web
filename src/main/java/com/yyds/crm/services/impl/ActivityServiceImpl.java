package com.yyds.crm.services.impl;

import com.yyds.crm.mapper.ActivityMapper;
import com.yyds.crm.services.ActivityService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.UUID;


@Service
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    ActivityMapper activityMapper;

    @Override
    public Integer insertActivity(Map<String, Object> insertInfo) {
        String id = UUID.randomUUID().toString();
        insertInfo.put("id", id);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String createTime = df.format(date);
        insertInfo.put("createTime", createTime);
        return activityMapper.insertActivity(insertInfo);
    }
}
