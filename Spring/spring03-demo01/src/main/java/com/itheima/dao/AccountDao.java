package com.itheima.dao;

/**
 * 连接点:可以被增强的方法
 * 切入点:可以被增强的方法中真正被增强的方法(比如save())
 * 通知/增强:用在切入点上面的业务逻辑(权限校验)
 * 切面: 就是切入点和通知的组合
 * */
public interface AccountDao {

    void save();

    void update();

    void delete();

    void findAll();

    void findById();
}
