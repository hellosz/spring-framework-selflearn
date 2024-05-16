package com.ralph.domain.pojo;

/**
 * @ClassName: ScopedBean
 * @description:
 * @author: Neng.Tian
 * @create: 2024-04-20 22:24
 **/
public class ScopedBean {

    public void init() {
        System.out.println("ScopedBean.init");
    }

    public void close() {
        System.out.println("ScopedBean.close");
    }
}
