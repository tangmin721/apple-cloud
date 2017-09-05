package com.cachexic.cloud.generator;

import com.cachexic.cloud.common.base.entity.BaseEntity;
import com.cachexic.cloud.generator.bean.IdTypeEnum;
import com.cachexic.cloud.generator.code.CodeGenerator;

/**
 * @author tangmin
 * @version V1.0
 * @Title: CodeCreateGeneratorMain.java
 * @Package com.gasq.cloud.generator
 * @Description: 代码生成工具
 * @date 2017-04-27 11:00:50
 */
public class CodeCreateGeneratorMain {

    /**
     * 生成代码的main方法，运行此方法即可
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        CodeGenerator codeGen = new CodeGenerator();
        //1、配置需要生成的类
        codeGen.addClass(BaseEntity.class);
        //1.1、主键策略（根据entity的PK类型设idType，如果PK为Long则设置：AUTO_INCR。如果PK为String，则设置为：UUID）
        codeGen.setIdType(IdTypeEnum.AUTO_INCR.getCode());
        //1.2、是否继承BaseEntity （如果是继承BaseEntity设置"true"，如果是继承：PojoBaseEntity，则设置为"false"）
        codeGen.setExtendBaseEntity("true");

        //2、配置微服务名称(对应的是微服务模块：customer,employee,order,store,support,thirdparty)
        codeGen.setServerName("order");
        //3、配置requestMapping
        codeGen.setRequestMapPath("order");
        //4、配置对应的数据库表名
        codeGen.setTableName("t_test_customerorder");
        //5、配置模块名称
        codeGen.setModelName("测试基础信息");

        //7、代码生成存放位置
        codeGen.outPut("e:\\code\\user\\cuz");
        System.out.println("代码生成成功");
    }

}
