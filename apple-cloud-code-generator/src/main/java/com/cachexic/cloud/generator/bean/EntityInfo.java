package com.cachexic.cloud.generator.bean;

import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 实体信息
 *
 * @author tangmin
 * @date 2016年2月26日
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
     * 实体字段集合
     */
    List<EntityField> myfieldList = new ArrayList<EntityField>();

    /**
     * 全类名
     */
    String fullClassName;

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
        this.className = clazz.getSimpleName();
        this.fullClassName = clazz.getName();
        this.firstLowName = StringUtils.uncapitalize(clazz.getSimpleName());//首字母小写
        this.underLineName = AppStringUtils.camelToUnderline(this.firstLowName);//驼峰转下划线

        List<Field> fieldList = new ArrayList<>();
        Class<?> superClazz = clazz.getSuperclass();
        if (superClazz.getSuperclass() != null && !superClazz.getSuperclass().getName().toLowerCase().equals("java.lang.object")) {
            fieldList.addAll(Arrays.asList(superClazz.getSuperclass().getDeclaredFields()));
        }
        fieldList.addAll(Arrays.asList(clazz.getSuperclass().getDeclaredFields()));
        for (Field field : fieldList) {
            EntityField eField = new EntityField();
            eField.setFieldTypeClassName(field.getGenericType().toString());
            eField.setFieldName(field.getName());
            eField.setColumnName(AppStringUtils.camelToUnderline(field.getName()));//驼峰转下划线
            if (field.getName() != "serialVersionUID") {
                this.allfieldList.add(eField);
                if (field.getName() != "id") {
                    this.allfieldNoIdList.add(eField);
                }
            }
        }
        for (Field field : clazz.getDeclaredFields()) {
            EntityField eField = new EntityField();
            eField.setFieldName(field.getName());
            eField.setFieldTypeClassName(field.getGenericType().toString());
            eField.setColumnName(AppStringUtils.camelToUnderline(field.getName()));//驼峰转下划线
            if (field.getName() != "serialVersionUID") {
                this.allfieldList.add(eField);
                this.myfieldList.add(eField);
                this.allfieldNoIdList.add(eField);
            }
        }


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


    @Override
    public String toString() {
        return "EntityInfo [tableName=" + tableName + ", allfieldList="
                + allfieldList + ", myfieldList=" + myfieldList
                + ", fullClassName=" + fullClassName + ", className="
                + className + ", firstLowName=" + firstLowName
                + ", underLineName=" + underLineName + "]";
    }

    /**
     * 测试下
     *
     * @param args
     */
    public static void main(String[] args) {
        EntityInfo entityInfo = new EntityInfo(EntityField.class, "test_table");
        System.out.println(entityInfo);
    }

}