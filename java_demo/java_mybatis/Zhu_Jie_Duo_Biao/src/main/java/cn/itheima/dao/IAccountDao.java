package cn.itheima.dao;

import cn.itheima.domain.Account;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface IAccountDao {

    @Select("select * from account")
    //配置映射
    @Results(id="accountMap",value = {
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "uid",property = "uid"),
            @Result(column = "money",property = "money"),
            @Result(property = "user",column = "uid",one = @One(select = "com.itheima.dao.IUserDao.findById",fetchType = FetchType.EAGER))
    })
    List<Account> findAll();
    /*根据id查询账户信息
     * */
    @Select("select * from account where uid =#{userId}")
    List<Account> findAccountByUid(Integer userId);
}
