package com.cachexic.cloud.generator.tmplate;

/**
 * jsp List模板
 *
 * @author tangmin
 * @date 2016年3月2日
 */
public class FeignClientFallbackFactoryGenerator extends TemplateCodeGenerator {

  @Override
  public String getTemplateFile() {
    /**
     * 模板文件
     */
    return "/template/feignClientFallbackFactory.ftl";
  }

}
