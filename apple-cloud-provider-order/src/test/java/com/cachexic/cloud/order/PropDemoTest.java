package com.cachexic.cloud.order;

import com.cachexic.cloud.common.junit.TestParent;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class PropDemoTest extends TestParent{

    @Autowired
    private PropDemo propDemo;

    @Test
    public void test(){
        propDemo.test();
    }
}
