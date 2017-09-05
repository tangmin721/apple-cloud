package com.cachexic.cloud.common.base;


import com.cachexic.cloud.common.exceptions.BizExceptionEnum;

import java.io.Serializable;

/**
 * @author tangmin
 * @version V1.0
 * @Title: Result.java
 * @Package com.cachexic.springboot.common.result
 * @Description: 返回信息统一包装 使之能匹配cloud的错误消息1
 * @date 2017-04-04 22:13:02
 */
public class Result<T> implements Serializable{
    private static final long serialVersionUID = 7812106698117922413L;

    public final static int OK_CODE = 0;
    public final static int EMPTY_CODE = 1;
    public final static int FAIL_CODE = -1;

    public final static String OK_MSG = "操作成功";
    public final static String EMPTY_MSG = "列表信息为空";
    public final static String FAIL_MSG = "操作失败";

    private int status;
    private String message;
    private T data;

    public static Result OK(){
        Result success = new Result();
        success.setStatus(OK_CODE);
        success.setMessage(OK_MSG);
        return success;
    }

    public static Result OK(String msg){
        Result success = new Result();
        success.setStatus(OK_CODE);
        success.setMessage(msg);
        return success;
    }

    public static Result OK(int code,String msg){
        Result success = new Result();
        success.setStatus(code);
        success.setMessage(msg);
        return success;
    }

    public static Result EMPTY() {
        Result success = new Result();
        success.setStatus(EMPTY_CODE);
        success.setMessage(EMPTY_MSG);
        return success;
    }

    public static Result FAIL() {
        Result success = new Result();
        success.setStatus(FAIL_CODE);
        success.setMessage(FAIL_MSG);
        return success;
    }

    public static Result FAIL(String errorMsg){
        Result success = new Result();
        success.setStatus(FAIL_CODE);
        success.setMessage(errorMsg);
        return success;
    }

    public static Result FAIL(BizExceptionEnum exceptionEnum){
        Result success = new Result();
        success.setStatus(exceptionEnum.getCode());
        success.setMessage(exceptionEnum.getMsg());
        return success;
    }

    public static Result FAIL(int code,String errorMsg){
        Result success = new Result();
        success.setStatus(code);
        success.setMessage(errorMsg);
        return success;
    }

    public int getStatus() {
        return status;
    }

    public Result setStatus(int status) {
        this.status = status;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public Result setMessage(String message) {
        this.message = message;
        return this;
    }

    public T getData() {
        return data;
    }

    public Result setData(T data) {
        this.data = data;
        return this;
    }
}
