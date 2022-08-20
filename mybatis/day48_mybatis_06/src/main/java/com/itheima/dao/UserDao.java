package com.itheima.dao;

import com.itheima.pojo.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

/**
 * 包名:com.itheima.dao
 * 作者:Leevi
 * 日期2019-11-11  08:51
 * 目标:根据用户的id查询出用户信息，并且调用AccountDao的方法，根据uid查询账号的集合
 * 最终所有数据都要封装在User对象中
 */
@CacheNamespace
public interface UserDao {
    /**
     * 根据id查询用户信息的方法
     * @param id
     * @return
     */
    @Results(id = "userAccountId",value = {
            //在使用注解进行自定义映射规则的时候，如果字段名和属性名能够对应上的，就可以不写,但是作为参数传递到外部查询方法中去的字段必须写
            @Result(column = "id",property = "id",id = true),
            //进行一对多查询映射
            @Result(column = "id",property = "accountList",many = @Many(fetchType = FetchType.LAZY,select = "com.itheima.dao.AccountDao.findAccountListByUid"))
    })
    @Select("select * from user where id=#{id}")
    User findUserById(int id);
}
