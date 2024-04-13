package com.gugu.demo.util.serializable;

import java.io.Serializable;

/**
 * @author Administrator
 * @Classname User
 * @Description TODO
 * @Date 2022/5/29 16:29
 */
public class User implements Serializable {

    private static final long serialVersionUID = -8840853971861469954L;

    public User() {
        System.out.println("init User");
    }

    public User(String userName, String address) {
        this.userName = userName;
        this.address = address;
    }

    private String userName = "gugu";
    // transient 关键词修饰的属性不会序列化
    private transient String address;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
