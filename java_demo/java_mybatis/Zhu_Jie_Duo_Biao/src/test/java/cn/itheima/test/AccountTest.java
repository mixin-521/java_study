package cn.itheima.test;

import cn.itheima.dao.IUserDao;
import cn.itheima.domain.User;
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

public class AccountTest {
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

    @After
    //用于在测试方法执行之后执行
    public void destroy() throws IOException {
        sqlSession.close();
        in.close();
    }
    @Test
    public void testfindAll(){
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println("----每个用户的信息----");
            System.out.println(user);
            System.out.println(user.getAccounts());
        }

    }
}
