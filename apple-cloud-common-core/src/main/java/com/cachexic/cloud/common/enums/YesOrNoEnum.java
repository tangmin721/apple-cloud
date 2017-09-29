package com.cachexic.cloud.common.enums;

import com.cachexic.cloud.common.base.vo.ValueDescVo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tangmin
 * @version V1.0
 * @Title: YesOrNoEnum.java
 * @Package com.cachexic.cloud.common.enums
 * @Description: ye or no
 * @date 2017-09-09 21:06:17
 */
public enum YesOrNoEnum {

  yes("是"),
  no("否");

  /**
   * 备注信息
   */
  private final String desc;

  YesOrNoEnum(String desc) {
    this.desc = desc;
  }

  public String getDesc() {
    return desc;
  }

  /**
   * 转换为list
   */
  public static List toList() {
    List list = new ArrayList();
    for (YesOrNoEnum _enum : YesOrNoEnum.values()) {
      list.add(new ValueDescVo(_enum.name(), _enum.getDesc()));
    }
    return list;
  }

}
