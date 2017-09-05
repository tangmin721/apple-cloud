package com.cachexic.cloud.common.base.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author tangmin
 * @version V1.0
 * @Title: Field.java
 * @Package com.cachexic.sjdbc.common.config.mybatis.annotation
 * @Description: 声明字段,有对应的mapper文件,用于代码生成
 * @date 2017-08-26 10:50:56
 */
@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.FIELD)
public @interface Field {
    /**
     * 注释 对应mysql COMMENT
     * @return
     */
    String value() default "";

    /**
     * 字符型的长度 char 或 varchar
     * @return
     */
    int length() default 32;

    /**
     * 不允许为空
     */
    boolean notNull() default true;

    /**
     * 默认值
     * @return
     */
    String defaultValue() default "";


}
