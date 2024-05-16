package com.ralph.bean;

import com.ralph.domain.constant.AppConstant;
import com.ralph.domain.dao.AccountDao;
import org.junit.Test;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.CollectionUtils;

/**
 * @ClassName: BeanDefinitionTest
 * @description:
 * @author: Neng.Tian
 * @create: 2024-04-09 23:50
 **/
public class BeanDefinitionTest {
    @Test
    public void getBeanDefinition() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(AppConstant.APP_PATH);
        ConfigurableListableBeanFactory listableBeanFactory = (ConfigurableListableBeanFactory) applicationContext.getAutowireCapableBeanFactory();

        // 目前测试得到的，只能通过 id 获取 BeanDefinition，name 和 alias 都不行
        BeanDefinition beanDefinition = listableBeanFactory.getBeanDefinition("accountDao");
        System.out.println("Bean Class Name: " + beanDefinition.getBeanClassName());
        System.out.println("Bean Scope: " + beanDefinition.getScope());
        MutablePropertyValues propertyValues = beanDefinition.getPropertyValues();
        for (PropertyValue propertyValue : propertyValues.getPropertyValueList()) {
            String[] strings = propertyValue.attributeNames();
            for (String string : strings) {
                System.out.println("string = " + string);
            }
        }
//        AccountDao accountDao = listableBeanFactory.getBean("dao3", AccountDao.class);
//        System.out.println("accountDao = " + accountDao);
    }
}
