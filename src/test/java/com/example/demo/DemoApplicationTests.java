package com.example.demo;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;

@SpringBootTest
@MapperScan(basePackages = {"com.example.demo.mapper"})
class DemoApplicationTests {
    @Test
    void contextLoads() {
    }

}
