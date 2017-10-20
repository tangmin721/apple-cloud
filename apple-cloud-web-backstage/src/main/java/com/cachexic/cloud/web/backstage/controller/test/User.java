package com.cachexic.cloud.web.backstage.controller.test;

/**
 * @Description: 测试
 * @author tangmin
 * @date 2017-10-20 16:44:20
 */
public class User {

  private Long id;
  private String name;

  private String age;
  private String avatar;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAge() {
    return age;
  }

  public void setAge(String age) {
    this.age = age;
  }

  public String getAvatar() {
    return avatar;
  }

  public void setAvatar(String avatar) {
    this.avatar = avatar;
  }
}
