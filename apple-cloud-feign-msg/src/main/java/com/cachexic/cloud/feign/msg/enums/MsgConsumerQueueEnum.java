package com.cachexic.cloud.feign.msg.enums;

import com.cachexic.cloud.common.base.vo.ValueDescVo;
import java.util.ArrayList;
import java.util.List;

/**
 * @author tangmin
 * @Description: 消费队列枚举
 * @date 2017-09-13 19:30:12
 */
public enum MsgConsumerQueueEnum {

    order_create("orderTopic","createTag","订单创建消费队列"),
    order_payed("orderTopic","payedTag","订单已付款消费队列");

    private final String topic;
    private final String tag;
    /** 备注信息 */
    private final String desc;

    MsgConsumerQueueEnum(String topic,String tag,String desc) {
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
     * 根据值获取枚举
     * @return
     */
    public static MsgConsumerQueueEnum getEnum(String name) {
        if (null == name)
            return null;
        for (MsgConsumerQueueEnum _enum : MsgConsumerQueueEnum.values()) {
            if (name.equals(_enum.name()))
                return _enum;
        }
        return null;
    }

    /**
     * 转换为list
     * @return
     */
    public static List toList() {
        List list = new ArrayList();
        for (MsgConsumerQueueEnum _enum : MsgConsumerQueueEnum.values()) {
            list.add(new ValueDescVo(_enum.name(),_enum.getDesc()));
        }
        return list;
    }

}
