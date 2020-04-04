package com.itheima.test;

import com.itheima.dao.IUserDao;
import com.itheima.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * @author Rosalyn
 * @create 2020-04-03 20:19
 */
public class AnnoCRUDTest {
    private InputStream in;
    private SqlSessionFactory factory;
    private SqlSession session;
    private IUserDao userDao;

    @Before
    public void init() throws Exception{
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(in);
        session = factory.openSession();
        userDao = session.getMapper(IUserDao.class);
    }

    @After
    public void destory() throws Exception{
        session.commit();
        session.close();
        in.close();
    }
    @Test
    public void testSave(){
        User user = new User();
        user.setUsername("mybatis annotation");
        user.setAddress("北京市昌平区");
        userDao.saveUser(user);
    }

    @Test
    public void testUpdate(){
        User user = new User();
        user.setId(49);
        user.setSex("男");
        user.setUsername("mybatis annotation");
        user.setAddress("北京市海淀区");
        user.setBirthday(new Date());

        userDao.updateUser(user);
    }

    @Test
    public void testDelete(){
        userDao.deleteUser(50);
    }

    @Test
    public void testFindOne(){
        User user = userDao.findById(49);
        System.out.println(user);

    }
    @Test
    public void testFindByName(){
        List<User> users = userDao.findByName("%王%");
        for (User user : users){
            System.out.println(user);
        }
    }

    @Test
    public void testFindTotal(){
        int num = userDao.findTotal();
        System.out.println(num);
    }

}
