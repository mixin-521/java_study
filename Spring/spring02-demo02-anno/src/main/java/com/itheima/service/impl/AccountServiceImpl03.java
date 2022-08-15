package com.itheima.service.impl;

import com.itheima.dao.AccountDao;
import com.itheima.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 注解方式-注入JavaBean(@Autowired)
 * 只是用@Autowired
 *  一: 优先按照名称加类型查找对应的Bean,如果找到就使用;
 *  二: 如果找不到,按照属性对应的类型去查找,如果找到就使用(bean的id对应的实现类只有一个),找不到就报错
 *
 */
@Component(value = "accountService03")
public class AccountServiceImpl03 implements AccountService {
    @Autowired
    private AccountDao accountDao03;

    @Override
    public void save() {
        accountDao03.save();
        System.out.println("AccountServiceImpl03-->save()");
    }

}
