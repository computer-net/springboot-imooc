package com.imooc.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.imooc.mapper.DbStuMapper;
import com.imooc.mapper.DbStuMapperCustom;
import com.imooc.pojo.DbStu;
import com.imooc.pojo.Stu;
import com.imooc.service.StuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class StuServiceImpl implements StuService {

    @Autowired
    private DbStuMapper dbStuMapper;

    @Autowired
    private DbStuMapperCustom dbStuMapperCustom;

    @Override
    public void saveStu(DbStu dbStu) {
        dbStuMapper.insert(dbStu);
    }

    @Override
    public DbStu queryById(String id) {
        DbStu dbStu = dbStuMapper.selectByPrimaryKey(id);
        return dbStu;
    }

    @Override
    public List<DbStu> queryByCondition(String name, Integer sex) {
        // 方法一： Example 方法
        //        Example example = new Example(DbStu.class);
//        Example.Criteria criteria = example.createCriteria();
//        criteria.andEqualTo("name", name);
////        criteria.andEqualTo("sex", sex);
//        List<DbStu> dbStuList = dbStuMapper.selectByExample(example);
        // 方法二： 条件查询
        DbStu dbStu = new DbStu();
        dbStu.setName(name);
        List<DbStu> dbStuList = dbStuMapper.select(dbStu);
        return dbStuList;
    }

    @Override
    public List<DbStu> queryByCondition(String name, Integer sex, Integer page, Integer pageSize) {
        // 开始分页
        PageHelper.startPage(page, pageSize);
        // 条件对象
        DbStu stu = new DbStu();
        stu.setName(name);
        stu.setSex(sex);
        // 开始查询
        List<DbStu> dbStuList = dbStuMapper.select(stu);
        PageInfo<?> pageListInfo = new PageInfo<>(dbStuList);
        log.info(pageListInfo.toString());
        return dbStuList;
    }

    @Override
    public void updateStu(DbStu dbStu) {
        dbStuMapper.updateByPrimaryKey(dbStu);
    }

    @Override
    public void deleteStu(DbStu dbStu) {
        // 删除对象/数据的三种方式
        // 1. 根据主键删除
//        dbStuMapper.deleteByPrimaryKey(dbStu.getId());
        // 2. 根据对象条件删除
//        dbStuMapper.delete(dbStu);
        // 3. 根据构建的 example 进行条件删除
        Example example = new Example(DbStu.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("name", dbStu.getName());
        dbStuMapper.deleteByExample(example);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void testTrans() {
        // 1. 新增数据
        // 2. 修改数据
        // 3. 模拟发生异常
        // 4. 观察 1 和 2 步骤的数据变动是否影响到了数据库
        // 5. 处理事务，事务回滚，不允许先前的数据入库
        String sid = UUID.randomUUID().toString();
        DbStu stu = new DbStu();
        stu.setId(sid);
        stu.setName("imooc");
        stu.setSex(1);

        dbStuMapper.insert(stu);

        int a = 100 / 0;

        DbStu dbStu = new DbStu();
        dbStu.setId("7f59a897-b28e-45c3-8d44-6a20aa02160e");
        dbStu.setName("imooc");
        dbStu.setSex(2);
        dbStuMapper.updateByPrimaryKeySelective(dbStu);
    }

    @Override
    public DbStu queryByIdCustom(String id) {
        List<DbStu> dbStuList = dbStuMapperCustom.getStuById(id);
        if (dbStuList != null && !dbStuList.isEmpty()) {
            return dbStuList.get(0);
        }
        return null;
    }
}
