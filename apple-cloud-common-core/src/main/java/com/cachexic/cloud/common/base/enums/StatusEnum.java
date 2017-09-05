package com.cachexic.cloud.common.base.enums;

import com.cachexic.cloud.common.base.vo.ValueDescVo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tangmin
 * @version V1.0
 * @Title: StatusEnum.java
 * @Package com.cachexic.sjdbc.common.core
 * @Description: 每条数据库记录的状态 枚举
 * @date 2017-08-24 22:46:57
 */
public enum StatusEnum {

    normal("normal","正常"),
    deleted("deleted","删除"),
    disabled("disabled","禁用"),
    frozen("frozen","冻结");

    private final String value;
    /** 备注信息 */
    private final String desc;

    StatusEnum(String value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public String getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }

    /**
     * 根据值获取枚举
     * @param value
     * @return
     */
    public static StatusEnum getByValue(String value) {
        if (null == value)
            return null;
        for (StatusEnum _enum : StatusEnum.values()) {
            if (value.equals(_enum.getValue()))
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
        for (StatusEnum _enum : StatusEnum.values()) {
            ValueDescVo valueDescVo = new ValueDescVo();
            valueDescVo.setValue(_enum.getValue());
            valueDescVo.setDesc(_enum.getDesc());
            list.add(valueDescVo);
        }
        return list;
    }

}
