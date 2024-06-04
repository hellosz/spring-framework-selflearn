package com.ralph.bean.definition.domain.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @ClassName: InitSequenceBean
 * @description: 初始化顺序测试 Bean
 * @author: Neng.Tian
 * @create: 2024-06-01 23:39
 **/
public class InitSequenceBean implements InitializingBean, DisposableBean {
    /**
     * Invoked by the containing {@code BeanFactory} after it has set all bean properties
     * and satisfied {@link BeanFactoryAware}, {@code ApplicationContextAware} etc.
     * <p>This method allows the bean instance to perform validation of its overall
     * configuration and final initialization when all bean properties have been set.
     *
     * @throws Exception in the event of misconfiguration (such as failure to set an
     *                   essential property) or if initialization fails for any other reason
     */

    @PostConstruct
    public void postConstruct() {
        System.out.println("InitSequenceBean.postConstruct");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("InitSequenceBean.preDestroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitSequenceBean.afterPropertiesSet");
    }

    /**
     * 其他初始化方法
     */
    public void initMethod() {
        System.out.println("InitSequenceBean.initMethod");
    }

    /**
     * 其他销毁方法
     */
    public void destroyMethod() {
        System.out.println("InitSequenceBean.destroyMethod");
    }

    /**
     * Invoked by the containing {@code BeanFactory} on destruction of a bean.
     *
     * @throws Exception in case of shutdown errors. Exceptions will get logged
     *                   but not rethrown to allow other beans to release their resources as well.
     */
    @Override
    public void destroy() throws Exception {
        System.out.println("InitSequenceBean.DisposableBean");
    }
}
