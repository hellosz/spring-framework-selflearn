package com.ralph.bean.definition.service;

import com.ralph.ioc.container.overview.domain.SuperUser;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * {@link org.springframework.beans.factory.config.BeanDefinition} Bean Definition 创建示例
 */
public class BeanDefinitionCreationDemo {
    public static void main(String[] args) {
        // 输出所有的 bean
        ApplicationContext context = getApplicationContext();
//        printBeans(context);

        // 通过别名获取 bean
//        getBeanByAlias(context);

        // 通过 BeanDefinitionBuilder 创建 bean
//        createBeanDefinitionByBuilder();

        // 通过 AbstractBeanDefinition 创建 bean
        createBeanDefinitionByGeneric();
    }

    /**
     * 根据 BeanDefinitionBuilder 创建 BeanDefinition
     */
    public static void createBeanDefinitionByBuilder() {
        // 初始化 bean
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(SuperUser.class);
        AbstractBeanDefinition beanDefinition = beanDefinitionBuilder.setScope("prototype")
                .addPropertyValue("id", 1L)
                .addPropertyValue("name", "ralph from definition")
                .addPropertyValue("address", "shenzhen baoan")
                .getBeanDefinition();

        // 注册 bean
        AnnotationConfigApplicationContext annotationContext = new AnnotationConfigApplicationContext();
        annotationContext.registerBeanDefinition("superUser", beanDefinition);
        annotationContext.refresh();

        // 获取 bean
        SuperUser user = annotationContext.getBean(SuperUser.class);
        System.out.println("user = " + user);
    }

    /**
     * 根据 GenericBeanDefinition 创建 BeanDefinition
     */
    public static void createBeanDefinitionByGeneric() {

        // 初始化 bean
        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        MutablePropertyValues propertyValues = new MutablePropertyValues().
                add("id", 2L)
                        .add("name", "ralph from genericBeanDefinition")
                                .add("address", "shenzhen baoan center");
        genericBeanDefinition.setPropertyValues(propertyValues);
        genericBeanDefinition.setBeanClass(SuperUser.class);
        genericBeanDefinition.setScope("singleton"); // 单例
//        genericBeanDefinition.setScope("prototype"); // 原型

        // 注册 bean
        AnnotationConfigApplicationContext annotationContext = new AnnotationConfigApplicationContext();
        annotationContext.registerBeanDefinition("superUser", genericBeanDefinition);
        annotationContext.refresh();

        // 获取 bean
        for (int i = 0; i < 10; i++) {
            SuperUser user = annotationContext.getBean(SuperUser.class);
            System.out.println("user = " + user + ", bean identity = " + System.identityHashCode(user));
        }
    }

    public static void getBeanByAlias(ApplicationContext context) {
        SuperUser user = context.getBean("superUserPlus", SuperUser.class);
        System.out.println("user = " + user);
    }

   public static void printBeans(ApplicationContext context) {
       String[] beanDefinitionNames = context.getBeanDefinitionNames();
       for (String beanDefinitionName : beanDefinitionNames) {
           System.out.println("beanDefinitionName = " + beanDefinitionName);
       }
   }

    /**
     * 获取应用上下文
     *
     * @return
     */
    public static ApplicationContext getApplicationContext() {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("classpath:/META-INF/bean-definitions-context.xml");

        return classPathXmlApplicationContext;
    }
}
