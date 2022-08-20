package com.itheima.service.impl;

import com.itheima.dao.AccountDao;
import com.itheima.pojo.Account;
import com.itheima.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;

    @Override
    public void add(Account account) {
        accountDao.add(account);
        int i = 1 / 0;
    }

    @Override
    public void update(Account account) {

    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public List<Account> findAll() {
        return null;
    }

    @Override
    public Account findById(Integer id) {
        return null;
    }

    @Override
    public Integer findCount() {
        return null;
    }
}
