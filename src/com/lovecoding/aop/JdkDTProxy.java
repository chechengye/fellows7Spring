package com.lovecoding.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * JDK动态代理  必须借助于InvocationHandler，最终通过反射的invoke调用到目标代理对象中的方法
 */
public class JdkDTProxy implements InvocationHandler{
    private OrderService orderService;

    public OrderService getProxyOrderService(OrderService os){
        this.orderService = os;
        return (OrderService)Proxy.newProxyInstance(os.getClass().getClassLoader() , os.getClass().getInterfaces() , this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("拦截前操作...");
        Object o = method.invoke(orderService , args);
        System.out.println("拦截后操作...");
        return o;
    }
}
