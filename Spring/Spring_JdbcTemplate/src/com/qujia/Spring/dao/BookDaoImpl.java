package com.qujia.Spring.dao;

import com.qujia.Spring.entiy.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class BookDaoImpl implements BookDao{
    //注入JdbcTemplate
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void add(Book book) {

        String sql="insert into t_book values(?,?,?)";
        Object[] args = { book.getUserId(), book.getUser_name(), book.getUstatus()};
        int update = jdbcTemplate.update(sql,args);
        System.out.println(update);
    }

    @Override
    public void updateBook(Book book) {
        String sql="update t_book set user_name=?,ustatus=? where user_id=?";
        Object[] args = { book.getUser_name(),  book.getUstatus(),book.getUserId()};
        int update = jdbcTemplate.update(sql,args);
        System.out.println(update);
    }

    @Override
    public void deleteBook(String id) {
        String sql="delete from t_book where user_id=?";
        int update = jdbcTemplate.update(sql,id);
        System.out.println(update);
    }

    @Override
    public int findCount() {
        String sql="select count(*) from t_book";
        int count = jdbcTemplate.queryForObject(sql,Integer.class);//查询某个值 两个参数
        return count;
    }

    @Override
    public Book findBook(String id) {
        String sql="select * from t_book where user_id=?";
        Book book = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Book>(Book.class), id);//查询某个对象 三个参数 sql语句 RowMapper接口 sql语句的值
        return book;
    }

    @Override
    public List<Book> findAll() {
        String sql="select * from t_book";
        List<Book> bookList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Book>(Book.class));//查询集合(输出)
        return bookList;
    }

    @Override
    public void batchAdd(List<Object[]> batchArgs) {
        String sql="insert into t_book values(?,?,?)";
        int[] ints = jdbcTemplate.batchUpdate(sql,batchArgs);//会遍历List（输入）
        System.out.println(Arrays.toString(ints));
    }

    @Override
    public void batchUpdate(List<Object[]> batchArgs) {
        String sql="update t_book set user_name=?,ustatus=? where user_id=?";
        int[] ints = jdbcTemplate.batchUpdate(sql,batchArgs);
        System.out.println(Arrays.toString(ints));
    }

    @Override
    public void batchDelete(List<Object[]> batchArgs) {
        String sql="delete from t_book where user_id=?";
        int[] ints = jdbcTemplate.batchUpdate(sql,batchArgs);
        System.out.println(Arrays.toString(ints));
    }
}
