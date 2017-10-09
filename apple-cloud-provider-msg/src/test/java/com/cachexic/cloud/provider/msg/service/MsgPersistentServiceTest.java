package com.cachexic.cloud.provider.msg.service;

import com.cachexic.cloud.common.junit.TestParent;
import com.cachexic.cloud.common.utils.id.UUIDUtil;
import com.cachexic.cloud.common.utils.json.JsonUtil;
import com.cachexic.cloud.feign.msg.entity.MsgPersistent;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by tangm on 2017/10/9.
 */
public class MsgPersistentServiceTest extends TestParent {

  @Autowired
  private MsgPersistentService msgPersistentService;

  @Test
  public void test(){
    MsgPersistent msgPersistent = new MsgPersistent();
    msgPersistent.setMsgId(UUIDUtil.get32UUID());
    msgPersistent.setConsumerQueue("consumerQueue");
    msgPersistent.setTopic("topic");
    msgPersistent.setMsgBody("msgbody");
    msgPersistentService.insert(msgPersistent);
  }

  @Test
  public void selectById(){
    MsgPersistent msgPersistent = msgPersistentService.selectById(1L);
    System.out.println(JsonUtil.toJson(msgPersistent));
  }

}