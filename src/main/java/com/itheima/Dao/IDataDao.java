package com.itheima.Dao;

import com.itheima.domian.Data;
import com.itheima.domian.Users;

import java.util.List;

/**
 * 用户的持久层接口
 */
public interface IDataDao {

    //查询所有
    List<Data> findAll();
    //根据主键查询单个Data，主键为Data_ID
    Data findById(Integer Data_ID);

    //保存功能，即新增Data
    void saveData(Data data);

    //更新Data的属性值
    void updateData(Data data);

    //删除Data
    void deleteData(Integer Data_ID);

    //模糊查询
    List<Data> findByName(String Data_Introduce);

    //根据ID查询Data信息及所属用户
    Data findByID_BelongUser(Integer Data_ID);

    //查询总数据数
    int findTotal();

}
