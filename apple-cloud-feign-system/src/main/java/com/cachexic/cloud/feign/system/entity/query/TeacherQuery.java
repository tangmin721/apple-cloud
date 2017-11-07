package com.cachexic.cloud.feign.system.entity.query;

import com.cachexic.cloud.common.base.entity.query.BaseQuery;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

/**
 * @Description: 用户管理
 * @author tangmin
 * @date 2017-11-07 15:07:51
 */
public class TeacherQuery extends BaseQuery{
  private static final long serialVersionUID = 1L;

  @ApiModelProperty("姓名")
  private String name;
  private Boolean nameLike = false;

  @ApiModelProperty("username描述@TODO'")
  private String username;
  private Boolean usernameLike = false;

  @ApiModelProperty("身份证")
  private String idCard;
  private Boolean idCardLike = false;

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  @ApiModelProperty(value = "出生日期", example = "2018-08-08 09:09:09")  
  private Date birthday;

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  @ApiModelProperty(value = "出生时间", example = "2018-08-08 09:09:09")  
  private Date birthdayTime;

  @ApiModelProperty("分数")
  private String score;

  @ApiModelProperty("出版的书籍数量")
  private String book;

  @ApiModelProperty("数量")
  private String num;

  @ApiModelProperty("年龄")
  private String age;

  @ApiModelProperty("是否班主任")
  private String classMater;

  @ApiModelProperty("账户金额")
  private String account;

  @ApiModelProperty("是否是特级教师")
  private Boolean supper;

  public String getName() {
    return name;
  }

  public TeacherQuery setName(String name) {
    this.name = name;
    return this;
  }

  public Boolean getNameLike() {
    return nameLike;
  }

  public TeacherQuery setNameLike(Boolean nameLike) {
    this.nameLike = nameLike;
    return this;
  }
  public String getUsername() {
    return username;
  }

  public TeacherQuery setUsername(String username) {
    this.username = username;
    return this;
  }

  public Boolean getUsernameLike() {
    return usernameLike;
  }

  public TeacherQuery setUsernameLike(Boolean usernameLike) {
    this.usernameLike = usernameLike;
    return this;
  }
  public String getIdCard() {
    return idCard;
  }

  public TeacherQuery setIdCard(String idCard) {
    this.idCard = idCard;
    return this;
  }

  public Boolean getIdCardLike() {
    return idCardLike;
  }

  public TeacherQuery setIdCardLike(Boolean idCardLike) {
    this.idCardLike = idCardLike;
    return this;
  }
  public Date getBirthday() {
    return birthday;
  }

  public TeacherQuery setBirthday(Date birthday) {
    this.birthday = birthday;
    return this;
  }

  public Date getBirthdayTime() {
    return birthdayTime;
  }

  public TeacherQuery setBirthdayTime(Date birthdayTime) {
    this.birthdayTime = birthdayTime;
    return this;
  }

  public String getScore() {
    return score;
  }

  public TeacherQuery setScore(String score) {
    this.score = score;
    return this;
  }

  public String getBook() {
    return book;
  }

  public TeacherQuery setBook(String book) {
    this.book = book;
    return this;
  }

  public String getNum() {
    return num;
  }

  public TeacherQuery setNum(String num) {
    this.num = num;
    return this;
  }

  public String getAge() {
    return age;
  }

  public TeacherQuery setAge(String age) {
    this.age = age;
    return this;
  }

  public String getClassMater() {
    return classMater;
  }

  public TeacherQuery setClassMater(String classMater) {
    this.classMater = classMater;
    return this;
  }

  public String getAccount() {
    return account;
  }

  public TeacherQuery setAccount(String account) {
    this.account = account;
    return this;
  }

  public Boolean getSupper() {
    return supper;
  }

  public TeacherQuery setSupper(Boolean supper) {
    this.supper = supper;
    return this;
  }

}