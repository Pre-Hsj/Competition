package com.itheima.methods;

import com.itheima.Dao.IDataDao;
import com.itheima.domian.Data;
import com.itheima.domian.Users;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class DataTable {


    private InputStream in;
    private SqlSession session;
    private IDataDao dataDao;

    /**
     * 保存函数
     * @param User_ID #用户账号
     * @param Data_Introduce #资源描述
     * @param Data_Resource #资源
     * @return 数据ID
     * @throws IOException
     */
    public Integer saveData(Integer User_ID,String Data_Introduce,String Data_Resource) throws IOException {
        //1.读取配置文件
        in = Resources.getResourceAsStream("SqlMapConfig");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        //3.使用工厂生产SqlSession对象
        session = factory.openSession(true);
        //4.使用SqlSession创建Dao的代理对象
        dataDao= session.getMapper(IDataDao.class);

        Data data = new Data();
        data.setUID(User_ID);
        data.setData_Introduce(Data_Introduce);
        data.setData_Resource(Data_Resource);

        dataDao.saveData(data);

        //6.释放资源
        session.close();
        in.close();
        return data.getData_ID();

    }

    /**
     * 修改函数
     * @param Data_ID 数据ID
     * @param UID 用户账号
     * @param Data_introduce 资源描述
     * @param Data_resource 资源
     * @return
     * @throws IOException
     */
    public boolean change_All(Integer Data_ID,Integer UID, String Data_introduce,String Data_resource) throws IOException {
        //1.读取配置文件
        in = Resources.getResourceAsStream("SqlMapConfig");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        //3.使用工厂生产SqlSession对象
        session = factory.openSession(true);
        //4.使用SqlSession创建Dao的代理对象
        dataDao= session.getMapper(IDataDao.class);
        Data data = new Data();
        data.setData_ID(Data_ID);
        data.setUID(UID);
        data.setData_Introduce(Data_introduce);
        data.setData_Resource(Data_resource);
        dataDao.updateData(data);
        System.out.println("修改资料成功！");
        session.close();
        in.close();
        return true;
    }

    /**
     * 删除数据
     * @param Data_ID 数据ID
     * @return
     * @throws IOException
     */
    public boolean deleteData(Integer Data_ID) throws IOException {
        //1.读取配置文件
        in = Resources.getResourceAsStream("SqlMapConfig");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        //3.使用工厂生产SqlSession对象
        session = factory.openSession(true);
        //4.使用SqlSession创建Dao的代理对象
        dataDao= session.getMapper(IDataDao.class);

        dataDao.deleteData(Data_ID);
        session.close();
        in.close();
        return true;
    }


    public List<Data> findDataLike(String Data_Introduce) throws IOException {
        //1.读取配置文件
        in = Resources.getResourceAsStream("SqlMapConfig");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        //3.使用工厂生产SqlSession对象
        session = factory.openSession(true);
        //4.使用SqlSession创建Dao的代理对象
        dataDao= session.getMapper(IDataDao.class);

        //5.使用代理对象执行方法
        List<Data> data=dataDao.findByName("%"+Data_Introduce +"%");
        session.close();
        in.close();

        return data;

    }

    /**
     * 根据数据调出用户
     * @param Data_ID
     * @return
     * @throws IOException
     */
    public Data data_User(Integer Data_ID) throws  IOException{
        //1.读取配置文件
        in = Resources.getResourceAsStream("SqlMapConfig");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        //3.使用工厂生产SqlSession对象
        session = factory.openSession(true);
        //4.使用SqlSession创建Dao的代理对象
        dataDao= session.getMapper(IDataDao.class);

        Data data = dataDao.findByID_BelongUser(Data_ID);
        session.close();
        in.close();

        return data;
    }
    /**
     * 主函数
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        DataTable dataTable = new DataTable();
    }
}
