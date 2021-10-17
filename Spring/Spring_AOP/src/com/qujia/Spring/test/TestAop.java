package com.qujia.Spring.test;

import com.qujia.Spring.aopanno.User;
import com.qujia.Spring.aopxml.User2;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAop {
    @Test
    public void testAopAnno(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        User user = context.getBean("user", User.class);
        user.add();
    }
    @Test
    public void testAopXml(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");
        User2 user = context.getBean("user", User2.class);
        user.add();
    }
}
