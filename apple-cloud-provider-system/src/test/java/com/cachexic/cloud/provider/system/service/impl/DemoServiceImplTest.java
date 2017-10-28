package com.cachexic.cloud.provider.system.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.cachexic.cloud.common.base.entity.query.Pagination;
import com.cachexic.cloud.common.enums.YesOrNoEnum;
import com.cachexic.cloud.common.exceptions.BizException;
import com.cachexic.cloud.common.junit.TestParent;
import com.cachexic.cloud.common.utils.date.DateUtil;
import com.cachexic.cloud.common.utils.json.JsonUtil;
import com.cachexic.cloud.feign.system.entity.Demo;
import com.cachexic.cloud.feign.system.entity.query.DemoQuery;
import com.cachexic.cloud.provider.system.service.DemoService;
import com.google.common.collect.Lists;
import java.math.BigDecimal;
import java.util.List;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
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

    System.out.println(insert);
    assertTrue(insert.longValue() > 0);
  }

  @Test
  public void insertBatch() throws Exception {
    int count = 0;
    for (int i = 1; i < 10001; i++) {
      Demo demo = new Demo();
      demo.setName(RandomStringUtils.randomAlphabetic(6,10));
      demo.setAge(RandomUtils.nextInt(18,60));
      demo.setAccount(new BigDecimal("32000.88").add(new BigDecimal(i)));
      demo.setBirthday(DateUtil.parseDate("1987-08-07"));
      demo.setClassMater(i % 2 == 0 ? YesOrNoEnum.yes : YesOrNoEnum.no);
      demo.setMemo(RandomStringUtils.randomAlphabetic(20,100));
      demo.setType("地推活动,单纯匹配曝光");
      demo.setSupper(i % 2 == 0 ? true : false);
      Long insert = demoService.insert(demo);

      assertTrue(insert.longValue() > 0);
      count++;
    }
    assertTrue(count == 10000);
  }

  @Test
  public void selectById() throws Exception {
    Demo demo = demoService.selectById(129557599550210048L);
    assertTrue(StringUtils.equalsIgnoreCase(demo.getName(), "何雨柱8"));
    assertEquals(demo.getName(), "何雨柱8");
    assertTrue(demo.getAge().intValue() == 8);
    System.out.println(demo);
    System.out.println(JsonUtil.toJson(demo));
  }

  @Test
  public void selectByIds() throws Exception {
    List<Demo> demos = demoService.selectByIds(Lists
        .newArrayList(129557599550210048L, 129557599285968896L, 129557603853565952L,
            129557603719348224L));
    assertTrue(demos.size() == 4);
    System.out.println(JsonUtil.toJson(demos));
  }

  @Test
  public void update() throws Exception {
    Demo demo = new Demo();
    demo.setId(130262083641311232L);
    demo.setName("何雨柱" + "update2");
    demo.setVersion(1);
    int update = demoService.update(demo);
    System.out.println(update);
    assertTrue(update == 1);
  }

  @Test
  public void updateVersion() throws Exception {

    Demo demo = demoService.selectById(130262083641311232L);
    demo.setName("何雨柱" + "updateVersion");
    // 如果有乐观锁,需要获取version
    int update = demoService.update(demo);

    System.out.println(update);
    assertTrue(update == 1);
  }

  @Test
  public void deleteById() throws Exception {
    int delete = demoService.deleteById(129562574409990144L);
    assertTrue(delete == 1);
    Demo demo = demoService.selectById(129562574409990144L);
    assertEquals(demo.getStatus().name(),"deleted");
  }

  @Test(expected = BizException.class)
  public void deleteByIdUnSuccess() throws Exception {
    int delete = demoService.deleteById(1L);
    assertFalse(delete == 1);
  }

  /**
   * 分库分表的deleteByIds不能用,注意替换为遍历的方式
   * @throws Exception
   */
  @Test
  public void deleteByIds() throws Exception {
    List<Long> ids = Lists
        .newArrayList(129557602985345024L, 129557602821767168L, 129557602167455744L,
            129557601638973440L);
    int deletes = demoService.deleteByIds(ids);
    assertTrue(deletes == 4);

    List<Demo> demos = demoService.selectByIds(ids);
    for (Demo demo : demos) {
      assertEquals(demo.getStatus().name(),"deleted");
    }
    System.out.println(JsonUtil.toJson(demos));
  }

  @Test
  public void removeById() throws Exception {
  }

  @Test
  public void removeByIds() throws Exception {
  }

  @Test
  public void selectList() throws Exception {

    DemoQuery query = new DemoQuery();
    query.setOrderField("age").setOrderSort("desc");
    List<Demo> demos = demoService.selectList(query);
    System.out.println(JsonUtil.toJson(demos));

  }

  @Test
  public void selectListPage() throws Exception {
    DemoQuery query = new DemoQuery();
    query.setOrderField("age").setOrderSort("desc");
    List<Demo> demos = demoService.selectListPage(query);
    System.out.println(JsonUtil.toJson(demos));
  }

  @Test
  public void selectListTotal() throws Exception {
    DemoQuery query = new DemoQuery();
    query.setOrderField("age").setOrderSort("desc");
    demoService.selectListTotal(query);
    System.out.println(JsonUtil.toJson(demoService.selectListTotal(query)));
  }

  @Test
  public void selectListPagination() throws Exception {
    DemoQuery query = new DemoQuery();
    query.setOrderField("age").setOrderSort("desc");
    Pagination<Demo> demos = demoService.selectListPagination(query);
    System.out.println(JsonUtil.toJson(demos));
  }

}