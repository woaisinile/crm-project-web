package com.yyds.crm.controller;

import com.yyds.crm.common.excel.ExcelUtils;
import com.yyds.crm.common.result.Result;
import com.yyds.crm.pojo.Activity;
import com.yyds.crm.services.ActivityService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
//            for (Activity activity: activities){
//                System.out.println(activity.toString());
//            }
            Integer importCount = activityService.importActivities(activities);
            return Result.ok(importCount);
        } catch (Exception e) {
            return Result.fail("导入失败");
        }
    }
}
