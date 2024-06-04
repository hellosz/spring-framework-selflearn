package com.ralph.bean.definition.service;

import com.ralph.bean.definition.factory.CustomServiceFactory;
import com.ralph.bean.definition.serviceloader.CustomService;
import org.springframework.beans.factory.serviceloader.ServiceLoaderFactoryBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ServiceLoader;

/**
 * @ClassName: ServiceLoaderDemo
 * @description: 通过 java.util.ServiceLoader 动态发现和注册服务
 * @author: Neng.Tian
 * @create: 2024-05-16 10:04
 **/
@Service
public class ServiceLoaderDemo {

    private List<CustomService> customServiceList;

    public void setCustomServiceList(List<CustomService> customServiceList) {
        this.customServiceList = customServiceList;
    }

    public void executeService() {
        for (CustomService customService : this.customServiceList) {
            customService.execute();
        }
    }

    public static void main(String[] args) {
//        ServiceLoaderDemo serviceLoaderDemo = new ServiceLoaderDemo();
//        serviceLoaderDemo.springXmlSPIDemo();

//        springSPIDemo();

        // 通过 serviceLoaderFactoryBean 实现服务发现
        serviceLoaderFactoryBean();
    }


    /**
     * java 通过 spi 的方式实现服务发现
     */
    public static void javaSPIDemo() {
        // step3: 通过 ServiceLoader.load() 加载发现的实现类
        ServiceLoader<CustomService> load = ServiceLoader.load(CustomService.class);
        for (CustomService customService : load) {
            customService.execute();
        }
    }

    /**
     * spring 通过 spi 的方式实现服务发现
     */
    public static void springSPIDemo() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(CustomServiceFactory.class);
        context.register(ServiceLoaderDemo.class);
        context.refresh();

        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println("beanDefinitionName = " + beanDefinitionName);
        }
    }

    /**
     * spring 通过 spi 的方式实现服务发现
     */
    public void springXmlSPIDemo() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/META-INF/spi-lookup-context.xml");

        ServiceLoaderDemo serviceLoaderDemo = context.getBean(ServiceLoaderDemo.class);
        serviceLoaderDemo.executeService();
    }

    /**
     * 使用ServiceLoader Factory Bean从Spring上下文中获取并执行自定义服务。
     */
    public static void serviceLoaderFactoryBean() {
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
