package com.itheima.test;

import com.itheima.service.AccountService;
import com.itheima.service.impl.AccountServiceImpl;
import com.itheima.utils.BeanFactory;
import com.itheima.utils.BeanFactory02;

public class CustomIocest {

    public static void main(String[] args) {
        AccountService accountService = (AccountService) BeanFactory02.getById("accountService");
        accountService.update();
    }
}
