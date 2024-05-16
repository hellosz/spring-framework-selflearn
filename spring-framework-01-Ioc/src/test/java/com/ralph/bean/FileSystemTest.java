package com.ralph.bean;

import com.ralph.domain.constant.AppConstant;
import com.ralph.domain.dao.AccountDao;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @ClassName: FileSystemTest
 * @description:
 * @author: Neng.Tian
 * @create: 2024-04-09 20:28
 **/
public class FileSystemTest {

    private ApplicationContext applicationContext;

    @Before
    public void init() {
        applicationContext = new FileSystemXmlApplicationContext(AppConstant.FILESYSTEM_PATH);
    }

    @Test
    public void getDao() {
        AccountDao accountDao = applicationContext.getBean(AccountDao.class);
        System.out.println("accountDao = " + accountDao);
        Assert.assertNotNull(accountDao);
    }

}
