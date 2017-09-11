package com.cachexic.cloud.feign.order.entity.query;

import com.cachexic.cloud.common.base.entity.query.BaseQuery;
import com.cachexic.cloud.common.enums.YesOrNoEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 教师管理
 * @author tangmin
 * @date 2017-09-12 00:15:00
 */
public class TeacherQuery extends BaseQuery{
    private static final long serialVersionUID = 1L;

    private String name;
    private Boolean nameLike = false;

    private String idCard;
    private Boolean idCardLike = false;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date birthday;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date birthdayTime;

    private Long score;

    private long book;

    private int num;

    private Integer age;

    private YesOrNoEnum classMater;

    private BigDecimal account;

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

    public Long getScore() {
        return score;
    }

    public TeacherQuery setScore(Long score) {
        this.score = score;
        return this;
    }

    public long getBook() {
        return book;
    }

    public TeacherQuery setBook(long book) {
        this.book = book;
        return this;
    }

    public int getNum() {
        return num;
    }

    public TeacherQuery setNum(int num) {
        this.num = num;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public TeacherQuery setAge(Integer age) {
        this.age = age;
        return this;
    }

    public YesOrNoEnum getClassMater() {
        return classMater;
    }

    public TeacherQuery setClassMater(YesOrNoEnum classMater) {
        this.classMater = classMater;
        return this;
    }

    public BigDecimal getAccount() {
        return account;
    }

    public TeacherQuery setAccount(BigDecimal account) {
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