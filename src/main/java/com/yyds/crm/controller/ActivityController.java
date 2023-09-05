package com.yyds.crm.controller;

import com.yyds.crm.common.excel.ExcelUtils;
import com.yyds.crm.common.result.Result;
import com.yyds.crm.pojo.Activity;
import com.yyds.crm.services.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class ActivityController {

    @Autowired
    ActivityService activityService;

    @PostMapping("/insertActivity")
    public Result insertActivity(@RequestBody Map<String, Object> insertInfo){
        Integer count = activityService.insertActivity(insertInfo);
        return Result.ok(count);
    }

    @PostMapping("/qryActivityPage")
    public Result qryActivityPage(@RequestBody Map<String, Object> qryMap){
        Map<String, Object> retMap = activityService.qryActivityPage(qryMap);
        return Result.ok(retMap);
    }

    @PostMapping("/updateActivity")
    public Result updateActivity(@RequestBody Map<String, Object> updateInfo){
        Integer count = activityService.updateActivity(updateInfo);
        return Result.ok(count);
    }

    @PostMapping("/deleteActivity")
    public Result deleteActivity(@RequestBody Map<String, Object> qryMap){
        Integer count = activityService.deleteActivity(qryMap);
        return Result.ok(count);
    }
    @PostMapping("/importActivity")
    public Result importActivity(@RequestPart("file") MultipartFile file){
        try {
            List<Activity> activities = ExcelUtils.readMultipartFile(file, Activity.class);
            Integer importCount = activityService.importActivities(activities);
            return Result.ok(importCount);
        } catch (Exception e) {
            return Result.fail("导入失败");
        }
    }

    @GetMapping("/exportActivity")
    public Result exportActivity(HttpServletResponse response){
        List<Object> head = Arrays.asList("所有者", "活动名称", "活动描述");
        List<Activity> activities = activityService.qryAllActivities();
        List<List<Object>> sheetDataList = new ArrayList<>();
        sheetDataList.add(head);
        for (Activity activity: activities){
            List<Object> activityData = new ArrayList<>();
            activityData.add(activity.getOwner());
            activityData.add(activity.getName());
            activityData.add(activity.getDescription());
            sheetDataList.add((List<Object>) activityData);
        }
        ExcelUtils.export(response, "市场活动", sheetDataList);
        return Result.ok("导出成功");
    }
}
