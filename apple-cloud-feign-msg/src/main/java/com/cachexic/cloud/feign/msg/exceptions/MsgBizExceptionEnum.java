package com.cachexic.cloud.feign.msg.exceptions;

/**
 * @author liTengfei
 * @version V1.0
 * @Title: OrderBizExceptionEnum.java
 * @Package com.gasq.cloud.provider.order.exceptions.enums
 * @Description: 订单模块
 * @date 2017-05-26 14:23:15
 */
public enum MsgBizExceptionEnum {
    MQ_CLIENT_EXCEPTION(-1,"消息中间件连接异常"),
    SAVA_MESSAGE_IS_NULL(-1,"保存的消息为空"),
    MESSAGE_CONSUMER_QUEUE_IS_NULL(-1,"消息的消费队列为空");

    private int code;
    private String msg;

    /**
     * 构造方法
     * @param code
     * @param msg
     */
    MsgBizExceptionEnum(int code, String msg){
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
