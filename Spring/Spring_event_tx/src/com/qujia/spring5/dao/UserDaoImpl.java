package com.qujia.spring5.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    //lucy赚钱100给mary
    @Override
    public void AddMoney() {
        String sql="update t_account set money = money+? where username=?";
        jdbcTemplate.update(sql,100,"mary");
    }

    @Override
    public void ReduceMoney() {
        String sql="update t_account set money = money-? where username=?";
        jdbcTemplate.update(sql,100,"lucy");
    }
}
