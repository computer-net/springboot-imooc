package com.imooc;

import com.imooc.pojo.Stu;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public Stu stu() {
        return new Stu("rocketeerli", 23);
    }
}
