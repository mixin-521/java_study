package com.itheima.test;

import com.itheima.dao.AccountDao;
import com.itheima.pojo.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicagtionContext.xml")
public class JdbcTemplateTest {
    /*@Autowired
    private AccountDao accountDao;
    @Autowired
    private AccountDao accountDao02;*/

    @Autowired
    private AccountDao accountDao;

    @Test
    public void testFindAll(){
        List<Account> accounts = accountDao.findAll();
        System.out.println(accounts);
    }

}
