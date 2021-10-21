package com.imooc.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data                 // 生成 Get 和 Set 方法
@ToString             // 生成 toString 方法
@NoArgsConstructor    // 默认构造函数
@AllArgsConstructor   // 全参构造函数
public class Student {
    public String name;
    public Integer age;

}
