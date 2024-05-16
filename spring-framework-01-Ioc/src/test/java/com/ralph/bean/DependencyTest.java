package com.ralph.bean;

import org.junit.Test;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * @ClassName: DependencyTest
 * @description:
 * @author: Neng.Tian
 * @create: 2024-04-10 22:12
 **/
public class DependencyTest extends BaseTest{

    @Test
    public void getMapping() {
        PropertySourcesPlaceholderConfigurer mappings = applicationContext.getBean("mappings", PropertySourcesPlaceholderConfigurer.class);
    }
}
