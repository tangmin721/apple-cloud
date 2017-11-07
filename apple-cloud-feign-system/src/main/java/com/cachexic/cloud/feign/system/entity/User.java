package com.cachexic.cloud.feign.system.entity;

import com.cachexic.cloud.common.base.annotations.Entity;
import com.cachexic.cloud.common.base.entity.BaseEntity;
import com.cachexic.cloud.common.base.validator.annotations.Insert;
import com.cachexic.cloud.common.base.validator.annotations.Update;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @Description:
 * @author tangmin
 * @date 2017-11-07 12:52:12
 */
@Entity("all_user")
@JsonIgnoreProperties(ignoreUnknown = true)
public class User extends BaseEntity{
  @NotBlank(message = "用户名不能为空", groups = {Insert.class})
  @Size(max = 20, message = "用户名长度不能超过20", groups = {Insert.class, Update.class})
  @ApiModelProperty(value = "用户名", example = "hehe", required = true)
  private String username;

  @NotBlank(message = "密码不能为空", groups = {Insert.class})
  @ApiModelProperty(value = "密码", required = true)
  private String password;

  @Size(max = 11,groups={Insert.class,Update.class})
  @ApiModelProperty(value = "手机", required = true)
  private String mobile;

  @Size(max = 100,groups={Insert.class,Update.class})
  @ApiModelProperty(value = "Email", required = true)
  private String email;

  @ApiModelProperty(value = "头像", required = true)
  private String avatar;

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getAvatar() {
    return avatar;
  }

  public void setAvatar(String avatar) {
    this.avatar = avatar;
  }
}
