package com.ralph.bean.annotations;

import com.ralph.bean.BaseTest;
import com.ralph.domain.pojo.AnnotationBean;
import com.ralph.domain.pojo.ConfigurationBean;
import org.junit.Test;

/**
 * @ClassName: AnnotationTest
 * @description:
 * @author: Neng.Tian
 * @create: 2024-04-17 09:16
 **/
public class AnnotationTest extends BaseTest {

    @Test
    public void getBean() {
        AnnotationBean annotationBean = applicationContext.getBean("annotationBean", AnnotationBean.class);
        System.out.println("annotationBean = " + annotationBean);
    }

    @Test
    public void getBeanConfiguration() {
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println("beanDefinitionName = " + beanDefinitionName);
        }
    }

    @Test
    public void getBeanService() {
        ConfigurationBean bean = applicationContext.getBean(ConfigurationBean.class);
        String name = bean.getName();
        System.out.println("name = " + name);
    }

    @Test
    public void getBeanWithMultiIdentifier() {
        ConfigurationBean annotationBean = applicationContext.getBean("configurationBean", ConfigurationBean.class);
        System.out.println("annotationBean = " + annotationBean);
    }
}
