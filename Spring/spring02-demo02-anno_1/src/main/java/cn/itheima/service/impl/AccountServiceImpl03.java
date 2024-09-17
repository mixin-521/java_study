package cn.itheima.service.impl;

import cn.itheima.dao.AccountDao;
import cn.itheima.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


/**
 * 注解方式-注入JavaBean(@Autowired)
 * 只是用@Autowired
 *  一: 优先按照名称加类型查找对应的Bean,如果找到就使用;
 *  二: 如果找不到,按照属性对应的类型去查找,如果找到就使用(bean的id对应的实现类只有一个),找不到就报错
 *
 */
@Component("AccountServiceImpl03")
public class AccountServiceImpl03 implements AccountService {

    @Autowired
    @Qualifier("accountDao02")//如果这里不加就会报错,因为找到的是两个所有会报错,需要指定一个
    private AccountDao accountDao;

    @Override
    public void save() {
        accountDao.save();
        System.out.println("AccountServiceImpl03-->>save()");
    }
}
