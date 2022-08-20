package com.itheima.dao;

import com.itheima.pojo.Role;

/**
 * 包名:com.itheima.dao
 * 作者:Leevi
 * 日期2019-11-09  12:09
 */
public interface RoleDao {
    /**
     * 根据角色的rid查询角色信息，并且查询出该角色对应的所有用户信息
     * @param rid
     * @return
     */
    Role findRoleByRid(int rid);
}
