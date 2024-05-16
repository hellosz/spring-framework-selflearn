package com.ralph.domain.pojo;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.Lifecycle;
import org.springframework.context.SmartLifecycle;

/**
 * @ClassName: LifeCycleCallback
 * @description:
 * @author: Neng.Tian
 * @create: 2024-04-11 16:43
 **/
public class LifeCycleCallback {
    public void init() {
        System.out.println("LifeCycleCallback.init");
    }

    public void destroy() {
        System.out.println("LifeCycleCallback.destroy");
    }
}
