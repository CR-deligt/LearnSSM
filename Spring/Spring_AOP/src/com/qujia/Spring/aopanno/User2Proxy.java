package com.qujia.Spring.aopanno;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class User2Proxy {
    @Before(value = "execution(* com.qujia.Spring.aopanno.User.add(..))")
    public void before(){
        System.out.println("-----------User2 Before------------");
    }
    @After(value = "execution(* com.qujia.Spring.aopanno.User.add(..))")
    public void after(){
        System.out.println("-----------User2 after------------");
    }
}
