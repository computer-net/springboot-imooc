package com.imooc.service;

import com.imooc.pojo.DbStu;

import java.util.List;

public interface StuService {

    /**
     * 新增 stu 到数据库
     * @param dbStu
     */
    public void saveStu(DbStu dbStu);

    /**
     * 根据主键查询对象信息
     * @param id
     * @return
     */
    public DbStu queryById(String id);

    /**
     * 根据条件查询 stu list 的结果集
     * @param name
     * @param sex
     * @return
     */
    public List<DbStu> queryByCondition(String name, Integer sex);

    /**
     * 分页查询
     * @param name
     * @param sex
     * @param page: 第几页
     * @param pageSize: 每一页有多少条数据
     * @return
     */
    public List<DbStu> queryByCondition(String name,
                                        Integer sex,
                                        Integer page,
                                        Integer pageSize);

    /**
     * 修改 stu 到数据库
     * @param dbStu
     */
    public void updateStu(DbStu dbStu);

    /**
     * 根据条件删除 stu
     * @param dbStu
     */
    public void deleteStu(DbStu dbStu);

    /**
     * 演示事务
     */
    public void testTrans();

    /**
     * 根据主键查询对象信息
     * @param id
     * @return
     */
    public DbStu queryByIdCustom(String id);
}
