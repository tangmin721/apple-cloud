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
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import org.apache.commons.lang3.time.DateUtils;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author tangmin
 * @Description: 代码生成器测试类
 * @date 2017-09-10 14:01:30
 */
@Entity("t_teacher")
public class Teacher extends BaseEntity{

    @NotBlank(message="姓名{不能为空}",groups={Insert.class,Update.class})
    @Size(max=20,message="姓名长度不能超过20",groups={Insert.class,Update.class})
    private String name = "hehe";

    @Length(message="身份证件号最大长度不能超过18位",max = 18,groups={Insert.class,Update.class})
    private String idCard;

    @NotNull(message="出生日期",groups={Insert.class,Update.class})
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Past(message="出生日期只能为过去的时间",groups={Insert.class,Update.class})
    private Date birthday;

    private Date birthdayTime;

    @NotNull
    private Long ageLong1;
    private Long ageLong2=2L;

    private int num;

    @NotNull
    private Integer age =1;

    /** 不映射数据库列（insert方法没有） */
    @Transient
    private String nameTransient;

    /** 是否班主任 */
    private YesOrNoEnum classMater = YesOrNoEnum.no;

    /** 账户金额 */
    private BigDecimal account;

    /** 是否是特级教师 */
    private Boolean isSupper = true;

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
        return isSupper;
    }

    public void setSupper(Boolean supper) {
        isSupper = supper;
    }

    /**
     * 测试
     * @param args
     * @throws ParseException
     */
    public static void main(String[] args) throws ParseException {
        Teacher testTable = new Teacher();
        testTable.setName("DADAWDADADADADAFSAADAD");
        testTable.setBirthday(DateUtils.parseDate("2011-10-11","yyyy-MM-dd"));
        testTable.setAge(129);
        System.out.println("::::校验结果："+ JsonUtil.toJson(BeanValidator.validateResult(testTable,Insert.class)));
    }
}
