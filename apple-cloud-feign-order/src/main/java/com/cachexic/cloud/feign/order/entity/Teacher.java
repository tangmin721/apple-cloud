package com.cachexic.cloud.feign.order.entity;

import com.cachexic.cloud.common.base.annotations.Entity;
import com.cachexic.cloud.common.base.annotations.Transient;
import com.cachexic.cloud.common.base.entity.BaseEntity;
import com.cachexic.cloud.common.base.validator.BeanValidator;
import com.cachexic.cloud.common.base.validator.annotations.Insert;
import com.cachexic.cloud.common.base.validator.annotations.Update;
import com.cachexic.cloud.common.enums.YesOrNoEnum;
import com.cachexic.cloud.common.utils.json.JsonUtil;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author tangmin
 */
@Entity("t_teacher")
public class Teacher extends BaseEntity {

  @NotBlank(message = "姓名不能为空", groups = {Insert.class, Update.class})
  @Size(max = 20, message = "姓名长度不能超过20", groups = {Insert.class, Update.class})
  @ApiModelProperty(value = "姓名", example = "hehe", required = true)
  private String name = "hehe";

  @Length(message = "身份证件号最大长度不能超过18位", max = 18, groups = {Insert.class, Update.class})
  @ApiModelProperty(value = "身份证", required = true)
  private String idCard;

  @NotNull(message = "出生日期", groups = {Insert.class, Update.class})
  @JsonFormat(pattern = "yyyy-MM-dd")
  @Past(message = "出生日期只能为过去的时间", groups = {Insert.class, Update.class})
  @ApiModelProperty(value = "出生日期", example = "2018-08-08")
  private Date birthday;

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @ApiModelProperty(value = "出生时间", example = "2018-08-08 09:09:09")
  private Date birthdayTime;

  @NotNull(message = "score不能空", groups = {Insert.class, Update.class})
  @ApiModelProperty("分数")
  private Long score;

  @NotNull
  @ApiModelProperty("出版的书籍数量")
  private long book = 2L;

  @NotNull
  @ApiModelProperty("数量")
  private int num;

  @NotNull
  @ApiModelProperty("年龄")
  private Integer age = 18;

  @ApiModelProperty(value = "不映射数据库,insert方法没有", readOnly = true)
  @Transient
  private String nameTransient;

  @ApiModelProperty("是否班主任")
  private YesOrNoEnum classMater = YesOrNoEnum.no;

  @ApiModelProperty("账户金额")
  private BigDecimal account;

  @ApiModelProperty("是否是特级教师")
  private Boolean supper = true;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getIdCard() {
    return idCard;
  }

  public void setIdCard(String idCard) {
    this.idCard = idCard;
  }

  public Date getBirthday() {
    return birthday;
  }

  public void setBirthday(Date birthday) {
    this.birthday = birthday;
  }

  public Date getBirthdayTime() {
    return birthdayTime;
  }

  public void setBirthdayTime(Date birthdayTime) {
    this.birthdayTime = birthdayTime;
  }

  public Long getScore() {
    return score;
  }

  public void setScore(Long score) {
    this.score = score;
  }

  public long getBook() {
    return book;
  }

  public void setBook(long book) {
    this.book = book;
  }

  public int getNum() {
    return num;
  }

  public void setNum(int num) {
    this.num = num;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public String getNameTransient() {
    return nameTransient;
  }

  public void setNameTransient(String nameTransient) {
    this.nameTransient = nameTransient;
  }

  public YesOrNoEnum getClassMater() {
    return classMater;
  }

  public void setClassMater(YesOrNoEnum classMater) {
    this.classMater = classMater;
  }

  public BigDecimal getAccount() {
    return account;
  }

  public void setAccount(BigDecimal account) {
    this.account = account;
  }

  public Boolean getSupper() {
    return supper;
  }

  public void setSupper(Boolean supper) {
    this.supper = supper;
  }

  /**
   * 测试
   */
  public static void main(String[] args) throws ParseException {
    Teacher testTable = new Teacher();
    testTable.setName("DADAWDADADADADA1");
    //testTable.setBirthday(DateUtils.parseDate("2011-10-11", "yyyy-MM-dd"));
    testTable.setAge(129);
    //System.out.println("::::校验结果：" + JsonUtil.toJson(BeanValidator.validateResult(testTable)));
    System.out.println(
        "::::校验结果：" + JsonUtil.toJson(BeanValidator.validateResult(testTable, Insert.class)));
  }
}
