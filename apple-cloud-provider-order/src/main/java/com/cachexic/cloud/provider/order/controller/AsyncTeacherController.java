package com.cachexic.cloud.provider.order.controller;

import com.cachexic.cloud.common.base.Result;
import com.cachexic.cloud.feign.order.entity.Teacher;
import com.cachexic.cloud.provider.order.mockqueue.DeferredResultHolder;
import com.cachexic.cloud.provider.order.mockqueue.MockQueue;
import com.cachexic.cloud.provider.order.service.TeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import java.util.concurrent.Callable;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

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

    /** 发送消息到消息队列 */
    @Autowired
    private MockQueue mockQueue;

    /** 通过key 把new一个结果放进去,然后另一个线程去完成它,返回 */
    @Autowired
    private DeferredResultHolder deferredResultHolder;


    @ApiOperation(value = "getById:根据主键查询",notes = "方式1:Callable简单的异步接口")
    @GetMapping("id/{id}")
    public Callable<Result<Teacher>> getById(@PathVariable("id") Long id){
        log.info("*********主线程开始*********");
        Callable<Result<Teacher>> resultCallable = () -> {
            log.info("*********callable线程开始*********");
            Result result = Result.OK().setData(teacherService.selectById(id));
            Thread.sleep(200);
            log.info("*********callable线程返回*********");
            return result;
        };
        log.info("*********主线程返回*********");

        return resultCallable;
    }


    @ApiOperation(value = "getByIds:根据主键ids查询",notes = "逗号分隔.方式2:通过消息队列异步消费(模拟一下)")
    @GetMapping("ids/{ids}")
    public DeferredResult<Result<List<Teacher>>> getByIds(@PathVariable("ids") String ids){
        log.info("*********主线程开始*********");

        //假设生成一个随机订单号(唯一)
        String orderNum = RandomStringUtils.randomNumeric(8);
        //mockQueue.setPlaceOrder(orderNum);
        mockQueue.setPlaceOrder(ids);//用ids模拟一下返回结果差别

        DeferredResult<Result<List<Teacher>>> deferredResult = new DeferredResult<>();
        //deferredResultHolder.getMap().put(orderNum,deferredResult);
        deferredResultHolder.getMap().put(ids,deferredResult);

        log.info("*********主线程返回*********");
        return deferredResult;
    }



}
