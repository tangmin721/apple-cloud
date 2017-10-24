package com.cachexic.cloud.provider.system.service.impl;

import static org.junit.Assert.assertTrue;

import com.cachexic.cloud.common.enums.YesOrNoEnum;
import com.cachexic.cloud.common.junit.TestParent;
import com.cachexic.cloud.common.utils.date.DateUtil;
import com.cachexic.cloud.feign.system.entity.Demo;
import com.cachexic.cloud.provider.system.service.DemoService;
import java.math.BigDecimal;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by tangm on 2017/10/24.
 */
public class DemoServiceImplTest extends TestParent {

  @Autowired
  private DemoService demoService;

  @Test
  public void insert() throws Exception {
    Demo demo = new Demo();
    demo.setName("何雨柱");
    demo.setNameTransient("傻柱");
    demo.setAge(30);
    demo.setAccount(new BigDecimal("32000.88"));
    demo.setBirthday(DateUtil.parseDate("1987-08-07"));
    demo.setClassMater(YesOrNoEnum.yes);
    demo.setSupper(true);
    Long insert = demoService.insert(demo);
    assertTrue(insert.longValue() > 0);
  }

  @Test
  public void insertBatch() throws Exception {
    int count = 0;
    for (int i = 1; i < 101; i++) {
      Demo demo = new Demo();
      demo.setName("何雨柱" + i);
      demo.setNameTransient("傻柱");
      demo.setAge(i);
      demo.setAccount(new BigDecimal("32000.88").add(new BigDecimal(i)));
      demo.setBirthday(DateUtil.parseDate("1987-08-07"));
      demo.setClassMater(i % 2 == 0 ? YesOrNoEnum.yes : YesOrNoEnum.no);
      demo.setSupper(i % 2 == 0 ? true : false);
      Long insert = demoService.insert(demo);
      assertTrue(insert.longValue() > 0);
      count++;
    }
    assertTrue(count==100);
  }

  @Test
  public void selectById() throws Exception {
  }

  @Test
  public void selectByIds() throws Exception {
  }

  @Test
  public void selectById1() throws Exception {
  }

  @Test
  public void selectByIds1() throws Exception {
  }

  @Test
  public void update() throws Exception {
  }

  @Test
  public void deleteById() throws Exception {
  }

  @Test
  public void deleteByIds() throws Exception {
  }

  @Test
  public void removeById() throws Exception {
  }

  @Test
  public void removeByIds() throws Exception {
  }

  @Test
  public void selectList() throws Exception {
  }

  @Test
  public void selectListPage() throws Exception {
  }

  @Test
  public void selectListTotal() throws Exception {
  }

  @Test
  public void selectListPagination() throws Exception {
  }

}