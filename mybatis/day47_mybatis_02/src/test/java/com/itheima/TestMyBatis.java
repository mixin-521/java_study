package com.itheima;

import com.itheima.dao.AccountDao;
import com.itheima.dao.UserDao;
import com.itheima.pojo.Account;
import com.itheima.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * 包名:com.itheima
 * 作者:Leevi
 * 日期2019-11-09  10:55
 */
public class TestMyBatis {
    private SqlSession sqlSession;
    private InputStream is;
    private AccountDao accountDao;
    private UserDao userDao;

    @Before
    public void init() throws IOException {
        //1. 将主配置文件转换成字节输入流
        is = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2. 创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder factoryBuilder = new SqlSessionFactoryBuilder();
        //3. 使用SqlSessionFactoryBuilder对象调用build()方法，加载流，创建SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = factoryBuilder.build(is);
        //4. 调用sqlSessionFactory对象的openSession()方法，获取SqlSession对象
        sqlSession = sqlSessionFactory.openSession(true);
        //5. 使用sqlSession对象的getMapper()方法，获取Dao接口的代理对象
        accountDao = sqlSession.getMapper(AccountDao.class);
        userDao = sqlSession.getMapper(UserDao.class);
    }

    @After
    public void destroy() throws IOException {
        is.close();
        //sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testFindAccountByAid(){
        //调用AccountDao对象的方法，根据aid查询用户信息
        Account account = accountDao.findAccountByAid(1);

        System.out.println(account);
    }

    @Test
    public void testFindUserById(){
        User user = userDao.findUserById(63);

        System.out.println(user);
    }
}
