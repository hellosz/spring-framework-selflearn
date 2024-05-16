package com.ralph.ioc.container.overview.dependency;

import com.ralph.ioc.container.overview.domain.User;
import com.ralph.ioc.container.overview.repository.UserRepositoryById;
import com.ralph.ioc.container.overview.repository.UserRepositoryByType;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * IoC：依赖查找信息
 * 1. 通过名称查找
 */
public class DependencyInjectDemo {
    public static void main(String[] args) {
        String path = "META-INFO/dependency-inject-context.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(path);

//        lookupByTypeCollection(context);
        lookupInnerGeneratedBeanFactory(context);
    }

    /**
     * 注入内建的 BeanFactory
     *
     * @param beanFactory
     */
    private static void lookupInnerGeneratedBeanFactory(BeanFactory beanFactory) {
        // 1. 自定义 Bean
        UserRepositoryByType repositoryByType = beanFactory.getBean(UserRepositoryByType.class);

        // 3. 容器内建依赖
        BeanFactory anotherBeanFactory = repositoryByType.getBeanFactory();
        System.out.println("anotherBeanFactory = " + anotherBeanFactory);
        System.out.println("inner beanfactory equals inject beanfactory:" + (beanFactory == anotherBeanFactory));

        // 2. 容器内建 Bean 对象
        ObjectFactory<ApplicationContext> objectFactory = repositoryByType.getObjectFactory();
        ApplicationContext applicationContext = objectFactory.getObject();
        System.out.println("inner beanfactory equals objectfactory:" + (beanFactory == applicationContext));
    }

    /**
     * 根据 ID 查找集合
     * @param beanFactory
     */
    public static void lookupByIdCollection(BeanFactory beanFactory) {
        UserRepositoryById userRepository = beanFactory.getBean(UserRepositoryById.class);
        List<User> users = userRepository.getUsers();
        System.out.println("users = " + users);
    }

    /**
     * 根据类型查找集合
     * @param beanFactory
     */
    public static void lookupByTypeCollection(BeanFactory beanFactory) {
        UserRepositoryByType repositoryByType = beanFactory.getBean(UserRepositoryByType.class);
        List<User> users = repositoryByType.getUsers();
        System.out.println("users = " + users);
    }
}
