package com.qujia.mybatis;


import com.qujia.mybatis.domain.Student;
import com.qujia.mybatis.utils.MyBatisUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyApp2 {
    public static void main(String[] args) throws IOException {

        SqlSession sqlSession = MyBatisUtils.getSqlSession();//将获取sqlSession的代码封装到工具类MyBatisUtils
        //查询全部
        String sqlId ="com.qujia.mybatis.dao.StudentDao"+"."+"selectStudents";
        List<Student> studentList = sqlSession.selectList(sqlId);
        studentList.forEach(stu-> System.out.println(stu));//用lambda表达式
//        for(Student stu :studentList){
//            System.out.println("查询的学生="+stu);
//        }


        //插入
//        String sqlId ="com.qujia.mybatis.dao.StudentDao"+"."+"insertStudent";
//        Student student = new Student(1004,"刘备","liubei@163.com",20);
//        int nums = sqlSession.insert(sqlId, student);//第二个是传参数
//
//        //默认不自动提交事务，在insert update delete后面手动提交事务
//        sqlSession.commit();

//        System.out.println("执行insert结果"+nums);
        sqlSession.close();

    }
}
