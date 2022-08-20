package cn.itheima.test;

import cn.itheima.pojo.Account;
import cn.itheima.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicagtionContext.xml")
public class AnnoTxTest {
    @Autowired
    private AccountService accountService;

    @Test
    public void testAdd(){
        Account account = new Account();
        account.setMoney(1001.01);
        account.setName("zl1");
        accountService.add(account);
    }

}
