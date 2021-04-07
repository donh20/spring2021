package com.ncamc.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(3)
public class UserProxy {
    //把相同的切入点进行抽取
    @Pointcut(value = "execution(* com.ncamc.annotation.User.add(..))")
    public void point() {

    }


    @Before(value = "point()")
    public void before() {
        System.out.println("before....");
    }


    //环绕通知
    @Around(value = "point()")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕之前.........");

        //被增强的方法执行
        proceedingJoinPoint.proceed();

        System.out.println("环绕之后.........");
    }
}
