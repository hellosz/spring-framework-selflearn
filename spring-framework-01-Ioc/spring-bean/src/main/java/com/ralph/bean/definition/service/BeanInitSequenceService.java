package com.ralph.bean.definition.service;

import com.ralph.bean.definition.config.BeanInitializeConfig;
import com.ralph.bean.definition.domain.bean.InitSequenceBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName: BeanInitSequenceService
 * @description: bean 初始化顺序服务类
 * @author: Neng.Tian
 * @create: 2024-06-02 00:17
 **/
public class BeanInitSequenceService {

    public static void main(String[] args) {
        /**
         * output: @
         */
        System.out.println("context init");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanInitializeConfig.class);
        System.out.println("context inited");
        System.out.println("context get bean");
        InitSequenceBean bean = context.getBean(InitSequenceBean.class);
        System.out.println("context get beaned");

        System.out.println("context before close");
        context.close();
        System.out.println("context after close");
    }
}
