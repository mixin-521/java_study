package com.itheima.test;

import com.itheima.dao.AccountDao;
import com.itheima.service.AccountService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class IocTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        /*AccountService accountService = applicationContext.getBean("accountService", AccountService.class);
        accountService.update();*/
      /*  AccountDao accountDao = applicationContext.getBean("accountDao",AccountDao.class);
        accountDao.update();*/
        //AccountDao accountDao = applicationContext.getBean("accountDao",AccountDao.class);
        //accountDao.update();
        //(new ClassPathXmlApplicationContext(applicationContext)).close();
       // BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
        //AccountService accountService = beanFactory.getBean("accountService", AccountService.class);
        //accountService.update();
        AccountService accountService02 = applicationContext.getBean("accountService02", AccountService.class);
        accountService02.update();
    }
}
