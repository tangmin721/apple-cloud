package com.cachexic.cloud.generator.tmplate;

/**
 * Service模板
 *
 * @author tangmin
 * @date 2016年2月29日
 */
public class ServiceGenerator extends TemplateCodeGenerator {

  @Override
  public String getTemplateFile() {
    /**
     * 模板文件
     */
    return "/template/service.ftl";
  }

}
