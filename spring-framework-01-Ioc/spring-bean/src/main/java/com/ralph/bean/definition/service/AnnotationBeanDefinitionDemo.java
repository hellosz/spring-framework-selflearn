package com.ralph.bean.definition.service;

import com.ralph.ioc.container.overview.domain.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

/**
 * @ClassName: AnnotationBeanDefinitionDemo
 * @description: 通过注解的方式创建 Bean
 * @author: Neng.Tian
 * @create: 2024-05-13 09:11
 **/
@Import(AnnotationBeanDefinitionDemo.Config.class)
//@ComponentScan("com.ralph.bean.definition.service")
public class AnnotationBeanDefinitionDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
//        context.register(Config.class); // 1. 直接注册 Bean 对象
        context.register(AnnotationBeanDefinitionDemo.class); // 2. 通过 @Import 注册 Bean 对象
        context.refresh();

        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println("beanDefinitionName = " + beanDefinitionName);
        }

        context.close();;
    }

    @Component
    public static class Config {
        @Bean
        public User user() {
            User user = new User();
            user.setId(2L);
            user.setName("ralph from inner @bean");

            return user;
        }

    }


}
