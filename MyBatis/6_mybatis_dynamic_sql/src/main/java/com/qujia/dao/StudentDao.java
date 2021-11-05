package com.qujia.dao;


import com.qujia.domain.Student;

import java.util.List;

public interface StudentDao {
    //动态sql要用java对象
    List<Student> selectStudentIf(Student student);
    List<Student> selectStudentWhere(Student student);
    //foreach 用法 1
    List<Student> selectForeachOne(List<Integer> idlist);

    //foreach 用法 2
    List<Student> selectForeachTwo(List<Student> stulist);


    //使用PageHelper分页数据
    List<Student> selectAll();
}
