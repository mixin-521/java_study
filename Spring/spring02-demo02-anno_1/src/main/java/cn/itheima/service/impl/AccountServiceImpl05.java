package cn.itheima.service.impl;

import cn.itheima.dao.AccountDao;
import cn.itheima.service.AccountService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


/**
 * 注解方式-注入JavaBean(@Resource)
 * @Resource(name="accountDao") === @Autowired  @Qualifier("accountDao")
 */
@Component("AccountServiceImpl05")
public class AccountServiceImpl05 implements AccountService {
    @Resource(name = "accountDao")
    private AccountDao accountDao;

    @Override
    public void save() {
        accountDao.save();
        System.out.println("AccountServiceImpl05-->>save()");
    }
}
