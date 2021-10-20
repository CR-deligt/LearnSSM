package com.qujia.spring5.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    //多钱
    public void AddMoney();
    //少钱
    public void ReduceMoney();
}
