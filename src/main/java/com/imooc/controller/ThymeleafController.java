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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.*;

@Controller
@Slf4j
@RequestMapping("thyme")
public class ThymeleafController {

    @GetMapping("hello")
    public String hello(Model model, HttpServletRequest request) {
        String stranger = "Jack";
        model.addAttribute("there", stranger);

        Date birthday = new Date();
        model.addAttribute("birthday", birthday);

        Integer sex = 2;
        model.addAttribute("sex", sex);

        List<String> myList = new ArrayList<>();
        myList.add("Java");
        myList.add("Python");
        myList.add("golang");
        myList.add("HTML");
        myList.add("JavaScript");

        Map<String, Object> myMap = new HashMap<>();
        myMap.put("id", 841941);
        myMap.put("name", stranger);
        myMap.put("sex", "男");
        myMap.put("hobbies", myList);

        model.addAttribute("myList", myList);
        model.addAttribute("myMap", myMap);

        request.setAttribute("englishName", "rocketeerli");
        request.getSession().setAttribute("userToken", UUID.randomUUID().toString());

        return "teacher";
    }

    @Autowired
    private TemplateEngine templateEngine;

    @GetMapping("createHTML")
    @ResponseBody
    public String createHTML(Model model, HttpServletRequest request) throws Throwable {
        String stranger = "Jack";
        model.addAttribute("there", stranger);

        Date birthday = new Date();
        model.addAttribute("birthday", birthday);

        Integer sex = 2;
        model.addAttribute("sex", sex);

        List<String> myList = new ArrayList<>();
        myList.add("Java");
        myList.add("Python");
        myList.add("golang");
        myList.add("HTML");
        myList.add("JavaScript");

        Map<String, Object> myMap = new HashMap<>();
        myMap.put("id", 841941);
        myMap.put("name", stranger);
        myMap.put("sex", "男");
        myMap.put("hobbies", myList);

        model.addAttribute("myList", myList);
        model.addAttribute("myMap", myMap);

        request.setAttribute("englishName", "rocketeerli");
        request.getSession().setAttribute("userToken", UUID.randomUUID().toString());

        // 开始静态化
        Context context = new Context();
        context.setVariable("there", stranger);
        context.setVariable("birthday", birthday);
        context.setVariable("sex", sex);
        context.setVariable("myList", myList);
        context.setVariable("myMap", myMap);
        // 定义 HTML 最终保存生成的位置
        String path = "G:\\projects\\mooc\\imooc-springboot-starter\\src\\main\\resources";
        // 输出
        Writer out = new FileWriter(path + "/techer.html");

        templateEngine.process("teacher", context, out);
        out.close();

        return "ok";
    }

}
