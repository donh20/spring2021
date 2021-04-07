package com.ncamc.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(5)
public class PersonProxy {
    @Pointcut(value = "execution(* com.ncamc.annotation.User.add(..))")
    public void point() {}

    @Before(value = "point()")
    public void before() {
        System.out.println("person before....");
    }
}
