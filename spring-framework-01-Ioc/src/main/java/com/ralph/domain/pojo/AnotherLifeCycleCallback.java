package com.ralph.domain.pojo;

/**
 * @ClassName: LifeCycleCallback
 * @description:
 * @author: Neng.Tian
 * @create: 2024-04-11 16:43
 **/
public class AnotherLifeCycleCallback {
    public void init() {
        System.out.println("AnotherLifeCycleCallback.init");
    }

    public void destroy() {
        System.out.println("AnotherLifeCycleCallback.destroy");
    }
}
