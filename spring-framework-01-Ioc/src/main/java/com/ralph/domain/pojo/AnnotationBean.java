package com.ralph.domain.pojo;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @ClassName: AnnotationBean
 * @description:
 * @author: Neng.Tian
 * @create: 2024-04-17 09:15
 **/
@Component
public class AnnotationBean implements BeanNameAware {
    @Override
    public void setBeanName(String s) {
        System.out.println(" bean name = " + s);
    }
}
