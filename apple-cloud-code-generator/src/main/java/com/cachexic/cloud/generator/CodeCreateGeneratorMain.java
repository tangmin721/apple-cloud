package com.cachexic.cloud.generator;

import com.cachexic.cloud.feign.eshop.entity.Eshop;
import com.cachexic.cloud.generator.code.CodeGenerator;

/**
 * @author tangmin
 * @version V1.0
 */
public class CodeCreateGeneratorMain {

  /**
   * 生成代码的main方法，运行此方法即可
   */
  public static void main(String[] args) throws Exception {
    CodeGenerator codeGen = new CodeGenerator();
    //1、配置需要生成的类
    codeGen.setClazz(Eshop.class);
    //2、是否继承BaseEntity （如果是继承BaseEntity设置"true"，如果是继承：PojoBaseEntity，则设置为"false"）
    codeGen.setExtendBaseEntity("true");
    //3、是否启用乐观锁
    codeGen.setOpenVersion("false");
    //4、配置微服务名称(对应的是微服务模块：order,msg,eshop)
    codeGen.setServerName("eshop");
    //5、配置模块名称
    codeGen.setModelName("e店");
    //6、配置开发负责人姓名
    codeGen.setAuthor("tangmin");
    //7、代码生成存放位置
    codeGen
        .outPut("e:\\code\\" + codeGen.getServerName() + "\\" + codeGen.getClazz().getSimpleName());
  }

}
