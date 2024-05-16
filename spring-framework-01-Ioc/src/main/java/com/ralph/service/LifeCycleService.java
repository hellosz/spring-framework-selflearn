package com.ralph.service;

/**
 * @ClassName: LifeCycleService
 * @description:
 * @author: Neng.Tian
 * @create: 2024-04-11 14:35
 **/
public class LifeCycleService {

    private String tag;

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public void initMethod() {
        System.out.println("LifeCycleService.initMethod");
    }

    public void destroyMethod() {
        System.out.println("LifeCycleService.destroyMethod");
    }
}
