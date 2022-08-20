package com.itheima.test;

import com.itheima.service.AccountService;
import com.itheima.service.impl.AccountServiceImpl;

public class InterfaceTest {

    public static void main(String[] args) {
        AccountService accountService = new AccountServiceImpl();
        accountService.update();
    }
}
