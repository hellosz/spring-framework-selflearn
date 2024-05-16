package com.ralph.bean;

import com.ralph.domain.dao.AccountDao;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName: HeroBeanTest
 * @description:
 * @author: Neng.Tian
 * @create: 2024-04-09 17:31
 **/
public class HeroBeanTest {

    @Test
    public void attach() {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("classpath:/config/applications.xml");
//        Hero hero = classPathXmlApplicationContext.getBean("hero", Hero.class);
        AccountDao accountDao = classPathXmlApplicationContext.getBean("accountDao", AccountDao.class);
        System.out.println("accountDao = " + accountDao.hashCode());

        AccountDao accountDao1 = classPathXmlApplicationContext.getBean("dao1", AccountDao.class);
        System.out.println("accountDao1 = " + accountDao1.hashCode());

        AccountDao accountDao3 = classPathXmlApplicationContext.getBean("dao3", AccountDao.class);
        System.out.println("accountDao3 = " + accountDao3.hashCode());
    }
}
