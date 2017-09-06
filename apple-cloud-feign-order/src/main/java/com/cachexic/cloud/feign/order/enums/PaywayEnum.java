package com.cachexic.cloud.feign.order.enums;

/**
 * @author tangmin
 * @version V1.0
 * @Title: PaywayEnum.java
 * @Package com.cachexic.cloud.feign.order.enums
 * @Description: 
 * @date 2017-09-06 16:20:20
 */
public enum PaywayEnum {

    onLinePay("onLinePay","在线支付"),
    offLinePay("offLinePay","货到付款");

    private final String value;
    private final String desc;

    PaywayEnum(String value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public String getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }

    public static PaywayEnum getByValue(String value) {
        if (null == value)
            return null;
        for (PaywayEnum _enum : PaywayEnum.values()) {
            if (value.equals(_enum.getValue()))
                return _enum;
        }
        return null;
    }
}
