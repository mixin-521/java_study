package com.itheima.service.impl;

import com.itheima.service.AccountService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * 注解方式-注入简单类型(@Value)
 * @Value.value 可以不写,赋值
 */
@Component(value = "accountService02")
public class AccountServiceImpl02 implements AccountService {
    @Value("张三")
    private String username;
    @Value("18")
    private Integer age;

    @Override
    public void save() {
        System.out.println(username + "::::" + age);
        System.out.println("AccountServiceImpl02-->save()");
    }

}
