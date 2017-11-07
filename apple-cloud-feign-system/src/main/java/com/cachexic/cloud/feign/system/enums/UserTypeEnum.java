package com.cachexic.cloud.feign.system.enums;

import com.cachexic.cloud.common.base.enums.StatusEnum;
import com.cachexic.cloud.common.base.vo.ValueDescVo;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 用户类型
 * @author tangmin
 * @date 2017-11-07 13:06:12
 */
public enum UserTypeEnum {
  admin("管理员"),
  user("用户"),
  guest("游客");

  /**
   * 备注信息
   */
  private final String desc;

  UserTypeEnum(String desc) {
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
    for (StatusEnum _enum : StatusEnum.values()) {
      list.add(new ValueDescVo(_enum.name(), _enum.getDesc()));
    }
    return list;
  }
}
