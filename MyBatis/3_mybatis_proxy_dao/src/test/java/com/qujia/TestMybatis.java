package com.qujia;

import com.qujia.dao.StudentDao;
import com.qujia.domain.Student;
import com.qujia.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class TestMybatis {
    @Test
    public void testSelectStudents(){
        //使用mybatis动态代理机制
        //getMapper
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        System.out.println(studentDao.getClass().getName());//jdk.proxy2.$Proxy4  JDK的动态代理
        //调用dao方法执行数据库操作
        List<Student> studentList = studentDao.selectStudents();
        for(Student stu :studentList){
            System.out.println(stu);
        }
    }
    @Test
    public void testInsertStudents(){
        SqlSession sqlSession =MyBatisUtils.getSqlSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        int i = studentDao.insertStudent(new Student(1006, "曹操", "caocoa@163.com", 20));
        sqlSession.commit();
        sqlSession.close();
        System.out.println(i);
    }
}
