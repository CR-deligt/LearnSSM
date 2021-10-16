package com.qujia.Spring.testdemo;

import com.qujia.Spring.autowrie.Emp;
import com.qujia.Spring.beanLife.Orders;
import com.qujia.Spring.collectiontype.Book;
import com.qujia.Spring.collectiontype.Course;
import com.qujia.Spring.collectiontype.Stu;
import com.qujia.Spring.factorybean.Mybean;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpringDemo1 {
    @Test
    public void testCollection(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        Stu stu = context.getBean("stu", Stu.class);
        stu.test();
    }
    @Test
    public void testCollection2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beanDraw.xml");
        Book book1 = context.getBean("book", Book.class);
        Book book2 = context.getBean("book", Book.class);
    }
    @Test
    public void testFactoryBean(){
        ApplicationContext context = new ClassPathXmlApplicationContext("f_bean.xml");
        Course course = context.getBean("myBean", Course.class);
        System.out.println(course);
    }
    @Test
    public void testBeanLife(){
        //ApplicationContext context = new ClassPathXmlApplicationContext("beanLife.xml");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanLife.xml");
        Orders orders = context.getBean("orders", Orders.class);
        System.out.println("4获取bean实例对象");
        System.out.println(orders);

        //手动销毁bean实例
        //((ClassPathXmlApplicationContext)context).close();//多态中父类不能使用子类特有方法
        context.close();
    }
    @Test
    public void testBeanAuto(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beanAuto.xml");
        Emp emp = context.getBean("emp", Emp.class);
        System.out.println(emp);
    }
}
