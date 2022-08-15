package com.itheima.test;

import com.itheima.pojo.Account;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;

public class BasicJdbcTemplateTest {

    @Test
    public void findAll() {
        // 创建数据源,设置四个基本项-DriverManagerDataSource
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://47.105.158.112:10007/studytest?characterEncoding=utf8");
        dataSource.setUsername("root");
        dataSource.setPassword("zd521707");
        //创建Jdbc模板,配置数据源-JdbcTemplate
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        //        + 操作数据库
        List<Account> accounts = jdbcTemplate.query("SELECT * FROM account", new BeanPropertyRowMapper<>(Account.class));
        System.out.println(accounts);
    }

    @Test
    public void findById() {
        // 创建数据源,设置四个基本项-DriverManagerDataSource
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://47.105.158.112:10007/studytest?characterEncoding=utf8");
        dataSource.setUsername("root");
        dataSource.setPassword("zd521707");
        //创建Jdbc模板,配置数据源-JdbcTemplate
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        //        + 操作数据库
        Account account = jdbcTemplate.queryForObject("SELECT * FROM account WHERE id = " + 1, new BeanPropertyRowMapper<>(Account.class));
        System.out.println(account);
    }

    @Test
    public void insert() {
        // 创建数据源,设置四个基本项-DriverManagerDataSource
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://47.105.158.112:10007/studytest?characterEncoding=utf8");
        dataSource.setUsername("root");
        dataSource.setPassword("zd521707");
        //创建Jdbc模板,配置数据源-JdbcTemplate
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        //        + 操作数据库
        jdbcTemplate.update("INSERT INTO account (name,money) VALUES(?,?)", "zl", 1001);
    }

    @Test
    public void update() {
        // 创建数据源,设置四个基本项-DriverManagerDataSource
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://47.105.158.112:10007/studytest?characterEncoding=utf8");
        dataSource.setUsername("root");
        dataSource.setPassword("zd521707");
        //创建Jdbc模板,配置数据源-JdbcTemplate
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        //        + 操作数据库
        jdbcTemplate.update("update t_account set name = ?,money = ? where id = ?", "zl1", 2001, 4);
    }

    @Test
    public void delete() {
        // 创建数据源,设置四个基本项-DriverManagerDataSource
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://47.105.158.112:10007/studytest?characterEncoding=utf8");
        dataSource.setUsername("root");
        dataSource.setPassword("zd521707");
        //创建Jdbc模板,配置数据源-JdbcTemplate
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        //        + 操作数据库
        jdbcTemplate.update("DELETE FROM  t_account where id = ?", 4);
    }

    @Test
    public void findCount() {
        // 创建数据源,设置四个基本项-DriverManagerDataSource
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://47.105.158.112:10007/studytest?characterEncoding=utf8");
        dataSource.setUsername("itcast");
        dataSource.setPassword("zd521707");
        //创建Jdbc模板,配置数据源-JdbcTemplate
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        //        + 操作数据库
        Integer integer = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM t_account", Integer.class);
        System.out.println(integer);
    }
}
