package com.itheima.dao.impl;

import com.itheima.dao.AccountDao;
import com.itheima.dao.BaseDao;
import com.itheima.utils.CheckUtils;

/**
 * 工具类的方式实现权限校验
 */
public class AccountDaoImpl02 implements AccountDao {
    @Override
    public void save() {
        CheckUtils.checkRights();
        System.out.println("AccountDaoImpl-->save()");
    }

    @Override
    public void update() {
        System.out.println("AccountDaoImpl-->update()");
    }

    @Override
    public void delete() {
        System.out.println("AccountDaoImpl-->delete()");
    }

    @Override
    public void findAll() {
        System.out.println("AccountDaoImpl-->findAll()");
    }

    @Override
    public void findById() {
        System.out.println("AccountDaoImpl-->findById()");
    }
}
