package com.ralph.ioc.container.overview.container;

import com.ralph.ioc.container.overview.domain.SuperUser;
import com.ralph.ioc.container.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * {@link org.springframework.context.annotation.AnnotationConfigApplicationContext} 作为IoC 容器示例
 */
public class AnnotationApplicationContextAsIoCContainerDemo {

    /**
     * bean_id: getSuperUser
     * bean_type: User
     *
     * @return
     */
    @Bean
    public User getSuperUser() {
        SuperUser user = new SuperUser();
        user.setId(2L);
        user.setName("ralph");
        user.setAddress("shenzhen");

        return user;
    }

    public static void main(String[] args) {
        // 1. 通过 AnnotationConfigApplication 作为配置类 ，初始化为 IoC 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(AnnotationApplicationContextAsIoCContainerDemo.class); // 手动加载当前类为工厂创建方法
        applicationContext.refresh();

        // 2. 通过 lookup 查找自定义 bean
        lookupByType(applicationContext);
        
        // 3. 通过 lookup 查找指定 id 的 bean
        lookupById(applicationContext);

        // 关闭容器
        applicationContext.close();
    }

    /**
     * 根据 ID 查找 bean
     *
     * @param beanFactory
     */
    private static void lookupById(BeanFactory beanFactory) {
        User user = beanFactory.getBean("getSuperUser", User.class);
        System.out.println("user = " + user);
    }

    /**
     * 根据类型查找 bean
     *
     * @param beanFactory
     */
    private static void lookupByType(BeanFactory beanFactory) {
        User user = beanFactory.getBean(User.class);
        System.out.println("user = " + user);
    }
}
