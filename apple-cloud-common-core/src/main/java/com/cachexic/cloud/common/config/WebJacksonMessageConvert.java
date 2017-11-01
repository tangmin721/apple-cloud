package com.cachexic.cloud.common.config;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.http.MediaType.TEXT_HTML;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.google.common.collect.Lists;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

/**
 * @author tangmin
 * @Description: 覆盖jackson的默认的objmapper配置，使得过滤NULL属性而不再显示
 * @date 2017-09-02 06:55:20
 */
@Configuration
public class WebJacksonMessageConvert {

  @Autowired
  private ObjectMapper objectMapper;

  @Bean
  public ObjectMapper objectMapper() {

    ObjectMapper objectMapper = new ObjectMapper();

    //解决java的long类型转为json格式后,js中精度丢失问题
    SimpleModule simpleModule = new SimpleModule();
    simpleModule.addSerializer(Long.class, ToStringSerializer.instance);
    simpleModule.addSerializer(Long.TYPE, ToStringSerializer.instance);
    //转换BigDecimal为字符串
    simpleModule.addSerializer(BigDecimal.class,ToStringSerializer.instance);
    objectMapper.registerModule(simpleModule);

    //配置json的返回策略
    objectMapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
    return objectMapper;
  }

  @Bean
  public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
    MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
    converter.setObjectMapper(objectMapper);
    List<MediaType> supportedMediaTypes = Lists.newArrayList();
    supportedMediaTypes.add(APPLICATION_JSON_UTF8);
    supportedMediaTypes.add(TEXT_HTML);
    converter.setSupportedMediaTypes(supportedMediaTypes);
    return converter;
  }
}
