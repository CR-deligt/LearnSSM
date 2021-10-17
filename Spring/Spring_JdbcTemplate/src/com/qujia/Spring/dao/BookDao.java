package com.qujia.Spring.dao;

import com.qujia.Spring.entiy.Book;

import java.util.List;

public interface BookDao {
    void add(Book book);
    public void updateBook(Book book);
    public void deleteBook(String id);
    public int findCount();
    public Book findBook(String id);
    public List<Book> findAll();
    public void batchAdd(List<Object[]> batchArgs);
    public void batchUpdate(List<Object[]> batchArgs);
    public void batchDelete(List<Object[]> batchArgs);
}
