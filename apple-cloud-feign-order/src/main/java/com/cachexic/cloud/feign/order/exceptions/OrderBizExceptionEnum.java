package com.cachexic.cloud.feign.order.exceptions;

/**
 * @author tangmin
 * @version V1.0
 * @Title: OrderBizExceptionEnum.java
 * @Package com.cachexic.cloud.feign.order.exceptions
 * @Description: 订单异常
 * @date 2017-09-09 17:11:40
 */
public enum OrderBizExceptionEnum {
    CREATE_ORDER_FAIL(-1,"创建订单失败"),
    CANCEL_ORDER_FAIL(-1,"取消订单失败");

    private int code;
    private String msg;

    /**
     * 构造方法
     * @param code
     * @param msg
     */
    OrderBizExceptionEnum(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
