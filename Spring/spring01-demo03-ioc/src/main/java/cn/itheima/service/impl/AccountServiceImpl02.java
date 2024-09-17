package cn.itheima.service.impl;

import cn.itheima.service.AccountService;

public class AccountServiceImpl02 implements AccountService {
    @Override
    public void update() {
        //AccountDao accountDao = (AccountDao) BeanFactory02.getById("accountDao");
        //accountDao.update();
        System.out.println("AccountServiceImpl-->update()");
    }

    public void initMethod(){
        System.out.println("AccountServiceImpl-->initMethod()");
    }
}
