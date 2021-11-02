package com.qujia;

import com.qujia.dao.StudentDao;
import com.qujia.domain.Student;
import com.qujia.utils.MyBatisUtils;
import com.qujia.vo.QueryParam;
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
    public void testSelectMulitObject(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        QueryParam queryParam = new QueryParam("张飞", 20);
        List<Student> studentList = studentDao.selectMultiObject(queryParam);
        studentList.forEach(student -> {
            System.out.println(student);
        });
        sqlSession.close();
    }
    public void testSelectMulitStudent(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        Student student = new Student(1002, "张飞", "123", 20);
        List<Student> studentList = studentDao.selectMultiStudent(student);
        studentList.forEach(stu -> {
            System.out.println(stu);
        });
        sqlSession.close();
    }
    public void testSelectMultiPosition(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        List<Student> studentList = studentDao.selectMultiPosition("张飞",20);
        studentList.forEach(stu -> {
            System.out.println(stu);
        });
        sqlSession.close();
    }
    public void testSelectMultiByMap(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);

        Map<String,Object> map=new HashMap<>();
        map.put("myname","张三");
        map.put("age",20);

        List<Student> studentList = studentDao.selectMultiByMap(map);
        studentList.forEach(stu -> {
            System.out.println(stu);
        });
        sqlSession.close();
    }
    @Test
    public void testSelectBy$(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);

        Student student = studentDao.selectBy$("'李四'");

        System.out.println(student);
        sqlSession.close();
    }
    @Test
    public void testSelectUse$Order(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);

        List<Student> studentList = studentDao.selectUse$Order("name");

        studentList.forEach(stu -> {
            System.out.println(stu);
        });;
    }
}
