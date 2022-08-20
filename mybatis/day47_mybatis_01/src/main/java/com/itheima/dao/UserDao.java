package com.itheima.dao;

import com.itheima.pojo.QueryVo;
import com.itheima.pojo.User;

import java.util.List;

/**
 * 包名:com.itheima.dao
 * 作者:Leevi
 * 日期2019-11-09  09:44
 */
public interface UserDao {
    /**
     * 搜索用户
     * @param vo
     * @return
     */
    List<User> searchUser(QueryVo vo);

    /**
     * 根据多个id查询多个用户信息
     * @param ids
     * @return
     */
    List<User> queryByIds(List<Integer> ids);
}
