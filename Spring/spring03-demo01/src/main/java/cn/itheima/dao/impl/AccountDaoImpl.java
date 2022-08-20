package cn.itheima.dao.impl;

import cn.itheima.dao.AccountDao;
import cn.itheima.dao.BaseDao;

/**
 * 通过继承父类的方式
 */
public class AccountDaoImpl extends BaseDao implements AccountDao {
    @Override
    public void save() {
        //调用父类的权限校验方法
       // super.checkRights();
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
