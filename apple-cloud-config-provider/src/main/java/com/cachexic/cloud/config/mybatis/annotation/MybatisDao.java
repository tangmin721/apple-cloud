package com.cachexic.cloud.config.mybatis.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author tangmin
 * @version V1.0
 * @Title: MybatisDao.java
 * @Package com.cachexic.sjdbc.common.config.mybatis
 * @Description: 扫描添加@MybatisDao的dao
 * @date 2017-08-20 16:08:14
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface MybatisDao {

}
