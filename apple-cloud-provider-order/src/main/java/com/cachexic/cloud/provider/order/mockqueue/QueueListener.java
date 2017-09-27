/**
 *
 */
package com.cachexic.cloud.provider.order.mockqueue;

import com.cachexic.cloud.common.base.Result;
import com.cachexic.cloud.common.utils.id.IdsUtil;
import com.cachexic.cloud.feign.order.entity.Teacher;
import com.cachexic.cloud.provider.order.service.TeacherService;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @author tangmin
 * @Description: 启动监听的方式2
 * @date 2017-09-27 18:36:02
 */
@Component
public class QueueListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private MockQueue mockQueue;

    @Autowired
    private DeferredResultHolder<Result<List<Teacher>>> deferredResultHolder;

    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 启动线程
     */
    public void start() {

    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        new Thread(() -> {
            while (true) {

                if (StringUtils.isNotBlank(mockQueue.getCompleteOrder())) {

                    String orderNumber = mockQueue.getCompleteOrder();
                    logger.info("返回订单处理结果:" + orderNumber);
                    deferredResultHolder.getMap().get(orderNumber).setResult(Result.OK().setData(teacherService.selectByIds(IdsUtil.listLong(orderNumber))));
                    mockQueue.setCompleteOrder(null);

                } else {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }).start();
    }
}
