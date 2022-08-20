package cn.itheima.service.impl;

import cn.itheima.dao.AccountDao;
import cn.itheima.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


/**
 * 注解方式-注入JavaBean(@Autowired)
 * @Autowired和@Qualifier一起使用
 *  要注入的属性名可以和IOC容器中的bean的ID都不一样,但是需要在@Qualifier("xxx"),xxx指定要使用的bean的ID
 *
 */
@Component("AccountServiceImpl04")
public class AccountServiceImpl04 implements AccountService {

    @Autowired
    @Qualifier("accountDao02")//如果这里不加就会报错,因为找到的是两个所有会报错,需要指定一个
    private AccountDao accountDao;

    @Override
    public void save() {
        accountDao.save();
        System.out.println("AccountServiceImpl04-->>save()");
    }
}
