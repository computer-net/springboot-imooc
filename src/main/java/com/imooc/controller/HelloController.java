package com.imooc.controller;

import com.imooc.pojo.MyConfig;
import com.imooc.pojo.Stu;
import com.imooc.pojo.Student;
import com.imooc.utils.JsonResult;
import com.imooc.utils.MyAsyncTask;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

//@Controller
@RestController
@Slf4j
public class HelloController {
//    @RequestMapping("hello")
//    @ResponseBody
    @GetMapping("hello")
//    @PostMapping("hello")
    public String hello() {
        return  "Hello World ~";
    }

    @Autowired
    private Stu stu;
    @GetMapping("getStu")
    public Object getStu() {
        return stu;
    }

    @Autowired
    private MyAsyncTask myAsyncTask;

    @Autowired
    private MyConfig myConfig;
    @GetMapping("getMyConfig")
    public Object getMyConfig() {
        myAsyncTask.publisMsg();
        log.info("跳过异步任务的执行");
        return myConfig;
    }

    @Value("${app.name}")
    private String appName;
    @Value("${com.imooc.host}")
    private String host;
    @Value("${com.imooc.port}")
    private String port;
    @Value("${com.imooc.name}")
    private String imoocName;

    @GetMapping("getValue")
    public Object getValue() {
        return appName + ";\t" + host + ":" + port + ";\t" + imoocName;
    }

    @GetMapping("getStudent")
    public JsonResult getStudent() {
        Student student = new Student();
        student.setAge(22);
        student.setName("imooc");
        System.out.println(student.toString());
        Student stu = new Student("lalal", 33);
        System.out.println(stu);

        log.debug(stu.toString());
        log.info(stu.toString());
        log.warn(stu.toString());
        log.error(stu.toString());

        return JsonResult.ok(stu);
    }

    @PostMapping("upload")
    public String upload(MultipartFile file) throws Exception {
        file.transferTo(new File("G:\\projects\\mooc\\" + file.getOriginalFilename()));
        return "上传成功";
    }

}
