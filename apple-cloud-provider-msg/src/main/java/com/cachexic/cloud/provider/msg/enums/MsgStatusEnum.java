package com.cachexic.cloud.provider.msg.enums;

import com.cachexic.cloud.common.base.vo.ValueDescVo;
import com.cachexic.cloud.common.utils.json.JsonUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tangmin
 * @version V1.0
 * @Title: MsgStatusEnum.java
 * @Package com.cachexic.cloud.provider.rocketmq.enums
 * @Description: 消息状态
 * @date 2017-09-09 16:11:03
 */
public enum MsgStatusEnum {

    waiting_confirm("待确认"),
    sending("发送中");

    /** 备注信息 */
    private final String desc;

    MsgStatusEnum(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    /**
     * 根据值获取枚举
     * @return
     */
    public static MsgStatusEnum getEnum(String name) {
        if (null == name)
            return null;
        for (MsgStatusEnum _enum : MsgStatusEnum.values()) {
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
        for (MsgStatusEnum _enum : MsgStatusEnum.values()) {
            list.add(new ValueDescVo(_enum.name(),_enum.getDesc()));
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(JsonUtil.toJson(MsgStatusEnum.toList()));
    }

}
