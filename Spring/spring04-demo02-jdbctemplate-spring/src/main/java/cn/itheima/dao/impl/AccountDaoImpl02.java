package cn.itheima.dao.impl;

import cn.itheima.dao.AccountDao;
import cn.itheima.pojo.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

public class AccountDaoImpl02 extends JdbcDaoSupport implements AccountDao {

    @Override
    public void add(Account account) {
        super.getJdbcTemplate().update("INSERT INTO t_account(name,money) VALUES(?,?)", account.getName(), account.getMoney());
    }

    @Override
    public void update(Account account) {
         super.getJdbcTemplate().update("update t_account set name = ?,money = ? where id = ?", account.getName(), account.getMoney(), account.getId());
    }

    @Override
    public void deleteById(Integer id) {
         super.getJdbcTemplate().update("DELETE FROM  t_account where id = ?", id);

    }

    @Override
    public List<Account> findAll() {
        return  super.getJdbcTemplate().query("SELECT * FROM t_account", new BeanPropertyRowMapper<>(Account.class));
    }

    @Override
    public Account findById(Integer id) {
        return  super.getJdbcTemplate().queryForObject("SELECT * FROM t_account WHERE id = " + id, new BeanPropertyRowMapper<>(Account.class));
    }

    @Override
    public Integer findCount() {
        return  super.getJdbcTemplate().queryForObject("SELECT COUNT(*) FROM t_account", Integer.class);
    }
}
