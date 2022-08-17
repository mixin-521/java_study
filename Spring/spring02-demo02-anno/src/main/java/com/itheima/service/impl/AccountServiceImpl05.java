package com.itheima.service.impl;

import com.itheima.dao.AccountDao;
import com.itheima.service.AccountService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 注解方式-注入JavaBean(@Resource)
 * @Resource(name="accountDao") === @Autowired  @Qualifier("accountDao")
 */
@Component(value = "accountService05")
public class AccountServiceImpl05 implements AccountService {

    @Resource(name = "accountDao02")
    private AccountDao accountDao03;

    @Override
    public void save() {
        accountDao03.save();
        System.out.println("AccountServiceImpl05-->save()");
    }

}
