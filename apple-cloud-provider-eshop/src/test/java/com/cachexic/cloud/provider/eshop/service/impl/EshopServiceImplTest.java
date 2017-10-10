package com.cachexic.cloud.provider.eshop.service.impl;

import com.cachexic.cloud.common.junit.TestParent;
import com.cachexic.cloud.feign.eshop.entity.Eshop;
import com.cachexic.cloud.provider.eshop.service.EshopService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by tangm on 2017/10/10.
 */
public class EshopServiceImplTest extends TestParent {

  @Autowired
  private EshopService eshopService;

  @Test
  public void insert() throws Exception {
    Eshop eshop = new Eshop();
    eshop.setName("e店1");
    eshop.setCode("1");
    eshopService.insert(eshop);
  }

  @Test
  public void insertBatch() throws Exception {

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