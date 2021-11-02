package com.qujia;

import com.qujia.dao.StudentDao;
import com.qujia.domain.MyStudent;
import com.qujia.domain.Student;
import com.qujia.utils.MyBatisUtils;
import com.qujia.vo.QueryParam;
import com.qujia.vo.ViewStudent;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestMybatis {
    @Test
    public void testSelectStudentById(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);

        Student student = studentDao.selectStudentById(1001);

        System.out.println(student);
        sqlSession.close();
    }
    @Test
    public void testSelectMulitParam(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);

        List<Student> studentList = studentDao.selectMultiParam("张飞", 20);
        studentList.forEach(student -> {
            System.out.println(student);
        });
        sqlSession.close();
    }
    @Test
    public void testSelectStudentReturnViewStudent(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);

        ViewStudent viewStudent = studentDao.selectStudentReturnViewStudent(1005);

        System.out.println(viewStudent);
        sqlSession.close();
    }
    @Test
    public void testCountStudent(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);

        int c = studentDao.countStudent();

        System.out.println(c);
        sqlSession.close();
    }
    @Test
    public void testSelectMapId(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);

        Map<Object, Object> c = studentDao.selectMapId(1005);

        System.out.println(c);
        sqlSession.close();
    }
    @Test
    public void testSelectAllStudents(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);

        List<Student> studentList = studentDao.selectAllStudents();
        studentList.forEach(student -> {
            System.out.println(student);
        });
        sqlSession.close();
    }
    @Test
    public void testSelectDiffColProperty(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);

        List<MyStudent> studentList = studentDao.selectDiffColProperty();
        studentList.forEach(mystudent -> {
            System.out.println(mystudent);
        });
        sqlSession.close();
    }
    @Test
    public void testSelectLikeOne(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        String name = "%李%";
        List<Student> studentList = studentDao.selectLikeOne(name);
        studentList.forEach(student -> {
            System.out.println(student);
        });
        sqlSession.close();
    }
    @Test
    public void testSelectLikeTwo(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        String name = "李";
        List<Student> studentList = studentDao.selectLikeTwo(name);
        studentList.forEach(student -> {
            System.out.println(student);
        });
        sqlSession.close();
    }
}
