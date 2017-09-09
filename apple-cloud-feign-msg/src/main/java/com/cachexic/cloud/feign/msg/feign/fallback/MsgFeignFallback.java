package com.cachexic.cloud.feign.msg.feign.fallback;

import com.cachexic.cloud.common.base.Result;
import com.cachexic.cloud.feign.msg.entity.MsgPersistent;
import com.cachexic.cloud.feign.msg.feign.MsgFeign;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author tangmin
 * @version V1.0
 * @Title: MsgFeignFallback.java
 * @Package com.cachexic.cloud.feign.msg.feign.fallback
 * @Description: feign hystrix快速返回实现
 * @date 2017-09-09 18:58:45
 */
@Component
public class MsgFeignFallback implements FallbackFactory<MsgFeign> {

    private static final Logger log = LoggerFactory.getLogger(MsgFeignFallback.class);

    @Override
    public MsgFeign create(Throwable cause) {
        return new MsgFeign() {
            @Override
            public Result saveMsgWaitingConfirm(MsgPersistent msgPersistent) {
                return Result.FALLBACK(cause);
            }

            @Override
            public Result confirmAndSendMsg(@PathVariable("msgId") String msgId) {
                return Result.FALLBACK(cause);
            }

            @Override
            public Result saveAndSendMsg(@RequestBody MsgPersistent msgPersistent) {
                return Result.FALLBACK(cause);
            }

            @Override
            public Result directSendMsg(@RequestBody MsgPersistent msgPersistent) {
                return Result.FALLBACK(cause);
            }

            @Override
            public Result reSendMsg(@RequestBody MsgPersistent msgPersistent) {
                return Result.FALLBACK(cause);
            }

            @Override
            public Result reSendMsgByMsgId(String msgId) {
                return Result.FALLBACK(cause);
            }

            @Override
            public Result setMsgToDead(String msgId) {
                return Result.FALLBACK(cause);
            }

            @Override
            public Result<MsgPersistent> getMsgByMsgId(String msgId) {
                return Result.FALLBACK(cause);
            }

            @Override
            public Result deleteMsgByMsgId(String msgId) {
                return Result.FALLBACK(cause);
            }

            @Override
            public Result reSendAllDeadMsgByTopic() {
                return Result.FALLBACK(cause);
            }
        };
    }
}
