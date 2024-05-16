package com.ralph.bean.scope;

import com.ralph.bean.BaseTest;
import com.ralph.domain.pojo.LifeCycleCallback;
import com.ralph.service.LifeCycleService;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @ClassName: LifeCycleTest
 * @description:
 * @author: Neng.Tian
 * @create: 2024-04-11 14:40
 **/
public class LifeCycleTest extends BaseTest {

    @Test
    public void trigger() {
        LifeCycleService lifeCycleService = applicationContext.getBean("lifeCycleService", LifeCycleService.class);
        String tag = lifeCycleService.getTag();

        System.out.println("tag = " + tag);
        System.out.println("destroy container manually");
        ((ConfigurableApplicationContext)applicationContext).close();
        System.out.println("container destroyed");
    }

    @Test
    public void defaultCallbackMethod() {
        LifeCycleCallback lifeCycleCallback = applicationContext.getBean("lifeCycleCallback", LifeCycleCallback.class);
        System.out.println("lifeCycleCallback = " + lifeCycleCallback);
        ((ConfigurableApplicationContext) applicationContext).close();
    }
}
