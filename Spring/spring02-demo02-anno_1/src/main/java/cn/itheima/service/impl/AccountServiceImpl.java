package cn.itheima.service.impl;

import cn.itheima.service.AccountService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * 告诉IOC容器这是一个JavaBean,需要初始化
 * Component.value指定bean的ID,不指定的时候实例化出来的JavaBean的id是当前类的名称(首字母小写),value可以不写
 * @Scope 指定bean的作用范围(),value指定范围,可以不写,默认就是单例
 */

@Component("AccountService")
public class AccountServiceImpl implements AccountService {
@Scope
    @Override
    public void save() {
        System.out.println("AccountServiceImpl-->save()");
    }


    /**
     * 告诉IOC容器这是一个初始化方法
     */
    @PostConstruct //等同于xml里面配置init-method="init"
    public void init(){
        System.out.println("我是AccountServiceImpl的初始化方法");
    }

    /**
     * 告诉IOC容器这是一个销毁方法
     */
    @PreDestroy//xml里面 destroy-method="destroy"
    public void destroy(){
        System.out.println("我是AccountServiceImpl的销毁方法");
    }
}
