package com.itheima.dao;

import com.itheima.pojo.User;

/**
 * 包名:com.itheima.dao
 * 作者:Leevi
 * 日期2019-11-09  11:38
 */
public interface UserDao {
    /**
     * 根据用户的id查询用户的信息，并且连接user_role表、role表查询这个用户的所有角色
     * @param id
     * @return
     */
    User findUserById(int id);
    //HWNNP0FF2108T03X11
    //于6月2日至6月6日前往广东省深圳市深圳机场项目支撑、广西省河池市公安局参加大数据项目。申请人：陈振佳。电话：18595392651。邮箱：chenzhenjia051@chinasoftinc.com。
}
