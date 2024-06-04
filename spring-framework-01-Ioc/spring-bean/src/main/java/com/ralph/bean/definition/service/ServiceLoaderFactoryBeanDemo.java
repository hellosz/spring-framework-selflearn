package com.ralph.bean.definition.service;

import com.ralph.bean.definition.serviceloader.CustomService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.ServiceLoader;

/**
 * @ClassName: ServiceLoaderFactoryBeanDemo
 * @description: 通过 ServiceLoaderFactoryBean 和 ListFactoryBean 将 ServiceLoader 动态服务发现类进行初始化
 * @author: Neng.Tian
 * @create: 2024-05-22 09:45
 **/
public class ServiceLoaderFactoryBeanDemo {

    List<CustomService> customServiceList;

    public void setCustomServiceList(List<CustomService> customServiceList) {
        this.customServiceList = customServiceList;
    }

    public static void main(String[] args) {
        // 初始化Spring上下文，从classpath下的指定配置文件加载bean定义
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/META-INF/bean-instantiation-context.xml");

        // 从上下文中获取名为“serviceLoaderFactory”的Bean，其类型为ServiceLoader
        ServiceLoader loaderFactory = context.getBean("serviceLoaderFactory", ServiceLoader.class);
        // 遍历ServiceLoader中所有的CustomService实例，并执行它们的方法
        for (Object o : loaderFactory) {
            CustomService customService = (CustomService) o;
            customService.execute();
        }

    }
}
