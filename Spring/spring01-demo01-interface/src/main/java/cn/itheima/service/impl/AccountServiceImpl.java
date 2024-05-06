package cn.itheima.service.impl;

import cn.itheima.dao.AccountDao;
import cn.itheima.dao.impl.AccountDaoImpl;
import cn.itheima.service.AccountService;

public class AccountServiceImpl implements AccountService {
    @Override
    public void update() {
        AccountDao accountDao = new AccountDaoImpl();
        accountDao.update();
        System.out.println("AccountServiceImpl-->update()");
    }
}
