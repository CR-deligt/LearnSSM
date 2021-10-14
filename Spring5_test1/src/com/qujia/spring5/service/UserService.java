package Spring5_test1.src.com.qujia.spring5.service;

import com.qujia.spring5.dao.UserDao;
import com.qujia.spring5.dao.UserDaoImpl;

public class UserService {

    //外部bean注入属性方法
    //创建UserDao类型属性，生成set方法
    private UserDao userDao;
    public void setUserDao(UserDao userDao){
        this.userDao=userDao;
    }

    public  void bean1(){

        System.out.println("service add");
        userDao.update();
        //原始方式
//        UserDao userDao = new UserDaoImpl();//接口 new实现类-------多态
//        userDao.update();
    }
}
