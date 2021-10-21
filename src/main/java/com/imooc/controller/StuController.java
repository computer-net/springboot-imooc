package com.imooc.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("stu")
@Slf4j
public class StuController {
    @GetMapping("{stuId}/get")
    public String getStu(@PathVariable("stuId") String stuId,
                         @RequestParam Integer id,
                         @RequestParam String name) {
        /**
         * @RequestParam 获取url请求参数，若参数变量名保持一致，可以省略忽略
         * */
        log.info("stuId : " + stuId);
        log.info("id : " + id);
        log.info("name : " + name);
        return "查询 Stu";
    }

    @PostMapping("create")
    public String createStu(@RequestBody Map<String, Object> map,
                            @RequestHeader("token") String token,
                            @CookieValue("clientId") String clientId,
                            HttpServletRequest request) {
        log.info("token: " + token);
        log.info("clientId: " + clientId);
        log.info("map: " + map.toString());
        String httpHeadToken = request.getHeader("token");
        log.info("httpHeadToken: " + httpHeadToken);
        return "新增 Stu";
    }

    @PutMapping("update")
    public String updateStu() {
        return "修改 Stu";
    }

    @DeleteMapping("delete")
    public String deleteStu() {
        return "删除 Stu";
    }
}
