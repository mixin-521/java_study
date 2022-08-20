package cn.itheima.service.impl;

import cn.itheima.dao.AccountDao;
import cn.itheima.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;


public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Override
    public void save() {
        accountDao.save();
        System.out.println("AccountServiceImpl-->save()");
    }

}
