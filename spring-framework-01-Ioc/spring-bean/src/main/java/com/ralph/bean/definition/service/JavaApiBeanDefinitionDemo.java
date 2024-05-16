package com.ralph.bean.definition.service;

import com.ralph.ioc.container.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.util.StringUtils;

import java.util.Map;

/**
 * @ClassName: JavaApiBeanDefinitionDemo
 * @description: 使用 Java API 配置元信息
 * @author: Neng.Tian
 * @create: 2024-05-13 09:36
 **/
public class JavaApiBeanDefinitionDemo {

    public static void main(String[] args) {
        // 实现了 BeanDefinitionRegistry 接口
        GenericApplicationContext applicationContext = new GenericApplicationContext();

        // 命名注册
        registerBeanWithDefinition(applicationContext, "user-withalias");

        // 非命名注册
        registerBeanWithDefinition(applicationContext, null);

        applicationContext.refresh();

        Map<String, User> beanMaps = applicationContext.getBeansOfType(User.class);
        System.out.println("beanMaps = " + beanMaps);
    }

    /**
     * 使用 BeanDefinition 注册 bean
     * 1. 支持使用 BeanDefinitionRegistry 通过命名的方式注册；
     * 2. 支持使用 BeanDefinitionReaderUtils 进行注册；
     *
     * 注意：应该是由外部传入 BeanDefinition，这里硬编码是因为方便
     *
     * @param registry
     * @param clazz
     * @param beanName
     */
    public static void registerBeanWithDefinition(BeanDefinitionRegistry registry, String beanName) {
        BeanDefinitionBuilder definitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        definitionBuilder.addPropertyValue("id", 1L);
        definitionBuilder.addPropertyValue("name", "ralph with bean definition builder");
        AbstractBeanDefinition beanDefinition = definitionBuilder.getBeanDefinition();

        if (!StringUtils.isEmpty(beanName)) {
            registry.registerBeanDefinition(beanName, beanDefinition); // 1. 命名方式
        } else {
            BeanDefinitionReaderUtils.registerWithGeneratedName(beanDefinition, registry); // 2. 非命名方式
        }
    }
}
