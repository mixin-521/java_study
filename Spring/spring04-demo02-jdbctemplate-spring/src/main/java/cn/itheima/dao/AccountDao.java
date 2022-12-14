package cn.itheima.dao;

import cn.itheima.pojo.Account;

import java.util.List;

public interface AccountDao {

    void add(Account account);

    void update(Account account);

    void deleteById(Integer id);

    List<Account> findAll();

    Account findById(Integer id);

    Integer findCount();
}
