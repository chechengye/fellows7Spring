package com.lovecoding.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Component ： 可以将一个类添加到Spring容器中，动态生成一个bean 。默认名称都是类名首字母小写
 *      可以使用value属性动态的修改名称。自定义的类、vo层与数据库表没有产生直接关系的。
 * @Service : 可以将一个类添加到Spring容器中，动态生成一个bean 。但此注解通常应用于标记service层的业务类
 * @Controller ： 可以将一个类添加到Spring容器中，动态生成一个bean  。但此注解通常应用于标记Controller层
 * @Repository ： 可以将一个类添加到Spring容器中，动态生成一个bean 。 但其用于标记dao层
 * @Scope : 不推荐应用修改成为多例 - 特别是使用ssm技术栈的时候
 *  @Value("李四") ：
 *      1、应用于属性上面，就称为字段注入。使用反射的机制，破坏封装性
 *      2、如果应用于setXX方法上面，就是set方式注入 -- 推荐 (不破坏封装)
 *      3、由于set方式注入，不工整，麻烦。实际应用中，以字段注入使用居多。
 * @Autowired ： 自动专装配   -- 应用最广的。方便的
 *      1、可以完成引用类型、自定义的/第三方的类型注入
 *      2、会自动找寻标记此类的名称首字母为小写的bean。
 *      3、同一个对象在容器中配置多个、名称若都是非首字母小写的。此时自动装配失效
 *      4、若容器中只存在于一个对象配置的时候。自动装配直接读取，不关心命名。
 *      5、若是多对象命名还不规范时可以使用@Qualifier注解组合本注解使用。
 *
 * @Autowired + @Qualifier 组合应用时。可以使用@Resource(name = "car2")代替。
 *
 *
 */
@Component(value = "person1")
//@Scope(value = "prototype")
public class Person {

    //@Value("李四")
    private String name;
    //@Value("22")
    private int age;

    /*@Autowired
    @Qualifier(value = "car1")*/
    @Resource(name = "car2")
    private Car car;

    public String getName() {
        return name;
    }

    @Value("关羽")
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    @Value("3000")
    public void setAge(int age) {
        this.age = age;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", car=" + car +
                '}';
    }
}
