package com.itheima.test;

import com.itheima.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnoTest {
    public static void main(String[] args) {
        //获取工厂
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取AccountService的实现类
        AccountService accountService = applicationContext.getBean("accountService", AccountService.class);
        //调用方法
        accountService.save();
        //销毁工厂
        //((ClassPathXmlApplicationContext)applicationContext).close();

// The IDE is ready for update. Restart?  Unmapped Spring configuration files found.  Please configure Spring facet or use 'Create default context' to add one including all unmapped files.
    }
}
