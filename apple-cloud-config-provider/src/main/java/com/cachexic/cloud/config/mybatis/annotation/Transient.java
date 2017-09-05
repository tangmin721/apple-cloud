package com.cachexic.cloud.config.mybatis.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author tangmin
 * @version V1.0
 * @Title: Transient.java
 * @Package com.cachexic.sjdbc.common.config.mybatis
 * @Description: 自定义注解，只是标识不在数据库中保存的字段，没有实际作用。
 * @date 2017-08-20 16:08:24
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Transient {

}
