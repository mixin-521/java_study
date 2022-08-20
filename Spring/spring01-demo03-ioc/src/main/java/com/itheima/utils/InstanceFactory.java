package com.itheima.utils;

import com.itheima.service.impl.AccountServiceImpl02;

public class InstanceFactory {
    public Object getBean(){
        return new AccountServiceImpl02();
    }
}
