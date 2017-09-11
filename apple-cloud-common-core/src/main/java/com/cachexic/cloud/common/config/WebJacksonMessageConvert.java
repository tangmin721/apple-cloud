package com.cachexic.cloud.common.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.http.MediaType.TEXT_HTML;

/**
 * @author tangmin
 * @version V1.0
 * @Title: WebJacksonMessageConvert.java
 * @Package com.cachexic.sjdbc.common.config
 * @Description: 覆盖jackson的默认的objmapper配置，使得过滤NULL属性而不再显示
 * @date 2017-09-02 06:55:20
 */
@Configuration
public class WebJacksonMessageConvert {
    @Autowired
    private ObjectMapper objectMapper;

    @Bean
    public ObjectMapper objectMapper(){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        return objectMapper;
    }


    @Bean
    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter(){
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setObjectMapper(objectMapper);
        List<MediaType> supportedMediaTypes = Lists.newArrayList();
        supportedMediaTypes.add(APPLICATION_JSON_UTF8);
        supportedMediaTypes.add(TEXT_HTML);
        converter.setSupportedMediaTypes(supportedMediaTypes);
        return converter;
    }
}
