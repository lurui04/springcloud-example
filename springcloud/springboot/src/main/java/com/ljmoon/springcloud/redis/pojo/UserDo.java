package com.ljmoon.springcloud.redis.pojo;

import java.io.Serializable;

/**
 * @author lurui
 * @Package: com.ljmoon.springcloud.redis.pojo
 * @ClassName: UserDo
 * @Description: 类描述
 * @Date: 2019-03-14 19:56
 */
public class UserDo implements Serializable {

    private String userName;

    private String passWord;

    private String sex;

    private Integer age;

    private String address;


    public UserDo(String userName, String passWord, String sex, Integer age, String address) {
        this.userName = userName;
        this.passWord = passWord;
        this.sex = sex;
        this.age = age;
        this.address = address;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "UserDo{" +
                "userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}
