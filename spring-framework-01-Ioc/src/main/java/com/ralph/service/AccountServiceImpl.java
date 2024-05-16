package com.ralph.service;

import com.ralph.domain.dao.AccountDao;

/**
 * @ClassName: AccountServiceImpl
 * @description:
 * @author: Neng.Tian
 * @create: 2024-04-09 19:59
 **/
public class AccountServiceImpl {
    private AccountDao accountDao;

    public AccountDao getAccountDao() {
        return accountDao;
    }

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }
}
