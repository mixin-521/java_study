package cn.itheima.service;

import cn.itheima.pojo.Account;

import java.util.List;

public interface AccountService {

    void add(Account account);

    void update(Account account);

    void deleteById(Integer id);

    List<Account> findAll();

    Account findById(Integer id);

    Integer findCount();
}
