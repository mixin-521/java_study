package com.itheima.dao.impl;

import com.itheima.dao.AccountDao;
import com.itheima.pojo.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccountDaoImpl implements AccountDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public void add(Account account) {
        jdbcTemplate.update("INSERT INTO account(name,money) VALUES(?,?)", account.getName(), account.getMoney());
    }

    @Override
    public void update(Account account) {
        jdbcTemplate.update("update account set name = ?,money = ? where id = ?", account.getName(), account.getMoney(), account.getId());
    }

    @Override
    public void deleteById(Integer id) {
        jdbcTemplate.update("DELETE FROM  account where id = ?", id);

    }

    @Override
    public List<Account> findAll() {
        return jdbcTemplate.query("SELECT * FROM account", new BeanPropertyRowMapper<>(Account.class));
    }

    @Override
    public Account findById(Integer id) {
        return jdbcTemplate.queryForObject("SELECT * FROM account WHERE id = " + id, new BeanPropertyRowMapper<>(Account.class));
    }

    @Override
    public Integer findCount() {
        return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM t_account", Integer.class);
    }
}
