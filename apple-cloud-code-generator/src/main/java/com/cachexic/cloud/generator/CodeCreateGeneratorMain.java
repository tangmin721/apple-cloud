package com.cachexic.cloud.generator;

import com.cachexic.cloud.feign.order.entity.Order;
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
        codeGen.setClazz(Order.class);
        //2、是否继承BaseEntity （如果是继承BaseEntity设置"true"，如果是继承：PojoBaseEntity，则设置为"false"）
        codeGen.setExtendBaseEntity("true");
        //3、配置微服务名称(对应的是微服务模块：order,msg)
        codeGen.setServerName("order");
        //4、配置模块名称
        codeGen.setModelName("订单");

        //5、代码生成存放位置
        codeGen.outPut("e:\\code\\order\\" + codeGen.getClazz().getSimpleName());
        System.out.println("代码生成成功");
    }

}
