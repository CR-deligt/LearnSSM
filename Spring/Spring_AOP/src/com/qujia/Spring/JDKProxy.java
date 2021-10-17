package com.qujia.Spring;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
//用JDK动态代理
public class JDKProxy {
    public static void main(String[] args) {
        /**
         * Proxy.newProxyInstance(JDKProxy.class.getClassLoader(), interfaces, new UserDaoProxy(userDao))
         * 第一个参数：类加载器
         * 都二个参数：增强方法所在类实现的接口，支持多个接口
         * 第三个参数：创建代理对象，实现这个接口InvocationHandler，，写增强部分代码
         */
        //创建接口实现类代理对象
        Class[] interfaces = {UserDao.class};
        /*第三个参数可以用匿名内部类
        Proxy.newProxyInstance(JDKProxy.class.getClassLoader(), interfaces, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                return null;
            }
        })*/

        UserDao userDao = new UserDaoImpl();
        //最后做一个强转
        UserDao dao = (UserDao) Proxy.newProxyInstance(JDKProxy.class.getClassLoader(), interfaces, new UserDaoProxy(userDao));
        int add= dao.add(1,2);
    }
}

//创建代理对象代码
class UserDaoProxy implements InvocationHandler{

    //将创建代理对象的那个对象要传过来
    //有参构造传递
    private Object obj;

    public UserDaoProxy(Object obj) {
        this.obj = obj;
    }

    //增强的逻辑(要添加的一些操作)
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //可以对method进行筛选判断，对于特定的方法进行增强处理

        //方法前
        System.out.println("被增强方法之前....方法名："+method.getName()+"/n传递的参数"+ Arrays.toString(args));//add
        //被增强的方法
        Object res = method.invoke(obj, args);
        //方法后
        System.out.println("方法执行后...."+obj);//com.qujia.Spring.UserDaoImpl@300ffa5d
        return res;
    }
}