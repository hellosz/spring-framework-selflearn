package com.ralph.bean;

import com.ralph.domain.constant.AppConstant;
import com.ralph.domain.dao.AccountDao;
import com.ralph.domain.dao.OuterBeanDao;
import com.ralph.service.AccountServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName: AccountDaoTest
 * @description:
 * @author: Neng.Tian
 * @create: 2024-04-09 20:01
 **/
public class AccountDaoTest {

    private ApplicationContext applicationContext;

    @Before
    public void initContext() {
        applicationContext = new ClassPathXmlApplicationContext(AppConstant.APP_PATH);
        System.out.println("context inited");
    }



    @Test
    public void getDao() {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(AppConstant.APP_PATH);
        AccountDao accountDao = (AccountDao) classPathXmlApplicationContext.getBean("accountDao");
        System.out.println("accountDao = " + accountDao);
    }

    @Test
    public void getService() {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(AppConstant.APP_PATH);
        String[] beanDefinitionNames = classPathXmlApplicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println("beanDefinitionName = " + beanDefinitionName);
        }
//        AccountServiceImpl accountService = (AccountServiceImpl) classPathXmlApplicationContext.getBean("accountService");

//        AccountDao accountDao = accountService.getAccountDao();
//        System.out.println("accountDao = " + accountDao);
    }

    @Test
    public void getServiceWithType() {
        // 官方推荐的获取 bean 的方式
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(AppConstant.APP_PATH);
        AccountDao accountDao = applicationContext.getBean("accountDao", AccountDao.class);
        System.out.println("accountDao = " + accountDao);
    }

    @Test
    public void getNestedBean() {
        OuterBeanDao.InnerBeanDao innerDao = applicationContext.getBean("innerDao", OuterBeanDao.InnerBeanDao.class);

        System.out.println("innerDao = " + innerDao);
    }
}
