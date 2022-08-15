package com.itheima.dao;

import com.itheima.pojo.QueryVo;
import com.itheima.pojo.User;
import com.itheima.pojo.UserInfo;

import java.util.List;
import java.util.Map;

/**
 * 包名:com.itheima.dao
 * 作者:Leevi
 * 日期2019-11-08  09:54
 */
public interface UserDao {
    int addUser(User user);

    /**
     * 根据id删除用户信息
     * @param id
     * @return
     */
    int deleteUserById(int id);

    /**
     * 根据id查询用户信息
     * @param id
     * @return
     */
    User findUserById(int id);

    /*int updateUser(User user);*/
    int updateUser(Map<String,Object> map);

    /**
     * 根据用户名进行模糊查询
     * @param username
     * @return
     */
    List<User> findByUsername(String username);

    List<User> queryByVo(QueryVo vo);

    /**
     * 根据id查询用户名
     * @param id
     * @return
     */
    String findUsernameById(int id);

    /**
     * 根据id查询用户信息
     * @param id
     * @return
     */
    Map<String,Object> queryUser(int id);

    /**
     * 查询所有信息，封装到List<UserInfo>
     * @return
     */
    List<UserInfo> findAll();
}
