package com.cachexic.cloud.provider.order.controller;

import com.cachexic.cloud.common.base.Result;
import com.cachexic.cloud.common.base.entity.query.Pagination;
import com.cachexic.cloud.feign.order.entity.Teacher;
import com.cachexic.cloud.feign.order.entity.query.TeacherQuery;
import com.cachexic.cloud.provider.order.service.TeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.concurrent.Callable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tangmin
 * @Description: 接口异步化
 * @date 2017-09-27 15:24:03
 */
@Api(description = "接口异步化测试")
@RestController
@RequestMapping("/asyncTeacher")
public class AsyncTeacherController {
    private static final Logger log = LoggerFactory.getLogger(AsyncTeacherController.class);

    @Autowired
    private TeacherService teacherService;

    @ApiOperation("getById:根据主键查询")
    @GetMapping("id/{id}")
    public Callable<Result<Teacher>> getById(@PathVariable("id") Long id){
        log.info("*********主线程开始*********");
        Callable<Result<Teacher>> resultCallable = () -> {
            log.info("*********callable线程开始*********");
            Result result = Result.OK().setData(teacherService.selectById(id));
            Thread.sleep(1000);
            log.info("*********callable线程返回*********");
            return result;
        };
        log.info("*********主线程返回*********");

        return resultCallable;
    }

    @PostMapping("pagination")
    @ApiOperation(value = "pagination:分页查询", notes = "带分页信息的Pagination对象")
    public Callable<Result<Pagination<Teacher>>> pagination(@RequestBody TeacherQuery query){
        log.info("*********主线程开始*********");
        Callable<Result<Pagination<Teacher>>> resultCallable = () -> {
            log.info("*********callable线程开始*********");
            Result result = Result.OK().setData(teacherService.selectListPagination(query));

            Thread.sleep(2000);

            log.info("*********callable线程返回*********");
            return result;
        };
        log.info("*********主线程返回*********");
        return resultCallable;
    }


}
