package com.itheima.dao;

import com.itheima.pojo.User;

/**
 * 包名:com.itheima.dao
 * 作者:Leevi
 * 日期2019-11-11  08:51
 */
public interface UserDao {
    /**
     * 根据id查询用户信息的方法
     * @param id
     * @return
     */
    User findUserById(int id);
}
