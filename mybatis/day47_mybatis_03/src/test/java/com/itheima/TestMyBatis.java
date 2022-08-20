package com.itheima;

import com.itheima.dao.RoleDao;
import com.itheima.dao.UserDao;
import com.itheima.pojo.Role;
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
    private UserDao userDao;
    private RoleDao roleDao;

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
        userDao = sqlSession.getMapper(UserDao.class);
        roleDao = sqlSession.getMapper(RoleDao.class);
    }

    @After
    public void destroy() throws IOException {
        is.close();
        //sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testFindUserById(){
        User user = userDao.findUserById(63);

        System.out.println(user);
    }

    @Test
    public void testFindRoleByRid(){
        Role role = roleDao.findRoleByRid(1);
        System.out.println(role);
    }
}
