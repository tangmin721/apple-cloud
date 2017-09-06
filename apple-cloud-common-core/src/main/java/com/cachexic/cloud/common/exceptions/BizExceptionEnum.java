package com.cachexic.cloud.common.exceptions;

/**
 * @author tangmin
 * @version V1.0
 * @Title: BizExceptionEnum.java
 * @Package com.cachexic.sjdbc.common.exceptions.enums
 * @Description: 定义通用异常
 * @date 2017-08-25 22:30:42
 */
public enum BizExceptionEnum {

    /**
     * 需要特殊处理的异常，两个列外：0 是正常，1为返回list的数据为空
     * 负数为异常 正数为特殊处理的异常
     */
    INVALID_TOKEN(2, "身份校验失效，请重新登录"),
    APP_FORCE_UPDATE(3, "有最新版本需要您更新"),

    SYS_EXCEPTION(-1, "系统异常"),
    UNKOWN(-1, "未知异常"),
    TIMEOUT(-1, "请求响应超时"),
    REQUEST_EXP(-1, "请求已过期"),
    MD5_ERROR(-1, "MD5校验失败"),
    PARAMETER_ERROR(-1, "参数错误"),
    STATE_ERROR(-1, "预设条件不成立"),
    NULL_ERROR(-1, "空指针异常"),
    FEIGN_FALLBACK(-1, "服务调用异常"),


    DATA_QUERY_ERROR(-1, "查询数据失败"),
    DATA_UPDATED_ERROR(-1, "更新数据失败"),
    DATA_DELETED_ERROR(-1, "删除数据失败"),

    DB_SELECT_RESULT_0(-1, "找不到记录"),
    DB_INSERT_RESULT_0(-1, "数据库操作,insert返回0"),
    DB_UPDATE_RESULT_0(-1, "数据库操作,update返回0"),
    DB_DELETE_RESULT_0(-1, "数据库操作,delete返回0"),
    DB_REMOVE_RESULT_0(-1, "数据库操作,delete返回0");

    private int code;
    private String msg;

    /**
     * 构造方法
     * @param code
     * @param msg
     */
    BizExceptionEnum(int code, String msg){
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
