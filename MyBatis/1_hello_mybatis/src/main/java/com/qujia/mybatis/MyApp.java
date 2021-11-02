package com.qujia.mybatis;


import com.qujia.mybatis.domain.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyApp {
    public static void main(String[] args) throws IOException {
        //访问mybatis读取数据
        String config="mybatis.xml";
        InputStream in = Resources.getResourceAsStream(config);
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        SqlSession sqlSession = factory.openSession();
        //查询全部
//        String sqlId ="com.qujia.mybatis.dao.StudentDao"+"."+"selectStudents";
//        List<Student> studentList = sqlSession.selectList(sqlId);
//        for(Student stu :studentList){
//            System.out.println("查询的学生="+stu);
//        }
        //插入
        String sqlId ="com.qujia.mybatis.dao.StudentDao"+"."+"insertStudent";
        Student student = new Student(1004,"刘备","liubei@163.com",20);
        int nums = sqlSession.insert(sqlId, student);//第二个是传参数

        //默认不自动提交事务，在insert update delete后面手动提交事务
        sqlSession.commit();

        System.out.println("执行insert结果"+nums);
        sqlSession.close();

    }
}
