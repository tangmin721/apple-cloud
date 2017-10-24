package com.cachexic.cloud.provider.system.service.impl;

import com.cachexic.cloud.common.base.service.impl.BaseServiceImpl;
import com.cachexic.cloud.feign.system.entity.Demo;
import com.cachexic.cloud.feign.system.entity.query.DemoQuery;
import com.cachexic.cloud.provider.system.service.DemoService;
import org.springframework.stereotype.Service;

/**
 * @Description: DEMO管理
 * @author tangmin
 * @date 2017-10-24 10:32:30
 */
@Service("demoService")
public class DemoServiceImpl extends BaseServiceImpl<Demo, DemoQuery> implements DemoService{

}