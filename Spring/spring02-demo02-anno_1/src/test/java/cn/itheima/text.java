package cn.itheima;

import cn.itheima.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class text {
    public static void main(String[] args) {
        //获取工厂
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取AccountService的实现类
        AccountService accountService = applicationContext.getBean("AccountServiceImpl05", AccountService.class);
        //调用方法
        accountService.save();
        //销毁工厂
//        ((ClassPathXmlApplicationContext)applicationContext).close();

//        Others
    }
}
