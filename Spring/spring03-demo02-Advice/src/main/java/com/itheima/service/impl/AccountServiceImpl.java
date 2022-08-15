package com.itheima.service.impl;

import com.itheima.dao.AccountDao;
import com.itheima.service.AccountService;

public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public void save() {
        System.out.println("AccountServiceImpl-->save()");
    }

    @Override
    public void update() {
        System.out.println("AccountServiceImpl-->update()");
    }

    @Override
    public void delete() {
        System.out.println("AccountServiceImpl-->delete()");
    }

    @Override
    public void findAll() {
        System.out.println("AccountServiceImpl-->findAll()");
    }

    @Override
    public void findById() {
        System.out.println("AccountServiceImpl-->findById()");
    }
}
