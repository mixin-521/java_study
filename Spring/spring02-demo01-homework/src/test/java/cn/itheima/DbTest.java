package cn.itheima;

import cn.itheima.bean.Account;
import cn.itheima.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;


public class DbTest {
    @Test
    public void fun01() throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountService accountService = applicationContext.getBean("accountService", AccountService.class);
        List<Account> list = accountService.findAll();
        System.out.println(list);

        Account account = new Account();
        account.setId(5);
        account.setName("chenzhenjia");
        account.setMoney(5000.d);
        accountService.save(account);
    }
}
