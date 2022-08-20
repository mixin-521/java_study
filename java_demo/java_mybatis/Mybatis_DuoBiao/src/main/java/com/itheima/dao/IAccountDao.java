package com.itheima.dao;

import com.itheima.domain.Account;
import com.itheima.domain.AccountUser;

import java.util.List;

public interface IAccountDao {
//    查询所有用户
    List<Account> findAll();
//    查询所有账户,同时还要获取到当前账户的所有信息
    List<AccountUser> findAllAccount();
}
