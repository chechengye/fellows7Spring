package com.lovecoding.bean;

public class User {

    private String name;

    private int age;

    public User(){
        //System.out.println("空参构造方法实例化对象");
    }

    public void init(){
        System.out.println("初始化方法...简单初始化配置");
    }

    public void destroy(){
        System.out.println("销亡方法...关闭对象操作等");
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
