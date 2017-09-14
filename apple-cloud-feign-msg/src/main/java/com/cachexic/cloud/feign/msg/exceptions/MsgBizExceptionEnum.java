package com.cachexic.cloud.feign.msg.exceptions;

/**
 * @author tangmin
 * @Description: 消息中间件的异常信息
 * @date 2017-09-14 09:35:53
 */
public enum MsgBizExceptionEnum {
    MQ_CLIENT_EXCEPTION(-1,"消息中间件连接异常"),
    SAVA_MESSAGE_IS_NULL(-1,"保存的消息为空"),
    SEND_MESSAGE_RESULT_IS_NOTOK(-1,"发送消息返回状态不是SEND_OK"),
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
