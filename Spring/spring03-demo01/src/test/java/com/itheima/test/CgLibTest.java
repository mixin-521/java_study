package com.itheima.test;

import com.itheima.dao.UserDao;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 对于无接口的类进行动态代理
 */
public class CgLibTest {

    public static void main(String[] args) {
        UserDao userDao = new UserDao();

        Enhancer enhancer = new Enhancer();
        //设置父类
        enhancer.setSuperclass(userDao.getClass());
        //设置权限校验方法
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                if (method.getName().equals("save")) {
                    System.out.println("CgLib开始权限校验");
                    return method.invoke(userDao, args);
                }
                return method.invoke(userDao, args);
            }
        });
        //获取动态代理对象
        UserDao proxyDao = (UserDao) enhancer.create();
        //使用代理对象调用方法
        proxyDao.save();

    }
}
