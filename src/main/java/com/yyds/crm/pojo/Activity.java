package com.yyds.crm.pojo;


import com.yyds.crm.common.excel.ExcelImport;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Activity {

    private String id;

    @ExcelImport("所有者")
    private String owner;

    private String ownerId;

    @ExcelImport("活动名称")
    private String name;

    private String startDate;

    private String endDate;

    private String cost;

    @ExcelImport("活动描述")
    private String description;

    private String createTime;

    private String createBy;

    private String editTime;
    
    private String editBy;
}
