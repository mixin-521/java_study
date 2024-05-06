package cn.itheima.test;

import cn.itheima.dao.IUserDao;
import cn.itheima.domain.Role;
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

public class AnnotationCRUDTest {
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

    @After//用于在测试方法执行之后执行
    public void destroy() throws IOException {
        sqlSession.close();
        in.close();
    }

//    查询role表的所有数据
    @Test
    public void testFindAllrole() {
        List<Role> users = userDao.findAllrole();
        for (Role role : users) {
            System.out.println(role);
        }
    }
    /*查询user表
    *
    * */
    @Test
    public void testFindAlluser() {
        List<User> users = userDao.findAlluser();
        for (User user : users) {
            System.out.println(user);
        }
    }
    /*
    * 添加操作到user表
    * */
    @Test
    public void testSaveuser(){
        User user = new User();
        user.setUsername("迷心");
        user.setAddress("深圳");
        user.setId(90);
        user.setSex("男");
        userDao.saveUser(user);
    }
    @Test
    public void testSaverole(){
        Role role = new Role();
        role.setRname("学生2");
        role.setRdesc("捣乱2");
        userDao.saveRole(role);
    }
/*    @Test
    public void updateUser(){
        User user = new User();
        user.setId(82);
        user.setSex("女");
        user.setAddress("北京");
        user.setUsername("不知道叫什么好");
        user.setBirthday(new Double(83));
        userDao.updateUser(user);
    }*/


    /*
    * 删除操作 user表
    * */
    @Test
    public void testDelete(){
        userDao.deleteUser(84);
    }
    /*
    * 根据id查询数据user表
    * */
    @Test
    public void testFinOne(){
        User byId = userDao.findById(83);
        System.out.println(byId);
    }

/*    @Test
    public void testFindByName(){
//        List<User> userByName = userDao.findUserByName("%杰%");
        List<User> userByName = userDao.findUserByName("杰");
        for (User user : userByName) {
            System.out.println(user);
        }
    }*/
    /*
    *           查询有几条数据
    * */
    @Test
    public void testzonghangshu(){
        int totaalUser = userDao.findTotaalUser();
        System.out.println(totaalUser);
    }

}
