package com.cachexic.cloud.feign.system.entity;

import com.cachexic.cloud.common.base.annotations.Entity;
import com.cachexic.cloud.common.base.annotations.Transient;
import com.cachexic.cloud.common.base.entity.BaseEntity;
import com.cachexic.cloud.common.base.validator.annotations.Insert;
import com.cachexic.cloud.common.base.validator.annotations.Update;
import com.cachexic.cloud.common.enums.YesOrNoEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @Description: 作为最全包含的demo实体内
 * @author tangmin
 * @date 2017-10-24 10:08:08
 */
@Entity("t_demo")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Demo extends BaseEntity {

  private static final long serialVersionUID = -3199106197692249762L;
  @NotBlank(message = "姓名不能为空", groups = {Insert.class, Update.class})
  @Size(max = 20, message = "姓名长度不能超过20", groups = {Insert.class, Update.class})
  @ApiModelProperty(value = "姓名", example = "张三", required = true)
  private String name;

  @NotNull(message = "出生日期", groups = {Insert.class})
  @JsonFormat(pattern = "yyyy-MM-dd")
  @Past(message = "出生日期只能为过去的时间", groups = {Insert.class, Update.class})
  @ApiModelProperty(value = "出生日期", example = "2018-08-08")
  private Date birthday;

  @NotNull
  @ApiModelProperty("年龄")
  private Integer age = 18;

  @ApiModelProperty(value = "不映射数据库,insert方法没有", readOnly = true)
  @Transient
  private String nameTransient;

  @ApiModelProperty("是否班主任")
  private YesOrNoEnum classMater = YesOrNoEnum.no;

  @ApiModelProperty("是否是特级教师")
  private Boolean supper = true;

  @ApiModelProperty("账户金额")
  private BigDecimal account;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Date getBirthday() {
    return birthday;
  }

  public void setBirthday(Date birthday) {
    this.birthday = birthday;
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

  public Boolean getSupper() {
    return supper;
  }

  public void setSupper(Boolean supper) {
    this.supper = supper;
  }

  public BigDecimal getAccount() {
    return account;
  }

  public void setAccount(BigDecimal account) {
    this.account = account;
  }

  @Override
  public String toString() {
    return "Demo{" +
        "name='" + name + '\'' +
        ", birthday=" + birthday +
        ", age=" + age +
        ", nameTransient='" + nameTransient + '\'' +
        ", classMater=" + classMater +
        ", supper=" + supper +
        ", account=" + account +
        '}';
  }
}
