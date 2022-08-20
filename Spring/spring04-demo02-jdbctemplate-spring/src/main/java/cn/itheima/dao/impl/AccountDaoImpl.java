package cn.itheima.dao.impl;

import cn.itheima.dao.AccountDao;
import cn.itheima.pojo.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

//@Repository
public class AccountDaoImpl implements AccountDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public void add(Account account) {
        jdbcTemplate.update("INSERT INTO t_account(name,money) VALUES(?,?)", account.getName(), account.getMoney());
    }

    @Override
    public void update(Account account) {
        jdbcTemplate.update("update t_account set name = ?,money = ? where id = ?", account.getName(), account.getMoney(), account.getId());
    }

    @Override
    public void deleteById(Integer id) {
        jdbcTemplate.update("DELETE FROM  t_account where id = ?", id);

    }

    @Override
    public List<Account> findAll() {
        return jdbcTemplate.query("SELECT * FROM t_account", new BeanPropertyRowMapper<>(Account.class));
    }

    @Override
    public Account findById(Integer id) {
        return jdbcTemplate.queryForObject("SELECT * FROM t_account WHERE id = " + id, new BeanPropertyRowMapper<>(Account.class));
    }

    @Override
    public Integer findCount() {
        return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM t_account", Integer.class);
    }
}
