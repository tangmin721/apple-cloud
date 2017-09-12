package com.cachexic.cloud.provider.msg.controller;

import com.cachexic.cloud.common.base.Result;
import com.cachexic.cloud.common.exceptions.BizPreconditions;
import com.cachexic.cloud.feign.msg.entity.MsgPersistent;
import com.cachexic.cloud.feign.msg.feign.MsgFeign;
import com.cachexic.cloud.provider.msg.service.ProducerService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by tangm on 2017/9/9.
 */
@RestController
@RequestMapping("/mq")
public class ProducerController implements MsgFeign {

    @Autowired
    private ProducerService producerService;

    @Override
    public Result saveMsgWaitingConfirm(@RequestBody MsgPersistent msgPersistent) {
        return null;
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
        BizPreconditions.checkArgument(msgPersistent != null,"requestBody不能为空");
        BizPreconditions.checkArgument(StringUtils.isNotBlank(msgPersistent.getTopic()),"topic不能为空");
        BizPreconditions.checkArgument(StringUtils.isNotBlank(msgPersistent.getTags()),"tags不能为空");
        BizPreconditions.checkArgument(StringUtils.isNotBlank(msgPersistent.getMsgBody()),"msgBody不能为空");

        this.producerService.directSendMsg(msgPersistent);

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
