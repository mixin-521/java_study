package cn.itheima.service.impl;

import cn.itheima.service.AccountService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("AccountServiceImpl02")
public class AccountServiceImpl02 implements AccountService {
@Value("李四")
    private String username;
@Value("18")
    private Integer age;

    @Override
    public void save() {
        System.out.println(username + "::::::::" + age);
        System.out.println("AccountServiceImpl02-->>save()");
    }
}
