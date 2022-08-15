package com.itheima.test;


import java.io.IOException;

public class MybatisAnnoTest {
/*//    测试基于注解的mybatis使用
    public static void main(String[] args) throws IOException {
       *//* //1.获取字节输入流
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.根据字节输入流构建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //3.根据SqlSessionFactory生产一个SqlSession
        SqlSession session = factory.openSession();
        //4.使用SqlSession获取Dao的代理对象
        IUserDao userDao = session.getMapper(IUserDao.class);
        //5.执行Dao方法
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
        //6.释放资源
        session.close();
        in.close();*//*
    }*/
}
