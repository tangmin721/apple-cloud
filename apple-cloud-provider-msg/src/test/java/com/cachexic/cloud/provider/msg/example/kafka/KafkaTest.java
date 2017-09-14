package com.cachexic.cloud.provider.msg.example.kafka;

import com.cachexic.cloud.common.junit.TestParent;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

/**
 * Created by tangm on 2017/9/14.
 */
public class KafkaTest extends TestParent{

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Test
    public void testKafkaSend(){
        kafkaTemplate.send("my-topic4","hello kafka");
    }
}
