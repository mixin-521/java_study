package com.itheima.service.impl;

import com.itheima.dao.AccountDao;
import com.itheima.service.AccountService;

import java.util.Map;
import java.util.Set;

/**
 * setter方法-注入JavaBean
 */
public class AccountServiceImpl05 implements AccountService {

    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public void update() {

        //AccountDao accountDao = (AccountDao) BeanFactory02.getById("accountDao");
        accountDao.update();
        System.out.println("AccountServiceImpl-->update()");
    }

    public void initMethod() {
        System.out.println("AccountServiceImpl-->initMethod()");
    }
}
