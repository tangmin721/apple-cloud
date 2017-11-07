package com.cachexic.cloud.feign.system.entity.query;

import com.cachexic.cloud.common.base.entity.query.BaseQuery;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Description: 用户管理
 * @author tangmin
 * @date 2017-11-07 15:38:00
 */
public class UserQuery extends BaseQuery{
  private static final long serialVersionUID = 1L;

  @ApiModelProperty("用户名")
  private String username;
  private Boolean usernameLike = false;

  @ApiModelProperty("密码")
  private String password;
  private Boolean passwordLike = false;

  @ApiModelProperty("手机")
  private String mobile;
  private Boolean mobileLike = false;

  @ApiModelProperty("Email")
  private String email;
  private Boolean emailLike = false;

  @ApiModelProperty("头像")
  private String avatar;
  private Boolean avatarLike = false;

  public String getUsername() {
    return username;
  }

  public UserQuery setUsername(String username) {
    this.username = username;
    return this;
  }

  public Boolean getUsernameLike() {
    return usernameLike;
  }

  public UserQuery setUsernameLike(Boolean usernameLike) {
    this.usernameLike = usernameLike;
    return this;
  }
  public String getPassword() {
    return password;
  }

  public UserQuery setPassword(String password) {
    this.password = password;
    return this;
  }

  public Boolean getPasswordLike() {
    return passwordLike;
  }

  public UserQuery setPasswordLike(Boolean passwordLike) {
    this.passwordLike = passwordLike;
    return this;
  }
  public String getMobile() {
    return mobile;
  }

  public UserQuery setMobile(String mobile) {
    this.mobile = mobile;
    return this;
  }

  public Boolean getMobileLike() {
    return mobileLike;
  }

  public UserQuery setMobileLike(Boolean mobileLike) {
    this.mobileLike = mobileLike;
    return this;
  }
  public String getEmail() {
    return email;
  }

  public UserQuery setEmail(String email) {
    this.email = email;
    return this;
  }

  public Boolean getEmailLike() {
    return emailLike;
  }

  public UserQuery setEmailLike(Boolean emailLike) {
    this.emailLike = emailLike;
    return this;
  }
  public String getAvatar() {
    return avatar;
  }

  public UserQuery setAvatar(String avatar) {
    this.avatar = avatar;
    return this;
  }

  public Boolean getAvatarLike() {
    return avatarLike;
  }

  public UserQuery setAvatarLike(Boolean avatarLike) {
    this.avatarLike = avatarLike;
    return this;
  }
}