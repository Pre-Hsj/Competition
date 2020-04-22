package com.itheima.Dao;

import com.itheima.domian.Users;

import java.util.List;

/**
 * User用户的持久层接口,均有测试函数
 */
public interface IUserDao {

    //查询所有用户功能
    List<Users> findAll();

    //根据主键查询单个用户，主键为User_ID
    Users findById(Integer User_ID);

    //保存功能，即新增对象
    void saveUser(Users user);

    //更新对象的属性值
    void updateUser(Users user);

    //删除对象，注销对象
    void deleteUser(Integer User_ID);

    //模糊查询
    List<Users> findByName(String User_Name);

    //根据ID查询用户信息及所有数据
    Users findByID_AllData(Integer User_ID);

    //根据用户名查询用户信息及所有数据
    List<Users> findByName_AllData(String User_Name);

    //查询总用户数
    int findTotal();
}
