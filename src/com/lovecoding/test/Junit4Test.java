package com.lovecoding.test;

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
public class Junit4Test {
    @Autowired
    Car car;

    @Test
    public void testFn(){
        System.out.println(car);
    }
}
