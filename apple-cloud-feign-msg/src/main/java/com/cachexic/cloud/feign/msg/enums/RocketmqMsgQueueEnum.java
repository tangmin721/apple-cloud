package com.cachexic.cloud.feign.msg.enums;

import com.cachexic.cloud.common.base.vo.ValueDescVo;
import java.util.ArrayList;
import java.util.List;

/**
 * @author tangmin
 * @Description: rocketmq消费队列枚举（kafka的请参见com.cachexic.cloud.feign.msg.constants.KafkaMsgQueueConts）
 * @date 2017-09-13 19:30:12
 */
public enum RocketmqMsgQueueEnum {

    testTopic("my-topic4","mqtag","订单创建消费队列");

    private final String topic;
    private final String tag;
    /** 备注信息 */
    private final String desc;

    RocketmqMsgQueueEnum(String topic,String tag,String desc) {
        this.topic = topic;
        this.tag = tag;
        this.desc = desc;
    }

    public String getTopic() {
        return topic;
    }

    public String getTag() {
        return tag;
    }

    public String getDesc() {
        return desc;
    }

    /**
     * 转换为list
     * @return
     */
    public static List toList() {
        List list = new ArrayList();
        for (RocketmqMsgQueueEnum _enum : RocketmqMsgQueueEnum.values()) {
            list.add(new ValueDescVo(_enum.name(),_enum.getDesc()));
        }
        return list;
    }

}
