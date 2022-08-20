package cn.itheima.utils;

import cn.itheima.service.impl.AccountServiceImpl02;

public class InstanceFactory {
    public Object getBean(){
        return new AccountServiceImpl02();
    }
}
