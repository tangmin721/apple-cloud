package com.cachexic.cloud.provider.order.service;

import com.cachexic.cloud.common.junit.TestParent;
import com.cachexic.cloud.common.utils.date.DateUtil;
import com.cachexic.cloud.common.utils.json.JsonUtil;
import com.cachexic.cloud.feign.order.entity.Teacher;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author tangmin
 * @Description:
 * @date 2017-09-11 18:46:24
 */
public class TeacherServiceTest extends TestParent {

    @Autowired
    private TeacherService teacherService;

    @Test
    public void insert(){
        Teacher teacher = new Teacher();
        teacher.setBirthday(DateUtil.parseDate("2017-01-23"));
        teacher.setScore(100L);
        Long insert = teacherService.insert(teacher);
        System.out.println("id:"+insert);
        Assert.assertTrue(insert.longValue()>0);
    }

    @Test
    public void update(){
        Teacher teacher = new Teacher();
        teacher.setId(1L);
        teacher.setBirthday(DateUtil.parseDate("2017-01-23"));
        teacher.setScore(103L);
        teacherService.update(teacher);
    }

    @Test
    public void select(){
        System.out.println("id:"+ JsonUtil.toJson(teacherService.selectById(4L)));
    }

}