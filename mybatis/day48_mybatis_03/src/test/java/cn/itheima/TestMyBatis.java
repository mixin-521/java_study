package cn.itheima;

import cn.itheima.dao.UserDao;
import cn.itheima.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * 包名:com.itheima
 * 作者:Leevi
 * 日期2019-11-08  09:40
 */
public class TestMyBatis {
    @Test
    public void testFindAll() throws IOException {
        //mybatis的测试代码
        //1. 将主配置文件转换成字节输入流
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2. 创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder factoryBuilder = new SqlSessionFactoryBuilder();
        //3. 使用SqlSessionFactoryBuilder对象调用build()方法，加载流，创建SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = factoryBuilder.build(is);
        //4. 调用sqlSessionFactory对象的openSession()方法，获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //5. 使用sqlSession对象的getMapper()方法，获取Dao接口的代理对象
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        //6. 调用代理对象的findAll()方法查询用户信息
        List<User> userList1 = userDao.findAll();
        System.out.println(userList1);

        //以及缓存是存在于sqlSession对象中的，那么一级缓存会在什么时候清除呢?
        //1. sqlSession调用commit()方法  2. sqlSession调用clearCache()方法  3. sqlSession调用close()方法  4.当前表执行增删改的SQL语句

        userDao.addUser(new User(null,"迷心老师",new Date(),"女","东京"));

        List<User> userList2 = sqlSession.getMapper(UserDao.class).findAll();
        System.out.println(userList2);

        //7. 关闭资源
        is.close();
        sqlSession.close();
    }

    @Test
    public void testCacheSecond() throws IOException {
        //1. 将主配置文件转换成字节输入流
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2. 创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder factoryBuilder = new SqlSessionFactoryBuilder();
        //3. 使用SqlSessionFactoryBuilder对象调用build()方法，加载流，创建SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = factoryBuilder.build(is);

        //获取多个sqlSession对象
        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        UserDao userDao1 = sqlSession1.getMapper(UserDao.class);
        List<User> userList1 = userDao1.findAll();
        System.out.println(userList1);
        //配置二级缓存的步骤:1. 在主配置文件中添加setting标签   2. 在对应的映射配置文件中添加cache标签   3. 给要进行二级缓存的POJO类实现Serializable接口
        //什么时候会清除二级缓存呢? 当前表执行增删改的SQL语句
        userDao1.addUser(new User(null,"小泽老师",new Date(),"女","东京"));

        sqlSession1.close();


        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        UserDao userDao2 = sqlSession2.getMapper(UserDao.class);
        List<User> userList2 = userDao2.findAll();
        System.out.println(userList2);
        sqlSession2.close();

        SqlSession sqlSession3 = sqlSessionFactory.openSession();
        UserDao userDao3 = sqlSession3.getMapper(UserDao.class);
        List<User> userList3 = userDao3.findAll();
        System.out.println(userList3);
        sqlSession3.close();
    }
}
