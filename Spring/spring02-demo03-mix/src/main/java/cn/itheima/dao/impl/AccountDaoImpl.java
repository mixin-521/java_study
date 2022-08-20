package cn.itheima.dao.impl;

import cn.itheima.dao.AccountDao;

public class AccountDaoImpl implements AccountDao {
    @Override
    public void save() {
        System.out.println("AccountDaoImpl-->save()");
    }
}
