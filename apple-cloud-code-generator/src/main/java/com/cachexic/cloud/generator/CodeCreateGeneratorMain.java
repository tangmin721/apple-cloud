package com.cachexic.cloud.generator;

import com.cachexic.cloud.feign.order.entity.Teacher;
import com.cachexic.cloud.generator.code.CodeGenerator;

/**
 * @author tangmin
 * @version V1.0
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
        codeGen.setClazz(Teacher.class);
        //2、是否继承BaseEntity （如果是继承BaseEntity设置"true"，如果是继承：PojoBaseEntity，则设置为"false"）
        codeGen.setExtendBaseEntity("true");
        //3、是否启用乐观锁
        codeGen.setOpenVersion("false");
        //4、配置微服务名称(对应的是微服务模块：order,msg)
        codeGen.setServerName("order");
        //5、配置模块名称
        codeGen.setModelName("教师测试实体");
        //6、代码生成存放位置
        codeGen.outPut("e:\\code\\"+codeGen.getServerName()+"\\" + codeGen.getClazz().getSimpleName());
    }

}
