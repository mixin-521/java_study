package cn.itheima.service.impl;

import cn.itheima.service.AccountService;

/**
 * setter方法-注入数组
 */
public class AccountServiceImpl03 implements AccountService {

    private String[] hobbys;

    public void setHobbys(String[] hobbys) {
        this.hobbys = hobbys;
    }

    @Override
    public void update() {
        for (String hobby : hobbys) {
            System.out.println(hobby);
        }
        //AccountDao accountDao = (AccountDao) BeanFactory02.getById("accountDao");
        //accountDao.update();
        System.out.println("AccountServiceImpl-->update()");
    }

    public void initMethod(){
        System.out.println("AccountServiceImpl-->initMethod()");
    }
}
