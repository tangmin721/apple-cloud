package com.yanxiu.ce.system;

import com.gasq.cloud.feign.${CONFIG.serverName}.feign.${entity.className}FeignClient;

/**
 * @Description: ${CONFIG.modelName}管理  返回的工厂接口
 * @author ${CONFIG.author}
 * @date ${.now?string("yyyy-MM-dd HH:mm:ss")}
 */
public interface ${entity.className}FeignClientWithFallbackFactory extends ${entity.className}FeignClient{

}
