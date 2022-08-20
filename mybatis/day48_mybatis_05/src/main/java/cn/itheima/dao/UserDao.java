package cn.itheima.dao;

import cn.itheima.pojo.User;
import org.apache.ibatis.annotations.Select;

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
    @Select("select * from user where id=#{id}")
    User findUserById(int id);
}
