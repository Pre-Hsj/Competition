package com.itheima.test;

import com.itheima.Dao.IDataDao;
import com.itheima.Dao.IUserDao;
import com.itheima.domian.Data;
import com.itheima.domian.Users;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class Datatest {
    private InputStream in;
    private SqlSession session;
    private IDataDao dataDao;

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
        dataDao= session.getMapper(IDataDao.class);
    }
    @After
    public void destroy()throws Exception{
        //6.释放资源
        session.close();
        in.close();
    }
    @Test
    public void testFindAll() throws Exception {
        //5.使用代理对象执行方法
        List<Data> data = dataDao.findAll();
        for (Data user : data){
            System.out.println("--------每条数据的信息----------");
            System.out.println(user);
            System.out.println(user.getUsers());
            System.out.println();
        }
    }

    //测试查询一个操作
    @Test
    public void testFindById()throws Exception{
        //5.使用代理对象执行方法
        Data data=dataDao.findById(1);
        System.out.println(data);
    }

    //测试保存操作
    @Test
    public void testSave(){
        Data data = new Data();
        data.setUID(7);
        data.setData_Introduce("hahahha");
        data.setData_Resource("sjcbsbv");
        System.out.println("保存操作之前："+data);
        //5.使用代理对象执行方法
        dataDao.saveData(data);
        System.out.println("保存操作之后："+data);

    }

    //测试更新操作
    @Test
    public void testUpdateData(){
        Data data=new Data();
       data.setData_ID(4);
       data.setUID(7);
       data.setData_Introduce("123456");
        //5.使用代理对象执行方法
        dataDao.updateData(data);
    }

    //测试删除操作
    @Test
    public void testDelete(){

        //5.使用代理对象执行方法
        dataDao.deleteData(5);
    }


    //测试模糊查询
    @Test
    public void testFindByName(){

        //5.使用代理对象执行方法
        List<Data> data=dataDao.findByName("%234%");
        for(Data data1 : data) {
            System.out.println(data1);
        }
    }
    @Test
    //根据ID查询Data信息及所属用户
    public void findByID_AllData(){
        Data data = dataDao.findByID_BelongUser(2);
        System.out.println(data);
        System.out.println(data.getUsers());

    }

    //测试查询总记录条数
    @Test
    public void testFindTotal(){

        //5.使用代理对象执行方法
        int count=dataDao.findTotal();
        System.out.println(count);

    }

}
