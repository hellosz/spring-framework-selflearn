package com.ralph.bean;

import com.ralph.domain.constant.AppConstant;
import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName: BaseTest
 * @description:
 * @author: Neng.Tian
 * @create: 2024-04-10 09:32
 **/
public class BaseTest {
    protected ApplicationContext applicationContext;

    @Before
    public void initContext() {
        applicationContext = new ClassPathXmlApplicationContext(AppConstant.APP_PATH);
        System.out.println("context inited");
    }
}
