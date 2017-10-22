package com.cachexic.cloud.web.backstage.controller.test;

/**
 * @Description: 测试
 * @author tangmin
 * @date 2017-10-20 16:44:20
 */
public class User {

  private Long id;
  private String name;

  private Integer age;
  private String avatar;

  public User(Long id, String name, Integer age, String avatar) {
    this.id = id;
    this.name = name;
    this.age = age;
    this.avatar = avatar;
  }

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

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public String getAvatar() {
    return avatar;
  }

  public void setAvatar(String avatar) {
    this.avatar = avatar;
  }

  @Override
  public String toString() {
    return "User{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", age=" + age +
        ", avatar='" + avatar + '\'' +
        '}';
  }
}
