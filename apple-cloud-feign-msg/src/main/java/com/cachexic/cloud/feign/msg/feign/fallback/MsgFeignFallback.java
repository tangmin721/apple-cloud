package com.cachexic.cloud.feign.msg.feign.fallback;

import com.cachexic.cloud.common.base.Result;
import com.cachexic.cloud.feign.msg.entity.MsgPersistent;
import com.cachexic.cloud.feign.msg.feign.MsgFeign;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

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
        };
    }
}
