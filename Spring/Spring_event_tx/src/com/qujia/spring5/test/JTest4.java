package com.qujia.spring5.test;

import com.qujia.spring5.service.UserService;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)//指定单元测试框架版本
@ContextConfiguration("classpath:bean1.xml")//加载配置文件
@Transactional
//  以上两句      ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
public class JTest4 {
    @Autowired
    private UserService userService;//直接注入

    @Test
    public void test1(){
        userService.accountMoney();
    }

}
