package com.qujia.Spring.service;

import com.qujia.Spring.dao.BookDao;
import com.qujia.Spring.entiy.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    //注入dao
    @Autowired
    private BookDao bookDao;


    //添加
    public void addBook(Book book){
        bookDao.add(book);
    }
    //修改
    public void updateBook(Book book){
        bookDao.updateBook(book);
    }
    //删除
    public void deleteBook(String id){
        bookDao.deleteBook(id);
    }
    //查询表中的记录数
    public int findCount(){
        return bookDao.findCount();
    }
    //查询某一本书
    public Book findBook(String id){
        return bookDao.findBook(id);
    }
    //查询返回集合
    public List<Book> findAll(){
        return bookDao.findAll();
    }
    //批量添加
    public void batchAdd(List<Object[]> batchArgs){
        bookDao.batchAdd(batchArgs);
    }
    //批量修改
    public void batchUpdate(List<Object[]> batchArgs){
        bookDao.batchUpdate(batchArgs);
    }
    //批量删除
    public void batchDelete(List<Object[]> batchArgs){
        bookDao.batchDelete(batchArgs);
    }
}
