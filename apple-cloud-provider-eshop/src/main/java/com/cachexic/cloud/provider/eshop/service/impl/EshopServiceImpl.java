package com.cachexic.cloud.provider.eshop.service.impl;

import com.cachexic.cloud.common.base.service.impl.BaseServiceImpl;
import com.cachexic.cloud.feign.eshop.entity.Eshop;
import com.cachexic.cloud.feign.eshop.entity.query.EshopQuery;
import com.cachexic.cloud.provider.eshop.service.EshopService;
import org.springframework.stereotype.Service;

/**
 * @Description: e店管理
 * @author tangmin
 * @date 2017-10-10 21:00:52
 */
@Service("eshopService")
public class EshopServiceImpl extends BaseServiceImpl<Eshop, EshopQuery> implements EshopService{

}