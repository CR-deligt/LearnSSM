package com.qujia;

import com.qujia.dao.StudentDao;
import com.qujia.dao.impl.StudentDaoImpl;
import com.qujia.domain.Student;
import org.junit.Test;

import java.util.List;

public class TestMybatis {
    @Test
    public void testSelectStudents(){
        StudentDao studentDao = new StudentDaoImpl();
        List<Student> studentList = studentDao.selectStudents();
        for(Student stu :studentList){
            System.out.println(stu);
        }
    }
    @Test
    public void testInsertStudents(){
        StudentDao studentDao = new StudentDaoImpl();
        int i = studentDao.insertStudent(new Student(1005, "关羽", "guanyu@qq.com", 18));
        System.out.println(i);
    }
}
