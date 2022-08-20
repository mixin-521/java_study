package com.itheima;

import com.itheima.bean.Account;
import com.itheima.configs.PureAnnoConfig;
import com.itheima.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * 混合开发特点
 *      别人的东西放到xml配置文件
 *      自己的东西用注解
 *      属性的注入用注解
 *      [别忘了开发包扫描]
 */
public class PureAnnoTest {

    @Test
    public void fun01() throws Exception {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(PureAnnoConfig.class);
        AccountService accountService = applicationContext.getBean("accountService", AccountService.class);
        List<Account> list = accountService.findAll();
        System.out.println(list);

    }

}
