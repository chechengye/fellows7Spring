package com.lovecoding.bean;

public class UserFactory {

    /**
     * 静态方法
     * @return
     */
    public static User createUser(){
        return new User();
    }

    /**
     * 实例方法
     * @return
     */
    public User createUser2(){
        return new User();
    }
}
