package com.itheima.dao.impl;

import com.itheima.dao.AccountDao;

public class AccountDaoImpl implements AccountDao {

    private String name;

    @Override
    public void update() {
        System.out.println("AccountDaoImpl-->update()");
    }

    public void initMethod(){
        System.out.println("AccountDaoImpl-->initMethod()");
    }

    public void destoryMethod(){
        System.out.println("AccountDaoImpl-->destoryMethod()");
    }
}
