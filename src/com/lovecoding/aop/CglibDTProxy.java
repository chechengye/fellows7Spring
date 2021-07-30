package com.lovecoding.aop;

import com.lovecoding.aop.impl.OrderServiceImpl;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Cglib动态代理 - 继承式的，被代理的目标对象一定不能被final修饰
 */
public class CglibDTProxy implements MethodInterceptor {

    /**
     * 获取代理后对象的出口
     * @return
     */
    public OrderService getProxyOrderService(){
        Enhancer en = new Enhancer();//确定即将被代理的目标对象
        en.setSuperclass(OrderServiceImpl.class);//设定好目标对象
        en.setCallback(this);//拦截方式添加
        return (OrderService)en.create();//创建被代理后的对象
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] ags, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib拦截前...");

        Object o = methodProxy.invokeSuper(obj , ags);
        System.out.println("cglib拦截后...");
        return o;
    }
}
