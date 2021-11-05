package com.qujia;

import com.github.pagehelper.PageHelper;
import com.qujia.dao.StudentDao;
import com.qujia.domain.Student;
import com.qujia.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TestMybatis {
    @Test
    public void selectStudentIf(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        Student stu = new Student();
        stu.setName("张三");
        stu.setAge(10);
        List<Student> studentList = studentDao.selectStudentIf(stu);
        studentList.forEach(student1 -> {
            System.out.println(student1);
        });
        sqlSession.close();
    }
    @Test
    public void selectStudentWhere(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        Student stu = new Student();
        stu.setName("张三");
        stu.setAge(10);
        List<Student> studentList = studentDao.selectStudentWhere(stu);
        studentList.forEach(student1 -> {
            System.out.println(student1);
        });
        sqlSession.close();
    }
    @Test
    public void testfor(){
        List<Integer> list = new ArrayList<>();
        list.add(1001);
        list.add(1002);
        list.add(1003);

        //String sql="select * from student where id in (1001,1002,1003)";
        String sql="select * from student where id in";

        StringBuilder builder  = new StringBuilder("");
        int init=0;
        int len = list.size();

        //添加开始的 (
        builder.append("(");
        for(Integer i:list){
            builder.append(i).append(",");

        }
        builder.deleteCharAt(builder.length()-1);
        //循环结尾
        builder.append(")");
        sql = sql  + builder.toString();
        System.out.println("sql=="+sql);
    }
    @Test
    public void selectForeachOne(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        List<Integer> list = new ArrayList<>();
        list.add(1001);
        list.add(1002);
        list.add(1003);
        List<Student> studentList = studentDao.selectForeachOne(list);
        studentList.forEach(student1 -> {
            System.out.println(student1);
        });
        sqlSession.close();
    }
    @Test
    public void testSelectForTwo(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao  =  sqlSession.getMapper(StudentDao.class);

        List<Student> stuList  = new ArrayList<>();
        Student s1 = new Student();
        s1.setId(1002);
        s1.setName("lisi");
        stuList.add(s1);

        s1 = new Student();
        s1.setId(1005);;
        s1.setName("zs");
        stuList.add(s1);

        List<Student> students = dao.selectForeachTwo(stuList);
        for(Student stu:students){
            System.out.println("foreach--two ==="+stu);
        }
    }
    @Test
    public void selectAll(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        PageHelper.startPage(2,3);//第一个参数是第几页不是行号
        List<Student> studentList = studentDao.selectAll();
        studentList.forEach(student1 -> {
            System.out.println(student1);
        });
        sqlSession.close();
    }
}
