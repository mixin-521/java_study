package cn.itheima.service.impl;

import cn.itheima.service.AccountService;

/**
 * p名称-注入简单类型
 */
public class AccountServiceImpl02 implements AccountService {

    private String username;

    private Integer age;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public void update() {
        System.out.println(username + ":::::" + age);
        //AccountDao accountDao = (AccountDao) BeanFactory02.getById("accountDao");
        //accountDao.update();
        System.out.println("AccountServiceImpl-->update()");
    }

    public void initMethod(){
        System.out.println("AccountServiceImpl-->initMethod()");
    }
}
