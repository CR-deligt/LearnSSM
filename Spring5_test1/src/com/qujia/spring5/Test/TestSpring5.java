package Spring5_test1.src.com.qujia.spring5.Test;

import Spring5_test1.src.com.qujia.spring5.Book;
import Spring5_test1.src.com.qujia.spring5.Orders;
import Spring5_test1.src.com.qujia.spring5.User;
import com.qujia.spring5.bean.Emp;
import Spring5_test1.src.com.qujia.spring5.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.security.Provider;

public class TestSpring5 {
    @Test
    public void testAdd(){
        //加载配置文件
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean.xml");

        //获取配置对象
        User user = context.getBean("user", User.class);
        System.out.println(user);
        user.add();
    }
    @Test
    public void testBook1(){
        //加载配置文件
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean.xml");

        //获取配置对象
        Book book = context.getBean("book", Book.class);
        System.out.println(book);
        System.out.println(book.TestBook());
    }
    @Test
    public void testOrders(){
        //加载配置文件
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean.xml");

        //获取配置对象
        Orders orders = context.getBean("orders", Orders.class);
        System.out.println(orders);
        System.out.println(orders.TestOrders());
    }
    @Test
    public void testBean1(){
        //加载配置文件
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean2.xml");

        //获取配置对象
        UserService service = context.getBean("userService", UserService.class);
        service.bean1();
    }
    @Test
    public void testBean2(){
        //加载配置文件
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean4.xml");

        //获取配置对象
        Emp emp = context.getBean("emp", Emp.class);
        System.out.println(emp.add());
    }
}

