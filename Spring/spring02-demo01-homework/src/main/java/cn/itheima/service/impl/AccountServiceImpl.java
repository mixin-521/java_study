package cn.itheima.service.impl;

import cn.itheima.bean.Account;
import cn.itheima.dao.AccountDao;
import cn.itheima.service.AccountService;

import java.util.List;

public class AccountServiceImpl implements AccountService {

    
    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public void save(Account account) throws Exception {
        
        accountDao.save(account);

    }

    @Override
    public void update(Account account) throws Exception {
        
        accountDao.update(account);

    }

    @Override
    public void delete(Integer id) throws Exception {
        
        accountDao.delete(id);
    }

    @Override
    public Account findById(Integer id) throws Exception {
        
        return  accountDao.findById(id);
    }

    @Override
    public List<Account> findAll() throws Exception {
        
        return  accountDao.findAll();
    }
}
