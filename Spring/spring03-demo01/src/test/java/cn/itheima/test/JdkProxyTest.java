package cn.itheima.test;

import cn.itheima.dao.AccountDao;
import cn.itheima.dao.impl.AccountDaoImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 演示有接口的时候如何实现动态代理[必须有接口]
 */
public class JdkProxyTest {
    public static void main(String[] args) {
        AccountDao accountDao = new AccountDaoImpl();
        // 获取动态代理对象
        AccountDao proxyDao = (AccountDao) Proxy.newProxyInstance(accountDao.getClass().getClassLoader(), accountDao.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //对save方法开始校验
                if(method.getName().equals("save")){
                    System.out.println("JDK动态代理开始权限校验");
                    return method.invoke(accountDao,args);
                }
                return method.invoke(accountDao,args);
            }
        });
        //使用代理对象调用方法
        proxyDao.save();
    }
}
