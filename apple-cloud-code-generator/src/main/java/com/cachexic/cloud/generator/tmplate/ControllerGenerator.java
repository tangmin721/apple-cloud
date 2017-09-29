package com.cachexic.cloud.generator.tmplate;

/**
 * controller层模板
 *
 * @author tangmin
 * @date 2016年3月2日
 */
public class ControllerGenerator extends TemplateCodeGenerator {

  @Override
  public String getTemplateFile() {
    /**
     * 模板文件
     */
    return "/template/controller.ftl";
  }

}
