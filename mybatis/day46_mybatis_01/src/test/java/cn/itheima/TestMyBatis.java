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
        List<User> userList = userDao.findAll();
        System.out.println(userList);
        //7. 关闭资源
        is.close();
        sqlSession.close();
    }
}
