package com.ralph.bean.container;

import com.ralph.configuration.AnnotationAppConfig;
import com.ralph.configuration.ScopeConfig;
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
public class PureAnnotationConfigTest {

    @Test
    public void getHero() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(ScopeConfig.class);
        context.refresh();

        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println("beanDefinitionName = " + beanDefinitionName);
        }

        context.close();
    }
}
