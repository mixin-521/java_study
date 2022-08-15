package com.itheima.service.impl;

import com.itheima.service.AccountService;

import java.util.Map;
import java.util.Set;

/**
 * setter方法-注入map
 */
public class AccountServiceImpl04 implements AccountService {

    private Map<String, String> map;

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    @Override
    public void update() {
        Set<String> sets = map.keySet();
        for (String key : sets) {
            System.out.println(key + "::::" + map.get(key));
        }
        //AccountDao accountDao = (AccountDao) BeanFactory02.getById("accountDao");
        //accountDao.update();
        System.out.println("AccountServiceImpl-->update()");
    }

    public void initMethod() {
        System.out.println("AccountServiceImpl-->initMethod()");
    }
}
