package com.imooc.controller;

import com.github.pagehelper.PageHelper;
import com.imooc.pojo.DbStu;
import com.imooc.pojo.bo.DbStuBO;
import com.imooc.service.StuService;
import com.imooc.utils.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@Slf4j
@RequestMapping("dbStu")
public class DBStuController {

    @Autowired
    private StuService stuService;

    @PostMapping("create")
    public JsonResult createDbStu() {
        String sid = UUID.randomUUID().toString();
        DbStu dbStu = new DbStu();
        dbStu.setId(sid);
        dbStu.setName("rocketeerli");
        dbStu.setSex(1);
        stuService.saveStu(dbStu);
        return JsonResult.ok();
    }

    @PostMapping("create2")
    public JsonResult create2(@Valid @RequestBody DbStuBO stuBO,
                                BindingResult result) {
        // 判断 BingdingResult 是否有错误
        if (result.hasErrors()) {
            Map<String, String> map = getErrors(result);
            return JsonResult.errorMap(map);
        }
        String sid = UUID.randomUUID().toString();
        DbStu dbStu = new DbStu();
        BeanUtils.copyProperties(stuBO, dbStu);
        dbStu.setId(sid);
        stuService.saveStu(dbStu);
        return JsonResult.ok();
    }

    public Map<String, String> getErrors(BindingResult result) {
        Map<String, String> map = new HashMap<>();
        List<FieldError> errorList = result.getFieldErrors();
        for (FieldError fieldError : errorList){
            String field = fieldError.getField();
            String msg = fieldError.getDefaultMessage();
            map.put(field, msg);
        }
        return map;
    }

    @GetMapping("getById")
    public JsonResult getStuById(@RequestParam String id) {
        DbStu dbStu = stuService.queryById(id);
//        return JsonResult.ok(dbStu);

        DbStu dbStu2 = stuService.queryByIdCustom(id);
        return JsonResult.ok(dbStu2);
    }

    @GetMapping("get")
    public JsonResult getStuListById() {
        List<DbStu> dbStuList = stuService.queryByCondition("rocketeerli", 1);
        return JsonResult.ok(dbStuList);
    }

    @GetMapping("getPages")
    public JsonResult getStuPages(@RequestParam(defaultValue = "1") int pageNo,
                                  @RequestParam(defaultValue = "2") int pageSize) {
        List<DbStu> dbStuList = stuService.queryByCondition("rocketeerli", 0, pageNo, pageSize);
        return JsonResult.ok(dbStuList);
    }

    @GetMapping("update")
    public JsonResult updateStu() {

        DbStu stu = new DbStu();
        stu.setId("7f59a897-b28e-45c3-8d44-6a20aa02160e");
        stu.setName("update name");
        stu.setSex(2);

        stuService.updateStu(stu);

        return JsonResult.ok();
    }

    @GetMapping("delete")
    public JsonResult deleteStu(@RequestParam(defaultValue = "") String id,
                                @RequestParam(defaultValue = "2") Integer sex,
                                @RequestParam(defaultValue = "lgj") String name) {
        DbStu stu = new DbStu();
//        stu.setId(id);
//        stu.setSex(sex);
        stu.setName(name);
        stuService.deleteStu(stu);
        return JsonResult.ok();
    }

    @GetMapping("testTrans")
    public JsonResult testTrans() {
        stuService.testTrans();
        return JsonResult.ok();
    }
}
