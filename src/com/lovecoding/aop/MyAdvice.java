package com.lovecoding.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * 自定义的通知类、用来作为拦截目标对象方法的操作
 */
@Aspect
public class MyAdvice {

    @Pointcut("execution(* com.lovecoding.aop.impl.OrderServiceImpl.*(..))")
    public void pc(){}

    @Before("MyAdvice.pc()")
    public void before(){
        //切入点前执行的通知/拦截
        System.out.println("拦截前通知...");
    }

    @AfterReturning("MyAdvice.pc()")
    public void afterRunning(){
        System.out.println("正常运行拦截后通知...");
    }

    public void throwing(){
        System.out.println("异常情况下拦截...");
    }

    public void finalAfter(){
        System.out.println("最终拦截通知，此通知一定会被执行...");
    }

    /**
     * 若环绕通知中对异常进行处理，则切入点方法可以正常执行完毕。
     * 若抛出，则切入点方法不能正常返回。
     * @param pjp
     * @return
     * @throws Throwable
     */
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("环绕前拦截通知...");
        Object o = pjp.proceed();
        System.out.println("环绕后拦截通知...");
        return o;
    }

}
