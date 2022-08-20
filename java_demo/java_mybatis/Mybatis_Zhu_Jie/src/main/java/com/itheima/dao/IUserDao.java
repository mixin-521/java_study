package com.itheima.dao;
import com.itheima.domain.Role;
import com.itheima.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
/*再Mybatis中针对,CRUD一共有四种注解
@SELECT     @INSERT     @UPDATE     @DELETE
查询          插入      修改          删除
*/
public interface IUserDao {
    /*
    *   查询所有用户这个是查role表
    * */
    @Select(value = "select * from role")
    List<Role> findAllrole();
    /*查询所有数据这个是查询user表
    *
    * */
    @Select(value = "select * from user")
    List<User> findAlluser();
    /*
    * 插入数据到user表
    * */
    @Insert("insert into user(username,address,sex,birthday)values(#{username},#{address},#{sex},#{birthday})")
    void saveUser(User user);

    /*
     * 插入数据到role表
     * */
    @Insert("insert into role(rname,rdesc)values(#{rname},#{rdesc})")
    void saveRole(Role role);

    /*更改数据
    *                   这个自己没搞明白怎么回事
    * */
    @Update("update user set username=#{username},sex=#{sex},birthday=#{birthday},address=#{address} where id=#{id}")
    void updateUser(User user);

    /*
    * 删除操作 user表
    * */
    @Delete("delete from user where id=#{id} ")
    void deleteUser(Integer userId);

    /*
    *
    * 根据id查询用户
    * */
    @Select("select * from  user  where id=#{id} ")
    User findById(Integer userId);

    /*
    * 模糊查询
    * */
//    @Select("select * from user where username like #{username}")
    @Select("select * from user where username like  '%${value}%'  ")
    List<User> findUserByName(String username);

    /*
    * 查询总用户数量
    * */
    @Select("select count(*) from user")
    int findTotaalUser();


    @Select("select * from user")
    @Results(id = "userMap",value = {
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "name",property = "name"),
            @Result(column = "sex",property = "sex"),
    })

    List<User> findAll();





















}
