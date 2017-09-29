package com.cachexic.cloud.generator.tmplate;

import com.cachexic.cloud.generator.bean.EntityInfo;
import com.cachexic.cloud.generator.bean.GenConfig;
import freemarker.ext.beans.BeanModel;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;

import java.io.InputStreamReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * 模板 父类
 *
 * @author tangmin
 * @date 2016年2月26日
 */
public abstract class TemplateCodeGenerator {

  private Configuration cfg;

  private Locale locale = Locale.getDefault();

  private String encode = "UTF-8";

  private String numberformat = "##############.##";

  private String dateformat = "yyyy-MM-dd";

  private String datetimeformat = "yyyy-MM-dd HH:mm:ss";

//	private String templateFile = "pagetemplate.ftl";

  public abstract String getTemplateFile();

  /**
   * freemark根据模板生成code的方法
   */
  public String generateCode(EntityInfo entityInfo, GenConfig genConfig) throws Exception {
    cfg = new Configuration();
    cfg.setEncoding(locale, encode);

    DefaultObjectWrapper ow = (DefaultObjectWrapper) cfg.getObjectWrapper();

    cfg.setSharedVariable("static", ow.getStaticModels());
    cfg.setSharedVariable("enums", ow.getStaticModels());

    //cfg.setObjectWrapper(wrapper);
    cfg.setNumberFormat(numberformat);
    cfg.setDateFormat(dateformat);
    cfg.setDateTimeFormat(datetimeformat);

    Template template = new Template("template",
        new InputStreamReader(this.getClass().getResourceAsStream(this.getTemplateFile()), "UTF-8"),
        cfg);
    Map<String, Object> model = new HashMap<String, Object>();
    model.put("entity", entityInfo);
    model.put("CONFIG", genConfig);

    BeanModel beanModel = new BeanModel(model, ow);
    Writer writer = new StringWriter();
    template.process(beanModel, writer);
    writer.flush();
    writer.close();
    return writer.toString();
  }

}
