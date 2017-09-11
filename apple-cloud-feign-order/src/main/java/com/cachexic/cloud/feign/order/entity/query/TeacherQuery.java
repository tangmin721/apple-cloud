package com.cachexic.cloud.feign.order.entity.query;

import com.cachexic.cloud.common.base.entity.query.BaseQuery;

/**
 * 教师管理
 * @author tangmin
 * @date 2017-09-11 17:31:24
 */
public class TeacherQuery extends BaseQuery{
    private static final long serialVersionUID = 1L;

    private String name;
    private Boolean nameLike = false;
    private String idCard;
    private Boolean idCardLike = false;
    private String birthday;
    private Boolean birthdayLike = false;
    private String birthdayTime;
    private Boolean birthdayTimeLike = false;
    private String score;
    private Boolean scoreLike = false;
    private String book;
    private Boolean bookLike = false;
    private String num;
    private Boolean numLike = false;
    private String age;
    private Boolean ageLike = false;
    private String nameTransient;
    private Boolean nameTransientLike = false;
    private String classMater;
    private Boolean classMaterLike = false;
    private String account;
    private Boolean accountLike = false;
    private String supper;
    private Boolean supperLike = false;

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
    public String getBirthday() {
        return birthday;
    }
    public TeacherQuery setBirthday(String birthday) {
        this.birthday = birthday;
        return this;
    }
    public Boolean getBirthdayLike() {
        return birthdayLike;
    }
    public TeacherQuery setBirthdayLike(Boolean birthdayLike) {
        this.birthdayLike = birthdayLike;
        return this;
    }
    public String getBirthdayTime() {
        return birthdayTime;
    }
    public TeacherQuery setBirthdayTime(String birthdayTime) {
        this.birthdayTime = birthdayTime;
        return this;
    }
    public Boolean getBirthdayTimeLike() {
        return birthdayTimeLike;
    }
    public TeacherQuery setBirthdayTimeLike(Boolean birthdayTimeLike) {
        this.birthdayTimeLike = birthdayTimeLike;
        return this;
    }
    public String getScore() {
        return score;
    }
    public TeacherQuery setScore(String score) {
        this.score = score;
        return this;
    }
    public Boolean getScoreLike() {
        return scoreLike;
    }
    public TeacherQuery setScoreLike(Boolean scoreLike) {
        this.scoreLike = scoreLike;
        return this;
    }
    public String getBook() {
        return book;
    }
    public TeacherQuery setBook(String book) {
        this.book = book;
        return this;
    }
    public Boolean getBookLike() {
        return bookLike;
    }
    public TeacherQuery setBookLike(Boolean bookLike) {
        this.bookLike = bookLike;
        return this;
    }
    public String getNum() {
        return num;
    }
    public TeacherQuery setNum(String num) {
        this.num = num;
        return this;
    }
    public Boolean getNumLike() {
        return numLike;
    }
    public TeacherQuery setNumLike(Boolean numLike) {
        this.numLike = numLike;
        return this;
    }
    public String getAge() {
        return age;
    }
    public TeacherQuery setAge(String age) {
        this.age = age;
        return this;
    }
    public Boolean getAgeLike() {
        return ageLike;
    }
    public TeacherQuery setAgeLike(Boolean ageLike) {
        this.ageLike = ageLike;
        return this;
    }
    public String getClassMater() {
        return classMater;
    }
    public TeacherQuery setClassMater(String classMater) {
        this.classMater = classMater;
        return this;
    }
    public Boolean getClassMaterLike() {
        return classMaterLike;
    }
    public TeacherQuery setClassMaterLike(Boolean classMaterLike) {
        this.classMaterLike = classMaterLike;
        return this;
    }
    public String getAccount() {
        return account;
    }
    public TeacherQuery setAccount(String account) {
        this.account = account;
        return this;
    }
    public Boolean getAccountLike() {
        return accountLike;
    }
    public TeacherQuery setAccountLike(Boolean accountLike) {
        this.accountLike = accountLike;
        return this;
    }
    public String getSupper() {
        return supper;
    }
    public TeacherQuery setSupper(String supper) {
        this.supper = supper;
        return this;
    }
    public Boolean getSupperLike() {
        return supperLike;
    }
    public TeacherQuery setSupperLike(Boolean supperLike) {
        this.supperLike = supperLike;
        return this;
    }

}