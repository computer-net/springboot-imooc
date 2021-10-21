package com.imooc.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;

//@Configuration     // 标记配置类，使得 SpringBoot 容器可以扫描到
//@EnableScheduling  // 开启定时任务
@Slf4j
public class MyTask {

    // 添加任务，注明任务的运行表达式
    @Scheduled(cron="*/5 * * * * ?")
    public void publisMsg() {
        log.warn("开始执行任务的时间： " + LocalDateTime.now());
    }

}
