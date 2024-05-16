package com.ralph.bean.container;

import com.ralph.configuration.AnnotationAppConfig;
import com.ralph.domain.pojo.Hero;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName: JavaBeanContainerTest
 * @description:
 * @author: Neng.Tian
 * @create: 2024-04-19 10:18
 **/
public class JavaBeanContainerTest {

    private static ApplicationContext applicationContext;

    @Before
    public void beforeMethod() {
        applicationContext = new AnnotationConfigApplicationContext(AnnotationAppConfig.class);
    }


    @Test
    public void getSimpleString() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AnnotationAppConfig.class);
        String simpleString = context.getBean("simpleString", String.class);
        System.out.println("simpleString = " + simpleString);
    }

    @Test
    public void getHero() {
        Hero bean = applicationContext.getBean(Hero.class);
        System.out.println("bean = " + bean);
    }
}
