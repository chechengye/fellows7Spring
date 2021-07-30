package com.lovecoding.aop;

import com.lovecoding.aop.impl.OrderServiceImpl;
import com.lovecoding.bean.Car;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Spring里面的测试注解应用
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:com/lovecoding/annotation/annotation.xml")
public class Junit4AopTest {


    /**
     * 测试JDK动态代理
     */
    @Test
    public void testFn(){
        OrderService os = new OrderServiceImpl();
        JdkDTProxy jdp = new JdkDTProxy();
        OrderService proxyOrderService = jdp.getProxyOrderService(os);
        proxyOrderService.addOrder();
        System.out.println("----------------------");
        System.out.println(proxyOrderService instanceof OrderServiceImpl);//代理后的对象与目标对象没有父子关系。-- 兄弟关系
    }

    /**
     *测试Cglib动态代理
     */
    @Test
    public void testFn1(){
        CglibDTProxy cdp = new CglibDTProxy();
        OrderService proxyOrderService = cdp.getProxyOrderService();
        proxyOrderService.updateOrderById(1);
        System.out.println("----------------------");
        System.out.println(proxyOrderService instanceof OrderServiceImpl);//继承式 - 父子关系 ，代理后的对象通过继承目标对象产生的
    }
}
