package com.cachexic.cloud.common.base;


import com.cachexic.cloud.common.base.entity.BaseEntity;
import com.cachexic.cloud.common.base.entity.query.Pagination;
import com.cachexic.cloud.common.exceptions.BizExceptionEnum;
import com.cachexic.cloud.common.utils.json.JsonUtil;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @author tangmin
 * @version V1.0
 * @Title: Result.java
 * @Package com.cachexic.springboot.common.result
 * @Description: 返回信息统一包装 使之能匹配cloud的错误消息1
 * @date 2017-04-04 22:13:02
 */
public class Result<T> implements Serializable {
    private static final long serialVersionUID = 7812106698117922413L;

    private final static Logger log = LoggerFactory.getLogger(Result.class);

    public final static int OK_CODE = 0;
    public final static int EMPTY_CODE = 1;
    public final static int FAIL_CODE = -1;

    public final static String OK_MSG = "操作成功";
    public final static String EMPTY_MSG = "找不到纪录";
    public final static String FAIL_MSG = "操作失败";

    private int status;
    private String message;
    private T data;

    public static Result OK() {
        Result success = new Result();
        success.setStatus(OK_CODE);
        success.setMessage(OK_MSG);
        return success;
    }

    public static Result OK(String msg) {
        Result success = new Result();
        success.setStatus(OK_CODE);
        success.setMessage(msg);
        return success;
    }

    public static Result OK(int code, String msg) {
        Result success = new Result();
        success.setStatus(code);
        success.setMessage(msg);
        return success;
    }

    public static Result FAIL() {
        Result success = new Result();
        success.setStatus(FAIL_CODE);
        success.setMessage(FAIL_MSG);
        return success;
    }

    public static Result FAIL(String errorMsg) {
        Result success = new Result();
        success.setStatus(FAIL_CODE);
        success.setMessage(errorMsg);
        return success;
    }

    public static Result FAIL(BizExceptionEnum exceptionEnum) {
        Result success = new Result();
        success.setStatus(exceptionEnum.getCode());
        success.setMessage(exceptionEnum.getMsg());
        return success;
    }

    public static Result FAIL(int code, String errorMsg) {
        Result success = new Result();
        success.setStatus(code);
        success.setMessage(errorMsg);
        return success;
    }

    public static Result FALLBACK(Throwable cause) {
        String message = cause.getMessage();
        if(StringUtils.isBlank(message)){
            message = cause.getClass().getName();
        }
        log.warn("====> Feign Fallback Exception class:{},errorCode:{},message:{}", cause.getClass().getName(), BizExceptionEnum.FEIGN_FALLBACK.getCode(), message);

        return Result.FAIL(BizExceptionEnum.FEIGN_FALLBACK.getCode(), BizExceptionEnum.FEIGN_FALLBACK.getMsg() + ":" + message);
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

    /** 设置data时，判断是非返回结果是空对象 或 空集合，如果需要自定义message提示，需要在setData后再setMessage */
    public Result setData(T data) {
        this.data = data;

        //校验空记录
        if (data == null) {
            this.status = EMPTY_CODE;
            this.message = EMPTY_MSG;
        } else {
            if (data instanceof Collection) {
                if (((Collection) data).isEmpty()) {
                    this.status = EMPTY_CODE;
                    this.message = EMPTY_MSG;
                }
            } else if (data instanceof Map) {
                if (((Map) data).isEmpty()) {
                    this.status = EMPTY_CODE;
                    this.message = EMPTY_MSG;
                }
            } else if (data instanceof Pagination) {
                if (((Pagination) data).getTotal().longValue() == 0) {
                    this.status = EMPTY_CODE;
                    this.message = EMPTY_MSG;
                }
            }
        }
        return this;
    }

    /**
     * 判断返回结果是非是成功(如果是empty，说明也没有获取到你想要的数据)
     * @return
     */
    public static boolean isSuccess(Result result){
        if(result == null){
            return false;
        }
        if (result.getStatus()!=0){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        //BaseEntity order = new BaseEntity();
        BaseEntity order = null;
        Result<BaseEntity> result1 = Result.OK().setData(order);
        System.out.println(JsonUtil.toJson(result1));

        List<BaseEntity> orders = Lists.newArrayList();
        //List<BaseEntity> orders = null;
        Result<List<BaseEntity>> result2 = Result.OK().setData(orders);
        System.out.println(JsonUtil.toJson(result2));

        Pagination<BaseEntity> pagination = new Pagination<>(1L, 10L, 0L);
        Result<Pagination<BaseEntity>> result3 = Result.OK().setData(pagination);
        System.out.println(JsonUtil.toJson(result3));

        System.out.println(Result.isSuccess(result3));
    }
}
