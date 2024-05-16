package com.ralph.ioc.container.overview.dependency;

import com.ralph.ioc.container.overview.annotations.CustomPrimary;
import com.ralph.ioc.container.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.awt.*;
import java.util.Map;

/**
 * IoC：依赖查找信息
 * 1. 通过名称查找
 */
public class DependencyLookupDemo {
    public static void main(String[] args) {
        String path = "META-INFO/dependency-lookup-context.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(path);

        // 根据名称查找
//        lookupByName(context);

        // 根据类型查找
//        lookupByType(context);

        // 根据注解查找
        lookupByAnnotation(context);
    }

    /**
     * 根据类型查找
     *
     * @param beanFactory
     */
    private static void lookupByAnnotation(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, Object> beansWithAnnotation = listableBeanFactory.getBeansWithAnnotation(CustomPrimary.class);

            System.out.println("beansWithAnnotation = " + beansWithAnnotation);
        }
    }

    /**
     * 根据类型查找
     *
     * @param beanFactory
     */
    private static void lookupByType(BeanFactory beanFactory) {
        System.out.println("look up by name");

        lookupByTypeSingle(beanFactory);

        lookupByTypeCollection(beanFactory);
    }

    private static void lookupByTypeCollection(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            String[] namesForType = listableBeanFactory.getBeanNamesForType(User.class);

            for (String typeName : namesForType) {
                System.out.println("lookupByTypeCollection = " + typeName);
            }
        }

    }

    private static void lookupByTypeSingle(BeanFactory beanFactory) {
        User user = beanFactory.getBean(User.class);
        System.out.println("lookupByTypeSingle = " + user);
    }

    public static void lookupByName(BeanFactory beanFactory) {
        System.out.println("look up by name");
        // 根据名称实时查找
        lookupByNameReal(beanFactory);

        // 根据名称延迟查找
        lookupByNameLazy(beanFactory);
    }

    /**
     * 根据名称实时查找
     * @param beanFactory
     */
    public static void lookupByNameReal(BeanFactory beanFactory) {
        User user = beanFactory.getBean("user", User.class);

        System.out.println("lookupByNameReal user = " + user);
    }

    /**
     * 根据名称延迟查找
     * @param beanFactory
     */
    public static void lookupByNameLazy(BeanFactory beanFactory) {
        ObjectFactory<User> objectFactory = (ObjectFactory<User>) beanFactory.getBean("objectFactory");
        User object = objectFactory.getObject();

        System.out.println("lookupByNameLazy = " + object);
    }
}
