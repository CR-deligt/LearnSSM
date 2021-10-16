package com.qujia.Spring.service;

import com.qujia.Spring.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

//注解里的value可以不写，默认类名称首字母小写
//类似 bean id = "userService"
@Service//(value = "userService")
public class UserService {

    @Value(value = "AAA")//注入普通类型的属性
    private String name;

    /*@Autowired
        //@Autowired根据类型注入属性
        //如果实现类有多个就会报错
        // 不需要写set方法
        //写在类里边（注入的属性的类也要加上标签）
    @Qualifier(value = "userDaoImpl1")
        //根据名称注入属性
        //要和@Autowired一起使用*/
    @Resource(name = "userDaoImpl1")//不是spring的，这里JDK版本过高，没有resource要导入javax.annotation-api-1.3.2.jar包
    private UserDao userDao;


    public void add(){
        System.out.println(name);
        System.out.println("service add......");
        userDao.add();
    }



}
