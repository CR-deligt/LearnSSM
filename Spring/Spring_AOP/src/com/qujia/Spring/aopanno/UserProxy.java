package com.qujia.Spring.aopanno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//增强的类
@Component
@Aspect//用于生成代理对象
@Order(2)
public class UserProxy {
    //相同切入点抽取
    @Pointcut(value = "execution(* com.qujia.Spring.aopanno.User.add(..))")
    public void pointdemo(){}

    //在增强类中，在作位通知的方法上添加通知类型注解，使用切入点表达式来配置

    @Before(value = "pointdemo()")
    //前置通知
    public void before(){
        System.out.println("-----before-----");
    }
    //最终通知（方法执行后执行，有没有异常都执行）
    @After(value = "execution(* com.qujia.Spring.aopanno.User.add(..))")
    public void after(){
        System.out.println("-----------after------------");
    }
    //返回通知/后置通知（在方法返回值之后执行，有异常就不执行）
    @AfterReturning(value = "execution(* com.qujia.Spring.aopanno.User.add(..))")
    public void afterReturning(){
        System.out.println("-----------AfterReturning------------");
    }
    //异常通知
    @AfterThrowing(value = "execution(* com.qujia.Spring.aopanno.User.add(..))")
    public void afterThrowing(){
        System.out.println("-----------AfterThrowing------------");
    }
    //环绕通知（之前之后都执行）
    @Around(value = "execution(* com.qujia.Spring.aopanno.User.add(..))")
    public void around(ProceedingJoinPoint proceedingJoinPoint){
        System.out.println("-----------Around------------");
        System.out.println("-----------环绕前------------");
        try {
            proceedingJoinPoint.proceed();//这个是执行被增强的方法
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("-----------环绕后------------");
    }
}
