package com.itheima.dao;

import com.itheima.pojo.User;

/**
 * 包名:com.itheima.dao
 * 作者:Leevi
 * 日期2019-11-09  11:38
 */
public interface UserDao {
    /**
     * 根据用户的id查询用户的信息，并且连接account表查询这个用户的所有账号
     * @param id
     * @return
     */
    User findUserById(int id);
}
