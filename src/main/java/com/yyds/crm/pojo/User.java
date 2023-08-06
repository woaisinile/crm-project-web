package com.yyds.crm.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    private String id;

    private String loginAct;
    private String name;
    private String loginPwd;
    private String email;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date expireTime;
    private String lockState;
    private String deptno;
    private String allowIps;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    private String createBy;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date editTime;
    private String editBy;
}
