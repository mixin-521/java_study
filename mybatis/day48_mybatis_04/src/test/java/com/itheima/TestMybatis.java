package com.itheima;

import com.itheima.dao.UserDao;
import com.itheima.pojo.User;
import com.itheima.pojo.UserInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * 包名:com.itheima
 * 作者:Leevi
 * 日期2019-11-11  10:47
 */
public class TestMybatis {
    private SqlSession sqlSession;
    private InputStream is;
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
        sqlSession = sqlSessionFactory.openSession();
        //5. 使用sqlSession对象的getMapper()方法，获取Dao接口的代理对象
        userDao = sqlSession.getMapper(UserDao.class);
    }

    @After
    public void destroy() throws IOException {
        is.close();
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testFindAll(){
        List<UserInfo> userList = userDao.findAll();
        System.out.println(userList);
    }

    @Test
    public void testAddUser(){
        User user = new User(null,"小泽老师",new Date(),"女","东京");
        userDao.addUser(user);

        Integer id = user.getId();
        System.out.println(id);
    }

    @Test
    public void testUpdate(){
        User user = userDao.findUserByid(91);

        user.setAddress("东莞");

        userDao.updateUser(user);
    }

    @Test
    public void testSearchUser(){
        List<User> userList = userDao.searchUser("周");

        System.out.println(userList);
    }

    @Test
    public void testFindUserInfoById(){
        UserInfo userInfo = userDao.findUserInfoById(91);

        System.out.println(userInfo);
    }
}
