package com.ralph.bean;

import com.ralph.service.ClientService;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * @ClassName: FactoryTest
 * @description:
 * @author: Neng.Tian
 * @create: 2024-04-10 09:31
 **/
public class FactoryTest extends BaseTest{

    @Test
    public void getClientServiceByFactory() {
        Object clientService = applicationContext.getBean("clientService");
        System.out.println("clientService = " + clientService);
    }

    @Test
    public void getInstantClientServiceByFactory() {
        ClientService clientService = ((ClientService) applicationContext.getBean("iClientService", ClientService.class));
        System.out.println("clientService = " + clientService);

        // 通过 beanfactory.getType() 获取 bean 的类型
        ConfigurableListableBeanFactory autowireCapableBeanFactory = (ConfigurableListableBeanFactory) applicationContext.getAutowireCapableBeanFactory();

        Class<?> type = autowireCapableBeanFactory.getType("clientService");
        System.out.println("type = " + type);
    }
}
