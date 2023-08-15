package com.yyds.crm.services.impl;

import com.yyds.crm.mapper.ActivityMapper;
import com.yyds.crm.services.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;


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

    @Override
    public Map qryActivityPage(Map<String, Object> qyrMap) {
        int pageNo = (int) qyrMap.get("pageNo");
        int pageSize = (int) qyrMap.get("pageSize");
        int beginNo = (pageNo - 1) * pageSize;
        qyrMap.put("beginNo", beginNo);
        qyrMap.put("pageSize", pageSize);
        List activityPage = activityMapper.selectActivityPage(qyrMap);
        Integer activityPageCount = activityMapper.selectActivityPageCount(qyrMap);
        Map<String, Object> retMap = new HashMap<>();
        retMap.put("activityPage", activityPage);
        retMap.put("activityPageCount", activityPageCount);
        return retMap;
    }

    @Override
    public Integer updateActivity(Map<String, Object> updateInfo) {
        Integer count = activityMapper.updateActivity(updateInfo);
        return count;
    }

}
