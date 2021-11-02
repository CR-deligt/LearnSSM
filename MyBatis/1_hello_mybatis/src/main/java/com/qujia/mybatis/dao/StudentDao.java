package com.qujia.mybatis.dao;

import com.qujia.mybatis.domain.Student;

import java.util.List;

public interface StudentDao {
    //查询所有student
    public List<Student> selectStudents();
    //插入student
    public int insertStudent(Student student);

}
