package com.cachexic.cloud.common.constants;

/**
 * @author tangmin
 * @version V1.0
 * @Title: SystemConst.java
 * @Package com.cachexic.sjdbc.common.constants
 * @Description: 系统常量
 * @date 2017-08-26 12:19:36
 */
public class SystemConst {
    public static final long DEFAULT_PAGE_SIZE = 10;
    public static final long MAX_PAGE_SIZE = 50;


    /**
     * 切面设置requestId，异常拦截的时候，获取requestId，请求参数
     */
    public final static String REQUEST_ID = "requestId";
    public final static String REQUEST_ARGS = "requestArgs";

    /**
     * 统一异常处理，异常定义
     */
    public final static int SYS_EX_CODE = -1;
    public final static String SYS_EX_MSG = "系统异常";

    /**
     * feign_fallback消息
     */
    public final static int FEIGN_FALLBACK_CODE = -1;

    public static final String FEIGN_FALLBACK_MSG = "feign回调失败:";

    private SystemConst() {
        throw new IllegalAccessError("Utility class");
    }
}
