package com.itheima.test;

import com.itheima.dao.IUserDao;
import com.itheima.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * 包名:com.itheima
 * 作者:Leevi
 * 日期2019-11-09  10:55
 */
public class UserTest {
    private InputStream in;
    private SqlSession sqlSession;
    private IUserDao userDao;

    @Before//用于在测试方法执行之前执行
    public void init() throws IOException {
        //1.读取配置文件
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.获取SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //3.获取sqlSession
        sqlSession = factory.openSession(true);
        //4.获取dao的代理对象
        userDao = sqlSession.getMapper(IUserDao.class);
    }

        @After//用于在测试方法执行之后执行
    public void destroy() throws IOException {
        sqlSession.close();
        in.close();
    }
    @Test
    public void testFindAll() {
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println("-----------");
            System.out.println(user);
        }
    }

/*    //    查询所有账户,同时还要获取到当前账户的所有信息
    @Test
    public void findAllAccount() {
        List<AccountUser> aus = accountDao.findAllAccount();
        for (AccountUser account : aus) {
            System.out.println(account);
        }
    }*/
}

