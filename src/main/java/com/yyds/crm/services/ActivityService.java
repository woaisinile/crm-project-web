package com.yyds.crm.services;

import com.yyds.crm.pojo.Activity;

import java.util.List;
import java.util.Map;

public interface ActivityService {
    Integer insertActivity(Map<String, Object> insertInfo);

    Map qryActivityPage(Map<String, Object> qyrMap);

    Integer updateActivity(Map<String, Object> updateInfo);

    Integer deleteActivity(Map<String, Object> qryMap);

    Integer importActivities(List<Activity> activities);

    List<Activity> qryAllActivities();
}
