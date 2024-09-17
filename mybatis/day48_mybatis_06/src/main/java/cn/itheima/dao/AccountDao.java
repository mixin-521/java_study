package cn.itheima.dao;

import cn.itheima.pojo.Account;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 包名:com.itheima.dao
 * 作者:Leevi
 * 日期2019-11-11  08:50
 */
public interface AccountDao {
    /**
     * 根据uid查询多条账号信息
     * @param uid
     * @return
     */
    @Select("select * from account where uid=#{uid}")
    List<Account> findAccountListByUid(int uid);
}
