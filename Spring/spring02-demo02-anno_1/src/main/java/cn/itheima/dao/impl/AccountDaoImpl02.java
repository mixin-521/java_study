package cn.itheima.dao.impl;

import cn.itheima.dao.AccountDao;
import org.springframework.stereotype.Repository;

@Repository("accountDao02")
public class AccountDaoImpl02 implements AccountDao {

    @Override
    public void save() {
        System.out.println("AccountDaoImpl02-->save( Dao层  )");
    }
}
