package cn.itheima.dao;

import cn.itheima.pojo.User;

import java.util.List;

/**
 * 包名:com.itheima.dao
 * 作者:Leevi
 * 日期2019-11-08  09:01
 */
public interface UserDao {
    List<User> findAll();
}
