package com.itheima.domian;

import java.io.Serializable;

public class Data implements Serializable {
    private Integer Data_ID;
    private Integer UID;
    private String Data_Introduce;
    private String Data_Resource;

    //配置一对一
    private Users users;

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Integer getData_ID() {
        return Data_ID;
    }

    public void setData_ID(Integer data_ID) {
        Data_ID = data_ID;
    }

    public Integer getUID() {
        return UID;
    }

    public void setUID(Integer UID) {
        this.UID = UID;
    }

    public String getData_Introduce() {
        return Data_Introduce;
    }

    public void setData_Introduce(String data_Introduce) {
        Data_Introduce = data_Introduce;
    }

    public String getData_Resource() {
        return Data_Resource;
    }

    public void setData_Resource(String data_Resource) {
        Data_Resource = data_Resource;
    }

    @Override
    public String toString() {
        return "Data{" +
                "Data_ID=" + Data_ID +
                ", UID=" + UID +
                ", Data_Introduce='" + Data_Introduce + '\'' +
                ", Data_Resource='" + Data_Resource + '\'' +
                '}';
    }
}
