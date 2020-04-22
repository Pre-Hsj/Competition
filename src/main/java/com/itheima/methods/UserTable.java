package com.itheima.methods;

import com.itheima.Dao.IUserDao;
import com.itheima.domian.Users;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

public class UserTable {

    private InputStream in;
    private SqlSession session;
    private IUserDao userDao;



    /**
     *登录函数
     * @param User_ID #用户账号
     * @param password # 用户密码
     * @return boolean
     * @throws IOException
     */
    public boolean Login(int User_ID , String password) throws IOException {

        //基本操作
        //1.读取配置文件
        in = Resources.getResourceAsStream("SqlMapConfig");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        //3.使用工厂生产SqlSession对象
        session = factory.openSession(true);
        //4.使用SqlSession创建Dao的代理对象
        userDao = session.getMapper(IUserDao.class);

        //利用IUserDAO定义的方法寻找数据
        Users users = userDao.findById(User_ID);

        //数据为空，即数据库中并未存在参数组的对应数据
        if(users == null){
            System.out.println("不存在该用户，请注册！");
            //关闭流
            session.close();
            in.close();
            return false;
        }

        //ID存在，但是密码不对应
        if(!password.equals(users.getUser_Password())){
            System.out.println("密码输入错误，请重新输入");
            //关闭流
            session.close();
            in.close();
            return false;
        }

        //没有出现差错，ID和Password皆未出差错
        System.out.println("登陆成功！");
        //关闭流
        session.close();
        in.close();
        return true;
    }


    /**
     * 注册函数(仅注册用户名和密码）
     * @param Username #注册时使用的用户名，我们不要求用户名唯一性
     * @param Userpassword #注册时用户的自定义密码，同样也不要求唯一性
     * @return ID #返回ID，此后以ID作为登录账号
     * @throws IOException
     */
    public Integer Register1(String Username , String Userpassword) throws IOException{
        //基本操作
        //1.读取配置文件
        in = Resources.getResourceAsStream("SqlMapConfig");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        //3.使用工厂生产SqlSession对象
        session = factory.openSession(true);
        //4.使用SqlSession创建Dao的代理对象
        userDao = session.getMapper(IUserDao.class);

        //定义一个新的User对象
        Users users = new Users();

        //传参，即设置User对应的用户名及密码
        users.setUser_Name(Username);
        users.setUser_Password(Userpassword);

        //调用IUserDAO方法
        userDao.saveUser(users);

        //关闭流
        session.close();
        in.close();
        //返回ID给用户
        return users.getUser_ID();
    }


    /**
     *
     * @param Username
     * @param Userpassword
     * @param Usersex
     * @param Userage
     * @param Useremail
     * @param Usertelephonenumber
     * @param Useraddress
     * @param Subject1
     * @param Subject2
     * @param Subject3
     * @param Subject4
     * @param Subject5
     * @param Subject6
     * @return
     * @throws IOException
     */
    public Integer Register2(String Username , String Userpassword,String Usersex,Integer Userage,String Useremail,
                             String Usertelephonenumber,String Useraddress,String Subject1 , String Subject2 ,
                             String Subject3 , String Subject4,String Subject5,String Subject6) throws IOException{
        //基本操作
        //1.读取配置文件
        in = Resources.getResourceAsStream("SqlMapConfig");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        //3.使用工厂生产SqlSession对象
        session = factory.openSession(true);
        //4.使用SqlSession创建Dao的代理对象
        userDao = session.getMapper(IUserDao.class);

        //定义一个新的User对象
        Users users = new Users();

        //传参，即设置所有参数
        users.setUser_Name(Username);
        users.setUser_Password(Userpassword);
        users.setUser_Sex(Usersex);
        users.setUser_Age(Userage);
        users.setUser_Email(Useremail);
        users.setUser_TelephoneNumber(Usertelephonenumber);
        users.setUser_Address(Useraddress);
        users.setSubject1(Subject1);
        users.setSubject2(Subject2);
        users.setSubject3(Subject3);
        users.setSubject4(Subject4);
        users.setSubject5(Subject5);
        users.setSubject6(Subject6);

        //调用IUserDAO方法
        userDao.saveUser(users);

        //关闭流
        session.close();
        in.close();
        //返回ID给用户
        return users.getUser_ID();
    }

    /**
     * 注销函数（参数提供ID及密码的原因是提高安全性，防止误删，否则仅靠ID也可实现数据库注销操作）
     * @param User_ID #用户ID
     * @param Userpassword #用户密码
     * @return boolean #是否操作成功 true代表注销成功  false代表注销失败
     * @throws IOException
     */
    public boolean Cancellation(Integer User_ID ,String Userpassword) throws IOException{
        //基本操作
        //1.读取配置文件
        in = Resources.getResourceAsStream("SqlMapConfig");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        //3.使用工厂生产SqlSession对象
        session = factory.openSession(true);
        //4.使用SqlSession创建Dao的代理对象
        userDao = session.getMapper(IUserDao.class);

        //利用IUserDAO定义的方法寻找数据
        Users users = userDao.findById(User_ID);


        //不排除用户输错ID可能性
        if (users == null){
            System.out.println("账号输入错误，请重新输入！");
            //关闭流
            session.close();
            in.close();
            return false;
        }


        //ID存在，但是密码不对应
        if(!Userpassword.equals(users.getUser_Password())){
            System.out.println("密码输入错误，请重新输入");
            //关闭流
            session.close();
            in.close();
            return false;
        }

        //此处证明用户账号及密码验证成功
        if(Userpassword.equals(users.getUser_Password())){
            System.out.println("用户您好！您的账号密码验证成功，现进行安全性认证，是否确认删除密码？" +
                    "\n"+
                    "确认请输入“1”，否则请输入“0”"+
                    "\n");
            //定义输入流
            Scanner input = new Scanner(System.in);
            //获取键盘输入参数
            Integer temp = input.nextInt();
            while(temp != 0 && temp != 1){
                System.out.println("请按指令输入，现已输入错误，请重新输入！");
                temp = input.nextInt();
            }
            switch (temp){
                case 0:
                    System.out.println("退出注销！");
                    //关闭流
                    session.close();
                    in.close();
                    //返回false的原因是注销未成功
                    return false;
                case 1:
                    //请求注销
                    userDao.deleteUser(User_ID);
                    System.out.println("注销成功！");
                    //关闭流
                    session.close();
                    in.close();
                    //return 的原因为注销成功
                    return true;
            }


        }
        //关闭流
        session.close();
        in.close();
        return true;
    }

    /**
     *
     * @param User_ID
     * @param Username
     * @param Userpassword
     * @param Usersex
     * @param Userage
     * @param Useremail
     * @param Usertelephonenumber
     * @param Useraddress
     * @param Subject1
     * @param Subject2
     * @param Subject3
     * @param Subject4
     * @param Subject5
     * @param Subject6
     * @return
     * @throws IOException
     */
    public boolean Change_All(Integer User_ID, String Username , String Userpassword,String Usersex,Integer Userage,String Useremail,
                              String Usertelephonenumber,String Useraddress,String Subject1 , String Subject2 ,
                              String Subject3 , String Subject4,String Subject5,String Subject6) throws IOException{
        //基本操作
        //1.读取配置文件
        in = Resources.getResourceAsStream("SqlMapConfig");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        //3.使用工厂生产SqlSession对象
        session = factory.openSession(true);
        //4.使用SqlSession创建Dao的代理对象
        userDao = session.getMapper(IUserDao.class);


        //不再进行合法性检查
        Users users = new Users();
        //此处需要设置ID及密码是因为表格的性质不允许ID或者密码空出
        users.setUser_ID(User_ID);
        users.setUser_Password(Userpassword);

        //此处设置新用户名
        users.setUser_Name(Username);

        //此处重新设置其余所有属性
        users.setUser_Sex(Usersex);
        users.setUser_Age(Userage);
        users.setUser_Email(Useremail);
        users.setUser_TelephoneNumber(Usertelephonenumber);
        users.setUser_Address(Useraddress);
        users.setSubject1(Subject1);
        users.setSubject2(Subject2);
        users.setSubject3(Subject3);
        users.setSubject4(Subject4);
        users.setSubject5(Subject5);
        users.setSubject6(Subject6);

        userDao.updateUser(users);
        System.out.println("修改资料成功！");

        //关闭流
        session.close();
        in.close();
        return true;

    }

    /**
     *
     * @param User_Name
     * @return
     * @throws IOException
     */
    public List<Users> findByName(String User_Name) throws IOException {
        //基本操作
        //1.读取配置文件
        in = Resources.getResourceAsStream("SqlMapConfig");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        //3.使用工厂生产SqlSession对象
        session = factory.openSession(true);
        //4.使用SqlSession创建Dao的代理对象
        userDao = session.getMapper(IUserDao.class);

        List<Users> users = userDao.findByName("%" + User_Name + "%");
        if (users == null) {
            System.out.println("暂无包含此名的用户！请重新输入！");
            session.close();
            in.close();
            return null;
        } else {
            //关闭流
            session.close();
            in.close();
            return users;
        }
    }

    /**
     *
     * @param User_ID
     * @return
     * @throws IOException
     */
    //根据用户ID查询用户信息及用户的所有数据
    public Users findByID_AllData(Integer User_ID) throws IOException {
        //基本操作
        //1.读取配置文件
        in = Resources.getResourceAsStream("SqlMapConfig");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        //3.使用工厂生产SqlSession对象
        session = factory.openSession(true);
        //4.使用SqlSession创建Dao的代理对象
        userDao = session.getMapper(IUserDao.class);

        //数据已完全封装至Uers.Data
        Users users = userDao.findByID_AllData(User_ID);
        if (users == null) {
            System.out.println("查无此账号，请重新输入！");
            return null;
        } else {

            //关闭流
            session.close();
            in.close();
            return users;

        }

    }

    /**
     *
     * @param User_Name
     * @return
     * @throws IOException
     */
    //根据用户名查询用户信息及用户的所有数据
    public List<Users> findByName_AllData(String User_Name) throws IOException {
        //基本操作
        //1.读取配置文件
        in = Resources.getResourceAsStream("SqlMapConfig");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        //3.使用工厂生产SqlSession对象
        session = factory.openSession(true);
        //4.使用SqlSession创建Dao的代理对象
        userDao = session.getMapper(IUserDao.class);

        //数据已完全封装至Uers.Data
        List<Users> users = userDao.findByName_AllData(User_Name);

        if (users == null) {
            System.out.println("暂无包含此名的用户，请重新输入！");
            session.close();
            in.close();
            return null;
        } else {
            //关闭流
            session.close();
            in.close();
            return users;

        }
    }

    public static void main(String[] args) throws IOException {

    }
}
