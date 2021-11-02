package com.qujia.dao;

import com.qujia.domain.Student;

import java.util.List;

public interface StudentDao {
    //查询所有student
    public List<Student> selectStudents();
    //插入
    public int insertStudent(Student student);
}
