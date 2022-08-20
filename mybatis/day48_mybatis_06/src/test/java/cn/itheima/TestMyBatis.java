package cn.itheima;

import cn.itheima.dao.AccountDao;
import cn.itheima.dao.UserDao;
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

/**
 * 包名:com.itheima
 * 作者:Leevi
 * 日期2019-11-11  08:54
 */
public class TestMyBatis {
    private SqlSession sqlSession;
    private InputStream is;
    private UserDao userDao;
    private AccountDao accountDao;
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
        accountDao = sqlSession.getMapper(AccountDao.class);
    }
    @After
    public void destroy() throws IOException {
        is.close();
        //sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testFindAccountByAid(){
        //目前已知的条件是:用户的id为63，所以查询到的结果集要封装在User对象中
        //1. 根据id查询用户信息
        User user = userDao.findUserById(60);

        //2. 根据uid查询账号的集合
        /*List<Account> accountListByUid = accountDao.findAccountListByUid(63);

        //3. 将账号集合设置到user中
        user.setAccountList(accountListByUid);*/

        //延迟加载的概念:按需加载，需要执行外部查询的时候才会去执行
        //表示我只需要用户的信息
        System.out.println(user.getUsername());
    }
}
