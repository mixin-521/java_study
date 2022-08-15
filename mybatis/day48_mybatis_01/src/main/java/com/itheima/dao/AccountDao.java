package com.itheima.dao;

import com.itheima.pojo.Account;

/**
 * 包名:com.itheima.dao
 * 作者:Leevi
 * 日期2019-11-11  08:50
 */
public interface AccountDao {
    /**
     * 根据aid查询账号信息
     * @param aid
     * @return
     */
    Account findAccountByAid(int aid);
}
