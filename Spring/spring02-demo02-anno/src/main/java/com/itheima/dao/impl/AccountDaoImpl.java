package com.itheima.dao.impl;

import com.itheima.dao.AccountDao;
import org.springframework.stereotype.Repository;

@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {
    @Override
    public void save() {
        System.out.println("AccountDaoImpl-->save()");
    }
}
