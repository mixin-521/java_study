package cn.itheima.test;

import cn.itheima.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DITest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
       /* AccountService accountService = applicationContext.getBean("accountService", AccountService.class);
        accountService.update();*/

       /* AccountService accountService02 = applicationContext.getBean("accountService02", AccountService.class);
        accountService02.update();*/
        /*AccountService accountService03 = applicationContext.getBean("accountService03", AccountService.class);
        accountService03.update();*/

        /*AccountService accountService04 = applicationContext.getBean("accountService04", AccountService.class);
        accountService04.update(); */

        /*AccountService accountService05 = applicationContext.getBean("accountService05", AccountService.class);
        accountService05.update();*/

       /* AccountService accountService06 = applicationContext.getBean("accountService06", AccountService.class);
        accountService06.update();*/
      AccountService accountService07 = applicationContext.getBean("accountService07", AccountService.class);
        accountService07.update();
    }
}
