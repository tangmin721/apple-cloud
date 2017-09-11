package com.cachexic.cloud.generator.bean;

import com.cachexic.cloud.common.base.annotations.Transient;
import com.cachexic.cloud.common.utils.json.JsonUtil;
import com.cachexic.cloud.feign.order.entity.Teacher;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * 实体信息
 *
 * @author tangmin
 */
public class EntityInfo {
    /**
     * 表名：构造的时候输入
     */
    String tableName;

    /**
     * 所有实体字段集合
     */
    List<EntityField> allfieldList = new ArrayList<EntityField>();

    /**
     * 不包含id的所有字段集合
     */
    List<EntityField> allfieldNoIdList = new ArrayList<EntityField>();

    /**
     * 自己定义的 实体字段集合
     */
    List<EntityField> myfieldList = new ArrayList<EntityField>();

    /**
     * 自己定义的 实体字段集合  不包含@Transient注解的字段
     */
    List<EntityField> myfieldListNotTransient = new ArrayList<EntityField>();

    /**
     * 全类名
     */
    String fullClassName;

    /**
     * query的类名
     */
    String fullQueryClassName;

    /**
     * 类名
     */
    String className;

    /**
     * 首字母小写
     */
    String firstLowName;

    /**
     * 驼峰转下划线
     */
    String underLineName;

    public EntityInfo(Class<?> clazz, String tableName) {
        parse(clazz);
        this.tableName = tableName;
    }

    /**
     * 获取父类，本类所有属性字段
     *
     * @param clazz
     */
    private void parse(Class<?> clazz) {
        String simpleName = clazz.getSimpleName();
        String fname = clazz.getName();

        this.className = simpleName;
        this.fullClassName = fname;
        this.fullQueryClassName = fname.substring(0,fname.length()-simpleName.length())+"query."+simpleName+"Query";
        System.out.println(fullQueryClassName);
        this.firstLowName = StringUtils.uncapitalize(simpleName);//首字母小写
        this.underLineName = AppStringUtils.camelToUnderline(this.firstLowName);//驼峰转下划线

        List<Field> fieldList = new ArrayList<>();
        Class<?> superClazz = clazz.getSuperclass();
        if (superClazz.getSuperclass() != null && !superClazz.getSuperclass().getName().toLowerCase().equals("java.lang.object")) {
            fieldList.addAll(Arrays.asList(superClazz.getSuperclass().getDeclaredFields()));
        }

        Object o = new Object();
        try {
            o = clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        //父类的字段
        fieldList.addAll(Arrays.asList(clazz.getSuperclass().getDeclaredFields()));
        for (Field field : fieldList) {
            EntityField eField = changeFieldToEntityField(field, o);
            if (field.getName() != "serialVersionUID") {
                this.allfieldList.add(eField);
                if (field.getName() != "id") {
                    this.allfieldNoIdList.add(eField);
                }
            }
        }

        //本类的字段
        for (Field field : clazz.getDeclaredFields()) {
            EntityField eField = changeFieldToEntityField(field, o);
            if (field.getName() != "serialVersionUID") {
                if (field.isAnnotationPresent(Transient.class)) {
                    this.allfieldList.add(eField);
                    this.myfieldList.add(eField);
                    this.allfieldNoIdList.add(eField);
                } else {
                    this.myfieldListNotTransient.add(eField);
                    this.allfieldList.add(eField);
                    this.myfieldList.add(eField);
                    this.allfieldNoIdList.add(eField);
                }
            }
        }

    }

    public static void main(String[] args) {
//        EntityInfo entityInfo = new EntityInfo(EntityField.class, "test_table");
//        System.out.println(entityInfo);
//        System.out.println(Teacher.class.isAnnotationPresent(Entity.class));

        Teacher teacher = new Teacher();

        List<EntityField> entityFields = Lists.newArrayList();

        for (Field field : Teacher.class.getDeclaredFields()) {

            EntityField entityField = changeFieldToEntityField(field, teacher);
            entityFields.add(entityField);
        }
        System.out.println(JsonUtil.toJson(entityFields));
    }

    private static EntityField changeFieldToEntityField(Field field, Object object) {
        Object defalutValue = getFieldValue(object, field.getName());

        EntityField entityField = new EntityField();
        entityField.setFieldName(field.getName());
        entityField.setFieldTypeClassName(field.getGenericType().toString());
        entityField.setColumnName(AppStringUtils.camelToUnderline(field.getName()));//驼峰转下划线

        StringBuilder mysqlStament = new StringBuilder("`"+entityField.getColumnName()+"`")
            .append(" ");
        if (field.getType().isAssignableFrom(String.class)) {//字符串
            int length = 255;//默认长度
            mysqlStament.append("varchar(");

            if (field.isAnnotationPresent(Size.class)) {
                length = field.getAnnotation(Size.class).max();
            } else if (field.isAnnotationPresent(Length.class)) {
                length = field.getAnnotation(Length.class).max();
            }
            if (length == 2147483647) {
                length = 255;
            }
            mysqlStament.append(length + ")").append(" COLLATE utf8mb4_unicode_ci ");

            if (field.isAnnotationPresent(NotNull.class) || field.isAnnotationPresent(NotBlank.class) || field.isAnnotationPresent(NotEmpty.class)) {
                mysqlStament.append("NOT NULL ");
            }
            if(defalutValue==null){
                mysqlStament.append("DEFAULT '' ");
            }else {
                mysqlStament.append("DEFAULT '" + defalutValue + "' ");
            }

        } else if (field.getType().isAssignableFrom(Long.class) || field.getType().getSimpleName().equals("long")) {
            mysqlStament.append("bigint").append(" ");
            if (field.isAnnotationPresent(NotNull.class) || field.isAnnotationPresent(NotBlank.class) || field.isAnnotationPresent(NotEmpty.class)) {
                mysqlStament.append("NOT NULL ");
            }
            if (defalutValue != null) {
                mysqlStament.append("DEFAULT '" + defalutValue + "'");
            }
        } else if (field.getType().isAssignableFrom(Integer.class) || field.getType().getSimpleName().equals("int")) {
            mysqlStament.append("int").append(" ");
            if (field.isAnnotationPresent(NotNull.class) || field.isAnnotationPresent(NotBlank.class) || field.isAnnotationPresent(NotEmpty.class)) {
                mysqlStament.append("NOT NULL ");
            }
            if (defalutValue != null) {
                mysqlStament.append("DEFAULT '" + defalutValue + "'");
            }
        } else if (field.getType().isAssignableFrom(BigDecimal.class)) {
            mysqlStament.append("decimal(20,2) NOT NULL DEFAULT '0.00'").append(" ");
        } else if (field.getType().isAssignableFrom(Date.class)) {
            String datatype = "datetime";
            if (field.isAnnotationPresent(DateTimeFormat.class)) {
                if ("yyyy-MM-dd".equals(field.getAnnotation(DateTimeFormat.class).pattern())) {
                    datatype = "date";
                }
            } else if (field.isAnnotationPresent(JsonFormat.class)) {
                if ("yyyy-MM-dd".equals(field.getAnnotation(JsonFormat.class).pattern())) {
                    datatype = "date";
                }
            }
            mysqlStament.append(datatype);
            if (field.isAnnotationPresent(NotNull.class) || field.isAnnotationPresent(NotBlank.class) || field.isAnnotationPresent(NotEmpty.class)) {
                mysqlStament.append(" NOT NULL");
            }
        } else if (field.getType().isEnum()) {
            mysqlStament.append("enum(");
            Class<Enum> enumClass = (Class<Enum>) field.getType();
            Enum[] constants = enumClass.getEnumConstants();
            String tmp = "";
            for (Enum constant : constants) {
                tmp = tmp + "'" + constant.name() + "',";
            }
            tmp = tmp.substring(0, tmp.length() - 1);
            mysqlStament.append(tmp);
            mysqlStament.append(") ");
            if (defalutValue != null) {
                mysqlStament.append("DEFAULT '" + defalutValue + "'");
            }
        }else if(field.getType().isAssignableFrom(Boolean.class) || field.getType().getSimpleName().equals("boolean")){
            mysqlStament.append("bit(1)").append(" ");
            if (field.isAnnotationPresent(NotNull.class) || field.isAnnotationPresent(NotBlank.class) || field.isAnnotationPresent(NotEmpty.class)) {
                mysqlStament.append("NOT NULL ");
            }
            if (defalutValue != null) {
                if((Boolean) defalutValue){
                    mysqlStament.append("DEFAULT b'1'");
                }else {
                    mysqlStament.append("DEFAULT b'0'");
                }
            }
        }
        mysqlStament.append(" COMMENT '").append(field.getName()).append("描述'");

       /* StringBuffer builder = new StringBuffer();
        builder.append("fieldName:" + field.getName());
        builder.append(",defalutValue:" + defalutValue);
        builder.append(",Transient:" + field.isAnnotationPresent(Transient.class));
        builder.append(",enum:" + field.getType().isEnum());
        builder.append(",simpleName:" + field.getType().getSimpleName());

        if (field.isAnnotationPresent(Size.class)) {
            builder.append(",max:" + field.getAnnotation(Size.class).max());
        } else if (field.isAnnotationPresent(Length.class)) {
            builder.append(",max:" + field.getAnnotation(Length.class).max());
        }

        System.out.println(builder.toString());*/
        entityField.setMysqlFieldStr(mysqlStament.toString());
        return entityField;
    }

    public String getVarName() {
        String name = this.getClassName();
        return name.substring(0, 1).toLowerCase() + name.substring(1, name.length());
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public List<EntityField> getAllfieldList() {
        return allfieldList;
    }

    public void setAllfieldList(List<EntityField> allfieldList) {
        this.allfieldList = allfieldList;
    }

    public List<EntityField> getAllfieldNoIdList() {
        return allfieldNoIdList;
    }

    public void setAllfieldNoIdList(List<EntityField> allfieldNoIdList) {
        this.allfieldNoIdList = allfieldNoIdList;
    }

    public List<EntityField> getMyfieldList() {
        return myfieldList;
    }

    public void setMyfieldList(List<EntityField> myfieldList) {
        this.myfieldList = myfieldList;
    }

    public String getFullClassName() {
        return fullClassName;
    }

    public void setFullClassName(String fullClassName) {
        this.fullClassName = fullClassName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getFirstLowName() {
        return firstLowName;
    }

    public void setFirstLowName(String firstLowName) {
        this.firstLowName = firstLowName;
    }

    public String getUnderLineName() {
        return underLineName;
    }

    public void setUnderLineName(String underLineName) {
        this.underLineName = underLineName;
    }

    public List<EntityField> getMyfieldListNotTransient() {
        return myfieldListNotTransient;
    }

    public void setMyfieldListNotTransient(List<EntityField> myfieldListNotTransient) {
        this.myfieldListNotTransient = myfieldListNotTransient;
    }

    @Override
    public String toString() {
        return "EntityInfo [tableName=" + tableName + ", allfieldList="
            + allfieldList + ", myfieldList=" + myfieldList
            + ", fullClassName=" + fullClassName + ", className="
            + className + ", firstLowName=" + firstLowName
            + ", underLineName=" + underLineName + "]";
    }

    public String getFullQueryClassName() {
        return fullQueryClassName;
    }

    public void setFullQueryClassName(String fullQueryClassName) {
        this.fullQueryClassName = fullQueryClassName;
    }

    public static Field getDeclaredField(Object object, String fieldName) {
        Field field = null;

        Class<?> clazz = object.getClass();

        for (; clazz != Object.class; clazz = clazz.getSuperclass()) {
            try {
                field = clazz.getDeclaredField(fieldName);
                return field;
            } catch (Exception e) {
                //这里甚么都不要做！并且这里的异常必须这样写，不能抛出去。
                //如果这里的异常打印或者往外抛，则就不会执行clazz = clazz.getSuperclass(),最后就不会进入到父类中了

            }
        }

        return null;
    }

    public static Object getFieldValue(Object object, String fieldName) {

        //根据 对象和属性名通过反射 调用上面的方法获取 Field对象
        Field field = getDeclaredField(object, fieldName);

        //抑制Java对其的检查
        field.setAccessible(true);

        try {
            //获取 object 中 field 所代表的属性值
            return field.get(object);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}