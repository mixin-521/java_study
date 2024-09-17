package cn.itheima.dao.impl;

import cn.itheima.dao.AccountDao;

/**
 *
 */
public class AccountDaoImpl implements AccountDao {
    @Override
    public void save() {
        System.out.println("AccountDaoImpl-->save()");
    }

    @Override
    public void update() {
        System.out.println("AccountDaoImpl-->update()");
        int i = 1 / 0;
    }

    @Override
    public String delete() {
        System.out.println("AccountDaoImpl-->delete()");
        int i = 1 / 0;
        return "deleteOK";
    }

    @Override
    public void findAll() {
        System.out.println("AccountDaoImpl-->findAll()");
        //int i = 1 / 0;
    }

    @Override
    public void findById() {
        System.out.println("AccountDaoImpl-->findById()");
        int i = 1 / 0;
    }
}
