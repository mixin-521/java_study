package cn.itheima.test;


import cn.itheima.dao.AccountDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * classpath 定位到resources目录
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class AdviceTest {
    @Autowired
    private AccountDao accountDao;

    /**
     * 测试前置通知
     */
    @Test
    public void testBefore() {
        accountDao.save();
    }

    /**
     * 测试后置通知
     */
    @Test
    public void testAfterReturning() {
        accountDao.delete();
    }

    /**
     * 测试环绕通知
     */
    @Test
    public void testAround() {
        accountDao.findAll();
    }

    /**
     * 测试异常通知
     */
    @Test
    public void testAfterThrowing() {
        accountDao.update();
    }

    /**
     * 测试最终通知
     */
    @Test
    public void testAfter() {
        accountDao.findById();
    }
}
