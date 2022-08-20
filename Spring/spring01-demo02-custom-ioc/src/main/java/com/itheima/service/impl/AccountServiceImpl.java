package com.itheima.service.impl;

import com.itheima.dao.AccountDao;
import com.itheima.dao.impl.AccountDaoImpl;
import com.itheima.service.AccountService;
import com.itheima.utils.BeanFactory;
import com.itheima.utils.BeanFactory02;

public class AccountServiceImpl implements AccountService {
    @Override
    public void update() {
        AccountDao accountDao = (AccountDao) BeanFactory02.getById("accountDao");
        accountDao.update();
        System.out.println("AccountServiceImpl-->update()");
    }
}
