package com.cachexic.cloud.feign.msg.feign;

import com.cachexic.cloud.common.base.Result;
import com.cachexic.cloud.feign.msg.entity.MsgPersistent;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author tangmin
 * @version V1.0
 * @Title: MsgFeign.java
 * @Package com.cachexic.cloud.feign.msg.feign
 * @Description: 消息中间件对外暴露的接口
 * @date 2017-09-09 16:47:25
 */
@FeignClient(name = "provider-msg", path = "/producer")
public interface MsgFeign {

    /** 预存储消息 */
    @PostMapping("saveMsgWaitingConfirm")
    Result saveMsgWaitingConfirm(@RequestBody MsgPersistent msgPersistent);

    /** 确认并发送消息 */
    @PostMapping("confirmAndSendMsg/{msgId}")
    Result confirmAndSendMsg(@PathVariable("msgId") String msgId);

    /** 存储并发送消息 */
    @PostMapping("saveAndSendMsg")
    Result saveAndSendMsg(@RequestBody MsgPersistent msgPersistent);

    /** 直接发送消息 */
    @PostMapping("directSendMsg")
    Result directSendMsg(@RequestBody MsgPersistent msgPersistent);

    /** 重发消息 */
    Result reSendMsg(@RequestBody MsgPersistent msgPersistent);

    /** 根据msgId重发某条消息 */
    Result reSendMsgByMsgId(String msgId);

    /** 将消息标记为死亡消息 */
    Result setMsgToDead(String msgId);

    /** 根据消息ID获取消息. */
    Result<MsgPersistent> getMsgByMsgId(String msgId);

    /** 根据消息ID删除消息 */
    Result deleteMsgByMsgId(String msgId);

    /** 重发某个消息队列中的全部已死亡的消息. */
    Result reSendAllDeadMsgByTopic();

}
