package com.cachexic.cloud.provider.rocketmq.controller;

import com.cachexic.cloud.common.base.Result;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by tangm on 2017/9/9.
 */
@RestController
@RequestMapping("/mq")
public class ProducerController {

    @Autowired
    private DefaultMQProducer producer;

    public Result sendMsg(){

        

        return Result.OK();
    }

}
