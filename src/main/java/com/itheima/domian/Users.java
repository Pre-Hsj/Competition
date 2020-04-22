package com.itheima.domian;

import java.io.Serializable;
import java.util.List;

/**
 * 用户实体类
 */
public class Users implements Serializable {
    private Integer User_ID;
    private String User_Name;
    private String User_Password;
    private String User_Sex;
    private Integer User_Age;
    private String User_Email;
    private String User_TelephoneNumber;
    private String User_Address;
    private String Subject1;
    private String Subject2;
    private String Subject3;
    private String Subject4;
    private String Subject5;
    private String Subject6;

    //一对多关系映射，主表包含从表的集体引用
    private List<Data> data;

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    public Integer getUser_ID() {
        return User_ID;
    }

    public void setUser_ID(Integer user_ID) {
        User_ID = user_ID;
    }

    public String getUser_Name() {
        return User_Name;
    }

    public void setUser_Name(String user_Name) {
        User_Name = user_Name;
    }

    public String getUser_Password() {
        return User_Password;
    }

    public void setUser_Password(String user_Password) {
        User_Password = user_Password;
    }

    public String getUser_Sex() {
        return User_Sex;
    }

    public void setUser_Sex(String user_Sex) {
        User_Sex = user_Sex;
    }

    public Integer getUser_Age() {
        return User_Age;
    }

    public void setUser_Age(Integer user_Age) {
        User_Age = user_Age;
    }

    public String getUser_Email() {
        return User_Email;
    }

    public void setUser_Email(String user_Email) {
        User_Email = user_Email;
    }

    public String getUser_TelephoneNumber() {
        return User_TelephoneNumber;
    }

    public void setUser_TelephoneNumber(String user_TelephoneNumber) {
        User_TelephoneNumber = user_TelephoneNumber;
    }

    public String getUser_Address() {
        return User_Address;
    }

    public void setUser_Address(String user_Address) {
        User_Address = user_Address;
    }

    public String getSubject1() {
        return Subject1;
    }

    public void setSubject1(String subject1) {
        Subject1 = subject1;
    }

    public String getSubject2() {
        return Subject2;
    }

    public void setSubject2(String subject2) {
        Subject2 = subject2;
    }

    public String getSubject3() {
        return Subject3;
    }

    public void setSubject3(String subject3) {
        Subject3 = subject3;
    }

    public String getSubject4() {
        return Subject4;
    }

    public void setSubject4(String subject4) {
        Subject4 = subject4;
    }

    public String getSubject5() {
        return Subject5;
    }

    public void setSubject5(String subject5) {
        Subject5 = subject5;
    }

    public String getSubject6() {
        return Subject6;
    }

    public void setSubject6(String subject6) {
        Subject6 = subject6;
    }

    @Override
    public String toString() {
        return "Users{" +
                "User_ID=" + User_ID +
                ", User_Name='" + User_Name + '\'' +
                ", User_Password='" + User_Password + '\'' +
                ", User_Sex='" + User_Sex + '\'' +
                ", User_Age=" + User_Age +
                ", User_Email='" + User_Email + '\'' +
                ", User_TelephoneNumber='" + User_TelephoneNumber + '\'' +
                ", User_Address='" + User_Address + '\'' +
                ", Subject1='" + Subject1 + '\'' +
                ", Subject2='" + Subject2 + '\'' +
                ", Subject3='" + Subject3 + '\'' +
                ", Subject4='" + Subject4 + '\'' +
                ", Subject5='" + Subject5 + '\'' +
                ", Subject6='" + Subject6 + '\'' +
                '}';
    }
}
