package com.itheima.dao;

import com.itheima.pojo.Account;

/**
 * 包名:com.itheima.dao
 * 作者:Leevi
 * 日期2019-11-09  10:52
 */
public interface AccountDao {
    /**
     * 根据aid查询账号信息，并且连接user表查询该账号所属的用户信息
     * @param aid
     * @return
     */
    Account findAccountByAid(int aid);
}
