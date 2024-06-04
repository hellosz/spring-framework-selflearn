package com.ralph.bean.definition.service;

import com.ralph.bean.definition.serviceloader.CustomService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @ClassName: CustomServiceLoaderDemo
 * @description: 通过 serviceloaderfactorybean 和 listfactorybean 实现 spring 下的 spi 机制
 * @author: Neng.Tian
 * @create: 2024-05-22 09:32
 **/
public class CustomServiceLoaderDemo {

    List<CustomService> customServiceList;

    public List<CustomService> getCustomServiceList() {
        return customServiceList;
    }

    public void setCustomServiceList(List<CustomService> customServiceList) {
        this.customServiceList = customServiceList;
    }

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("META-INF/bean-instantiation-context.xml");
        CustomServiceLoaderDemo bean = context.getBean(CustomServiceLoaderDemo.class);
        List<CustomService> customServiceList1 = bean.getCustomServiceList();

        for (CustomService customService : customServiceList1) {
            customService.execute();
        }
    }
}
