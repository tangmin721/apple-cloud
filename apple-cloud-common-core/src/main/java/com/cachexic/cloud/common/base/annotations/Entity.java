package com.cachexic.cloud.common.base.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author tangmin
 * @Description: 声明是一个entity类, 有对应的mapper文件, 用于代码生成
 * @date 2017-08-26 10:16:49
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Entity {

  /**
   * 数据库表名tableName
   */
  String value() default "";

  /**
   * id主键类型
   */
  Class primaryKeyType() default Long.class;
}
