package com.itheima.test;
import com.itheima.Dao.IUserDao;
import com.itheima.domian.Users;
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
public class Userstest {
    private InputStream in;
    private SqlSession session;
    private IUserDao userDao;
    @Before
    public void Init()throws Exception{
        //1.读取配置文件
        in = Resources.getResourceAsStream("SqlMapConfig");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        //3.使用工厂生产SqlSession对象
        session = factory.openSession(true);
        //4.使用SqlSession创建Dao的代理对象
        userDao = session.getMapper(IUserDao.class);
    }
    @After
    public void destroy()throws Exception{
        //6.释放资源
        session.close();
        in.close();
    }
    /*入门案例*/
    @Test
    public void testFindAll() throws Exception {
        //5.使用代理对象执行方法
        List<Users> users = userDao.findAll();
        for (Users user : users){
            System.out.println("----------每个用户信息及对应总数据----------");
            System.out.println(user);
            System.out.println(user.getData());
            System.out.println();
        }
    }

    //测试查询一个操作
    @Test
    public void testFindById()throws Exception{
        //5.使用代理对象执行方法
        Users user = userDao.findById(1);
        System.out.println(user);
    }

    //测试保存操作
    @Test
    public void testSave(){
        Users user = new Users();
        user.setUser_Name("aghsh");
        user.setUser_Password("1235");
        System.out.println("保存操作之前："+user);
        //5.使用代理对象执行方法
        userDao.saveUser(user);
        System.out.println("保存操作之后："+user);

    }


    //测试更新操作
    @Test
    public void testUpdateUser(){
        Users user = new Users();
        user.setUser_ID(2);
        user.setUser_Name("小二王");
        user.setUser_Password("2326");
        user.setUser_Sex("女");
        //5.使用代理对象执行方法
        userDao.updateUser(user);
    }
    //测试删除操作
    @Test
    public void testDelete(){

        //5.使用代理对象执行方法
        userDao.deleteUser(2);
    }

    //测试模糊查询
    @Test
    public void testFindByName(){

        //5.使用代理对象执行方法
        List<Users> users=userDao.findByName("%黄%");
        for(Users user : users) {
            System.out.println(user);
        }
    }

    @Test
    //根据ID查询用户信息及所有数据
    public void findByID_AllData(){
        Users users=userDao.findByID_AllData(1);
        System.out.println(users);
        System.out.println(users.getData());

    }

    @Test
    //根据用户名查询用户信息及所有数据
    public void findByName_AllData(){
        List<Users> users=userDao.findByName_AllData("aghsh");
        for (Users user : users){
            System.out.println("----------每个用户信息及对应总数据----------");
            System.out.println(user);
            System.out.println(user.getData());
            System.out.println();
        }

    }
    //测试查询总记录条数
    @Test
    public void testFindTotal(){

        //5.使用代理对象执行方法
        int count=userDao.findTotal();
        System.out.println(count);

    }


}
