package cn.itheima;

import cn.itheima.dao.UserDao;
import cn.itheima.pojo.QueryVo;
import cn.itheima.pojo.User;
import cn.itheima.pojo.UserInfo;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 包名:com.itheima
 * 作者:Leevi
 * 日期2019-11-08  10:08
 */
public class TestMyBatis {
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
    public void testAddUser(){
        User user = new User(null, "小白", new Date(), "男", "中国");
        userDao.addUser(user);

        //用户添加完成之后，这条数据就有一个自增长的id，我们要在代码中拿到这个自增长的id
        System.out.println(user.getId());
    }

    @Test
    public void testDelete(){
        userDao.deleteUserById(83);
    }

    @Test
    public void testUpdate(){
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("id",5);
        map.put("name","小三");
        map.put("sex","男");
        map.put("address","上海");
        //修改用户信息
        userDao.updateUser(map);
    }

    @Test
    public void findByUsername(){
        List<User> userList = userDao.findByUsername("周");

        System.out.println(userList);
    }

    @Test
    public void testFindByVo(){
        User user = new User();
        user.setUsername("周");

        QueryVo queryVo = new QueryVo();
        queryVo.setUser(user);

        List<User> userList = userDao.queryByVo(queryVo);

        System.out.println(userList);
    }

    @Test
    public void testFindUsernameById(){
        String username = userDao.findUsernameById(59);
        System.out.println(username);
    }

    @Test
    public void testQueryUser(){
        Map<String, Object> map = userDao.queryUser(59);

        System.out.println(map);
    }

    @Test
    public void testFindAll(){
        List<UserInfo> userInfoList = userDao.findAll();
        System.out.println(userInfoList);
    }
}
