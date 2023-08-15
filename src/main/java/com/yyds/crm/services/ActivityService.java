package com.yyds.crm.services;

import java.util.List;
import java.util.Map;

public interface ActivityService {
    Integer insertActivity(Map<String, Object> insertInfo);

    Map qryActivityPage(Map<String, Object> qyrMap);

    Integer updateActivity(Map<String, Object> updateInfo);
}
