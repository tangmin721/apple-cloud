package com.cachexic.cloud.order;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by tangm on 2017/9/5.
 */
@Service
public class PropDemo {

    @Value("${eureka.instance.client.serviceUrl.defaultZone}")
    private String test;

    public void test(){
        System.out.println(test);
    }

}
