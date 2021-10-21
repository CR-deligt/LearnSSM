package com.qujia.spring5.test;


import com.qujia.spring5.congif.TxConfig;
import com.qujia.spring5.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class TestDemo {

    @Test
    public void testAccount() {//注解配置
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.accountMoney();
    }
    @Test
    public void testAccount2() {//xml文件配置
        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.accountMoney();
    }
    @Test
    public void testAccount3() {//全注解方式
        ApplicationContext context = new AnnotationConfigApplicationContext(TxConfig.class);
        UserService userService = context.getBean("userService", UserService.class);
        userService.accountMoney();
    }
    @Test
    public void testGenericApplicationContext() {
        //将自己创建的对象加入到bean管理的IOC容器
       GenericApplicationContext context = new GenericApplicationContext();
       context.refresh();
       context.registerBean("user",User.class,()->new User());//将对象注册bean
        //法一 (注册没写第一个参数)
//        User user = (User)context.getBean("com.qujia.spring5.test.User");//类的全路径
//        System.out.println(user);

        //法二    (注册写了第一个参数”user“)
        User user1 = (User)context.getBean("user");
        System.out.println(user1);

    }
}


