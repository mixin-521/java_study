package cn.itheima.test;

import cn.itheima.service.AccountService;
import cn.itheima.utils.BeanFactory02;

public class CustomIocest {

    public static void main(String[] args) {
        AccountService accountService = (AccountService) BeanFactory02.getById("accountService");
        accountService.update();
    }
}
