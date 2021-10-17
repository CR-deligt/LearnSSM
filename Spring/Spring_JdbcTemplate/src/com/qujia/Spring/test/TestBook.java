package com.qujia.Spring.test;

import com.qujia.Spring.entiy.Book;
import com.qujia.Spring.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class TestBook {
    @Test
    public void testJdbcTemplate(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
//        Book book = new Book();
//        book.setUserId("1");
//        book.setUser_name("java");
//        book.setUstatus("a");
//
//        //bookService.addBook(book);
//
//        book.setUser_name("AAA");
//        book.setUstatus("b");
//        bookService.updateBook(book);

       // bookService.deleteBook("1");

//        int count = bookService.findCount();
//        System.out.println(count);
        //System.out.println(bookService.findBook("1"));
//        System.out.println(bookService.findAll());
        //-------------------批量添加-----------------------
//        List<Object[]> batchArgs = new ArrayList<>();
//        Object[] o1 ={"3","JAVA","1"};
//        Object[] o2 ={"4","C++","1"};
//        Object[] o3 ={"5","MYSQL","1"};
//        batchArgs.add(o1);
//        batchArgs.add(o2);
//        batchArgs.add(o3);
//        bookService.batchAdd(batchArgs);
        //-------------------批量修改-----------------------
//        List<Object[]> batchArgs = new ArrayList<>();
//        Object[] o1 ={"JAVA","1","5"};
//        Object[] o2 ={"C++","1","3"};
//        Object[] o3 ={"MYSQL","1","4",};
//        batchArgs.add(o1);
//        batchArgs.add(o2);
//        batchArgs.add(o3);
//        bookService.batchUpdate(batchArgs);
        //-------------------批量删除-----------------------
        List<Object[]> batchArgs = new ArrayList<>();
        Object[] o1 ={"5"};
        Object[] o2 ={"3"};
        Object[] o3 ={"4"};
        batchArgs.add(o1);
        batchArgs.add(o2);
        batchArgs.add(o3);
        bookService.batchDelete(batchArgs);
    }
}
