package com.qujia.Spring.dao;

import org.springframework.stereotype.Repository;
@Repository(value = "userDaoImpl1")
public class UserDaoImp implements UserDao{
    @Override
    public void add() {
        System.out.println("dao add.........");
    }
}
