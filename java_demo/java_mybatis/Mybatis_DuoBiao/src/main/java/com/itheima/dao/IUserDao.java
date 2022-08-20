package com.itheima.dao;

import com.itheima.domain.User;

import java.util.List;

public interface IUserDao {
//    查询所有用户,同时获取到用户下的所有账户的信息
    List<User> findAll();
//    根据id查询用户信息
    User findById(Integer userId);
}
