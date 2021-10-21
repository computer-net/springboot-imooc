package com.imooc.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "usr")
@PropertySource(value = "classpath:MyConfig.properties", encoding = "utf-8")
public class MyConfig {
    public String name;
    public Integer age;
    public String sex;

//    public MyConfig(String name, Integer age, String sex) {
//        this.name = name;
//        this.age = age;
//        this.sex = sex;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
