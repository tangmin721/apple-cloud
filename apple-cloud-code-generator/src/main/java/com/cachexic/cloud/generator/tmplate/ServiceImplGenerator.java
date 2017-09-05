package com.cachexic.cloud.generator.tmplate;

/**
 * service Impl 模板
 *
 * @author tangmin
 * @date 2016年2月26日
 */
public class ServiceImplGenerator extends TemplateCodeGenerator {


    @Override
    public String getTemplateFile() {
        /**
         * 模板文件
         */
        return "/template/serviceImpl.ftl";
    }

}
