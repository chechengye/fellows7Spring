package com.lovecoding.test;

import com.lovecoding.bean.CollectionDemo;
import com.lovecoding.bean.Person;
import com.lovecoding.bean.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 面试题：
 *  Spring容器中多次获取同一个对象。这几个对象是同一个吗？
 *
 *  IOC ： Inverse Of Control 反转控制
 *      将创建对象的权利交由给了Spring容器，我们直接获取即可.
 *  DI : Dependency Injection 依赖注入
 *       注入方式：
 *             字段注入 （属性）
 *             Set方法注入
 *             构造方法注入
 *       注入类型：
 *              简单类型
 *              引用类型
 *              表达式
 *              复杂数据类型
 */
public class QuickTest {


    @Test
    public void testFn(){
        //使用此对象可以获取、加载applicationContext.xml的Spring核心配置文件
        //其后，才可以获取文件容器中配置的对象 classpath Spring与SpringMVC读取配置文件类路径使用的
        //对象接收可以使用多态ClassPathXmlApplicationContext 的父接口
        //ClassPathXmlApplicationContext 对象加载配置文件的时候，所有空参构造对象即已经实例化OK了。
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        //获取容器中的对象
        //User user = (User)ac.getBean("a1");//key : 可以获取到name的也可以是id的

        ac.close();//默认只包含了其中一个对象的话，调用关闭就执行销亡方法
        /*User user1 = (User)ac.getBean("a2");
        System.out.println(user == user1);*/
    }

    @Test
    public void testFn1(){

        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        User fUser = (User)ac.getBean("f_user");//静态工厂对象
        User ffUser = (User)ac.getBean("ff_user");

        System.out.println(ffUser);
    }

    @Test
    public void testFn2(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:com/lovecoding/injection/injection.xml");
        Person person = (Person) ac.getBean("person1");

        System.out.println(person);
    }

    /**
     * 复杂类型的注入测试
     */
    @Test
    public void testFn3(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:com/lovecoding/injection/injection.xml");
        CollectionDemo collectionDemo = (CollectionDemo) ac.getBean("collectionDemo");

        System.out.println(collectionDemo);
    }

    @Test
    public void testFn4(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:com/lovecoding/annotation/annotation.xml");
        Person person = (Person) ac.getBean("person1");

        System.out.println(person);
    }
}
