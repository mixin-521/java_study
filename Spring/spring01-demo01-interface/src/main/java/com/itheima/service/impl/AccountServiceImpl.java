package com.itheima.service.impl;

import com.itheima.dao.AccountDao;
import com.itheima.dao.impl.AccountDaoImpl;
import com.itheima.service.AccountService;

public class AccountServiceImpl implements AccountService {
    @Override
    public void update() {
        AccountDao accountDao = new AccountDaoImpl();
        accountDao.update();
        System.out.println("AccountServiceImpl-->update()");
    }
}
