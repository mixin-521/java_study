package cn.itheima;

import cn.itheima.dao.UserDao;
import cn.itheima.pojo.QueryVo;
import cn.itheima.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 包名:com.itheima
 * 作者:Leevi
 * 日期2019-11-09  09:50
 */
public class  TestMyBatis {
    private SqlSession sqlSession;
    private UserDao userDao;
    private InputStream is;

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
    }

    @After
    public void destroy() throws IOException {
        is.close();
        //sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testSearchUser(){
        //调用userDao的代理对象的方法
        QueryVo queryVo = new QueryVo();
        User user = new User();
        user.setUsername("周");
        //user.setAddress("中国");
        queryVo.setUser(user);
        List<User> userList = userDao.searchUser(queryVo);

        System.out.println(userList);
    }

    @Test
    public void testQueryByIds(){
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(59);
        ids.add(81);
        //ids.add(60);
        //ids.add(63);
        List<User> userList = userDao.queryByIds(ids);
        System.out.println(userList);
    }
}
