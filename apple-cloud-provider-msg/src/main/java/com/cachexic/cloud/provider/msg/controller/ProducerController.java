package com.cachexic.cloud.provider.msg.controller;

import com.cachexic.cloud.common.base.Result;
import com.cachexic.cloud.feign.msg.entity.MsgPersistent;
import com.cachexic.cloud.feign.msg.feign.MsgFeign;
import com.cachexic.cloud.provider.msg.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by tangm on 2017/9/9.
 */
@RestController
@RequestMapping("/producer")
public class ProducerController implements MsgFeign {

    @Autowired
    private ProducerService producerService;



    @Override
    public Result saveMsgWaitingConfirm(@RequestBody MsgPersistent msgPersistent) {
        producerService.saveMsgWaitingConfirm(msgPersistent);
        return Result.OK();
    }

    @Override
    public Result confirmAndSendMsg(@PathVariable("msgId") String msgId) {
        return null;
    }

    @Override
    public Result saveAndSendMsg(@RequestBody MsgPersistent msgPersistent) {
        return null;
    }

    @Override
    public Result directSendMsg(@RequestBody MsgPersistent msgPersistent) {


        return Result.OK();
    }

    @Override
    public Result reSendMsg(@RequestBody MsgPersistent msgPersistent) {
        return null;
    }

    @Override
    public Result reSendMsgByMsgId(String msgId) {
        return null;
    }

    @Override
    public Result setMsgToDead(String msgId) {
        return null;
    }

    @Override
    public Result<MsgPersistent> getMsgByMsgId(String msgId) {
        return null;
    }

    @Override
    public Result deleteMsgByMsgId(String msgId) {
        return null;
    }

    @Override
    public Result reSendAllDeadMsgByTopic() {
        return null;
    }
}
