package cn.itheima.service.impl;

import cn.itheima.dao.AccountDao;
import cn.itheima.service.AccountService;
import cn.itheima.utils.BeanFactory02;

public class AccountServiceImpl implements AccountService {
    @Override
    public void update() {
        AccountDao accountDao = (AccountDao) BeanFactory02.getById("accountDao");
        accountDao.update();
        System.out.println("AccountServiceImpl-->update()");
    }
}
