package com.cachexic.cloud.generator.tmplate;

/**
 * jsp Form模板
 *
 * @author tangmin
 * @date 2016年3月2日
 */
public class FeignClientGenerator extends TemplateCodeGenerator {

    @Override
    public String getTemplateFile() {
        /**
         * 模板文件
         */
        return "/template/feignClient.ftl";
    }

}
