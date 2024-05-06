package cn.itheima.service.impl;

import cn.itheima.dao.AccountDao;
import cn.itheima.service.AccountService;

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
