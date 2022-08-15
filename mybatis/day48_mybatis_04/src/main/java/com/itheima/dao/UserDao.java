package com.itheima.dao;

import com.itheima.pojo.User;
import com.itheima.pojo.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 包名:com.itheima.dao
 * 作者:Leevi
 * 日期2019-11-11  10:41
 * 使用注解开发mybatis
 *
 * 在映射配置文件中我们是怎么做的?
 */
public interface UserDao {

    @ResultMap("userInfoId")
    @Select("select * from user")
    List<UserInfo> findAll();

    @SelectKey(keyColumn = "id",keyProperty = "id",resultType = int.class,before = false,statement="select last_insert_id()")
    @Insert("insert into user values (null,#{username},#{birthday},#{sex},#{address})")
    int addUser(User user);

    @Delete("delete from user where id=#{id}")
    int deleteUser(int id);

    @Select("select * from user where id='${value}'")
    User findUserByid(int id);

    @Update("update user set username=#{username},sex=#{sex},address=#{address} where id=#{id}")
    int updateUser(User user);

    @Select("select * from user where username like '%${value}%'")
    List<User> searchUser(String username);

    /*
    * 编写自定义结果集的映射规则，使用Results注解
    * */
    @Results(id="userInfoId",value = {
        @Result(column = "id",property = "userId",id = true),
        @Result(column = "username",property = "userName"),
        @Result(column = "birthday",property = "userBirthday"),
        @Result(column = "sex",property = "userSex"),
        @Result(column = "address",property = "userAddress")
    })
    @Select("select * from user where id=#{id}")
    UserInfo findUserInfoById(int id);//根据id查询用户信息，并且封装在UserInfo对象中
}
