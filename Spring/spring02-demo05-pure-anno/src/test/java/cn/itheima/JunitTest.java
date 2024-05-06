package cn.itheima;

import cn.itheima.bean.Account;
import cn.itheima.configs.PureAnnoConfig;
import cn.itheima.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 整合junit
 *
 * @RunWith(SpringJUnit4ClassRunner.class) 指定运行时环境, 固定写法
 * @ContextConfiguration 指定配置文件(locations)或者是配置类(classes)
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PureAnnoConfig.class})
public class JunitTest {
    @Autowired
    private AccountService accountService;

    @Test
    public void fun01() throws Exception {
        List<Account> list = accountService.findAll();
        System.out.println(list);
    }

}