package cn.itheima.dao;

import cn.itheima.pojo.Account;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

/**
 * 包名:com.itheima.dao
 * 作者:Leevi
 * 日期2019-11-11  08:50
 */
public interface AccountDao {
    /**
     * 根据aid查询账号信息
     * 使用自定义映射规则
     * @param aid
     * @return
     */
    @Results(id="accountUserId",value = {
            @Result(column = "aid",property = "aid",id = true),
            @Result(column = "money",property = "money"),
            @Result(column = "uid",property = "uid"),
            /*进行一对一的查询映射，调用外部查询*/
            @Result(one = @One(select = "com.itheima.dao.UserDao.findUserById",fetchType = FetchType.LAZY),column = "uid",property = "user")
    })
    @Select("select * from account where aid=#{aid}")
    Account findAccountByAid(int aid);
}
