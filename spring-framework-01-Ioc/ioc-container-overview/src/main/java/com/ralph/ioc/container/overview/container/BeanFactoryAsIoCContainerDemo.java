package com.ralph.ioc.container.overview.container;

import com.ralph.ioc.container.overview.domain.User;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * {@link org.springframework.beans.factory.BeanFactory} 作为IoC 容器示例
 */
public class BeanFactoryAsIoCContainerDemo {

    public static void main(String[] args) {
        // 1. 通过 listableBeanFactory 读取配置文件，初始化为 IoC 容器
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);

        String classpath = "classpath:/META-INFO/dependency-lookup-context.xml";
        int numbers = reader.loadBeanDefinitions(classpath);
        System.out.println("DefaultListableBeanFactory 加载的 bean 数量： = " + numbers);

        // 2. 通过 lookup 查找自定义 bean
        lookupByType(beanFactory);
    }

    /**
     * 根据类型查找 bean
     *
     * @param beanFactory
     */
    private static void lookupByType(DefaultListableBeanFactory beanFactory) {
        User user = beanFactory.getBean(User.class);
        System.out.println("user = " + user);
    }
}
