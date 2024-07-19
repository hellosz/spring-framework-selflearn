package com.ralph.dependency.lookup.service;

import com.ralph.dependency.lookup.service.domains.AbstractUser;
import com.ralph.ioc.container.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

/**
 * @ClassName: TypeSafeDependencyLookupDemo
 * @description: 类型安全的依赖查找
 * @author: Neng.Tian
 * @create: 2024-07-18 10:00
 **/
public class TypeSafeDependencyLookupDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TypeSafeDependencyLookupDemo.class);
//        // 1. beanfaotory.getBean 方法的安全性
//        displayBeanFactoryGetBean(context);
//        // 2. FactoryBean 的安全性
//        displayFactoryBeanGetBean(context);
//        // 3. ObjectProvider 的安全性
//        displayObjectProvider(context);
//        // 4. ListableBeanFactory 的安全性

        // 5. 触发 BeansException
        displayBeansException(context);

        context.close();
    }

    private static void displayBeansException(AnnotationConfigApplicationContext context) {
        displayException("displayBeansException", () -> {
            AbstractUser bean = context.getBean(AbstractUser.class);
            System.out.println("bean = " + bean);
        } );
    }
//
//    @Bean
//    public String welcome() {
//        return "welcome";
//    }
//
//    @Primary
//    @Bean
//    public String welcomeToo() {
//        return "welcomeToo";
//    }

//    @Bean
//    public User getUser() {
//        User user = new User();
//        user.setName("ralph");
//
//        return user;
//    }

    public static void displayBeanFactoryGetBean(BeanFactory beanFactory) {
        displayException("displayBeanFactoryGetBean", () -> {
            User user = beanFactory.getBean(User.class);

            System.out.println("user = " + user);
        });
    }

    public static void displayFactoryBeanGetBean(ApplicationContext applicationContext) {
        ObjectFactory<User> beanProvider = applicationContext.getBeanProvider(User.class);

        displayException("displayFactoryBeanGetBean", () -> {
            User object = beanProvider.getObject();
            System.out.println("object = " + object);
        });
    }

    public static void displayObjectProvider(ApplicationContext applicationContext) {
        ObjectProvider<User> beanProvider = applicationContext.getBeanProvider(User.class);

        displayException("displayObjectProvider", () -> {
            User object = beanProvider.getIfAvailable();
            System.out.println("object = " + object);
        });
    }

    public static void displayException(String desc, Runnable runnable) {
        System.err.println("current call: " + desc);
        try {
            runnable.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
