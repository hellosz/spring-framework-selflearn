package com.ralph.dependency.lookup.service;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

/**
 * @ClassName: TypeSafeDependencyLookupDemo
 * @description:  通过 ObjectProvider 超找 Bean
 * @author: Neng.Tian
 * @create: 2024-07-18 10:00
 **/
public class ObjectProviderDependencyLookupDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ObjectProviderDependencyLookupDemo.class);
        getStringByObjectProvider(context);

        context.close();
    }

    @Bean
    public String welcome() {
        return "welcome";
    }

    @Primary
    @Bean
    public String welcomeToo() {
        return "welcomeToo";
    }

    public static void getStringByObjectProvider(ApplicationContext context) {
        ObjectProvider<String> beanProvider = context.getBeanProvider(String.class);
        // 获取单个对象
        String object = beanProvider.getObject();
        System.out.println("object = " + object);

        // 获取列表
        System.out.println("object list iterable =");
        beanProvider.iterator().forEachRemaining(System.out::println);
    }

}
