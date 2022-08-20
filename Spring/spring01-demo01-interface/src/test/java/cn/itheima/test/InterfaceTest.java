package cn.itheima.test;

import cn.itheima.service.AccountService;
import cn.itheima.service.impl.AccountServiceImpl;

public class InterfaceTest {

    public static void main(String[] args) {
        AccountService accountService = new AccountServiceImpl();
        accountService.update();
    }
}
