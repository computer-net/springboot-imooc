package com.imooc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * 1. 表明当前项目是 SpringBoot 工程，启动类
 * 2. 需要放在根包路径下（com.imooc）默认扫描 Controller Service 和 Mapper，放到容器中
 * */
@SpringBootApplication
@MapperScan(basePackages = "com.imooc.mapper")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
