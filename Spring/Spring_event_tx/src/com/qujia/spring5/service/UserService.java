package com.qujia.spring5.service;

import com.qujia.spring5.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

//service里注dao，dao里注jdbc
@Service
@Transactional(timeout = 5,propagation = Propagation.REQUIRED,isolation = Isolation.REPEATABLE_READ)
//可以加到类上（类所有的方法都加事务），也可以加到方法上
//isolation 事务隔离级别
//timeout 单位s 事务要在一定时间提交，否则回滚（默认-1，不超时）
//readOnly 是否只读， 默认值否  true只能查询
//rollbackFor=异常class    出现哪些异常回滚
//noRollbackFor           设置出现哪些异常不回滚
public class UserService {
    @Autowired//注入dao
    private UserDao userDao;

    public void accountMoney(){
        //编程式方式开启事务
//        try{
//            //进行操作
//
//            //lucy少100
//            userDao.ReduceMoney();
//
//            //模拟异常
//            int i = 10/0;
//
//            //mary多100
//            userDao.AddMoney();
//            //此时，如果没有发生异常则提交事务
//
//        }catch(Exception e){
//            //如果出现异常，事务回滚
//
//        }

            userDao.ReduceMoney();
            //int i = 10/0;
            userDao.AddMoney();
    }
}

