package com.itheima.service.impl;

import com.itheima.service.AccountService;

/**
 * 构造方法-注入简单类型
 */
public class AccountServiceImpl implements AccountService {

    private String username;

    private Integer age;

    public AccountServiceImpl() {
    }

    public AccountServiceImpl(String username, Integer age) {
        this.username = username;
        this.age = age;
    }

    @Override
    public void update() {
        System.out.println(username + ":::::" + age);
        //AccountDao accountDao = (AccountDao) BeanFactory02.getById("accountDao");
        //accountDao.update();
        System.out.println("AccountServiceImpl-->update()");
    }

    public void initMethod(){
        System.out.println("AccountServiceImpl-->initMethod()");
    }
}
