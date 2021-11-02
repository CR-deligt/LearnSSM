package com.qujia.dao;

import com.qujia.domain.MyStudent;
import com.qujia.domain.Student;
import com.qujia.vo.QueryParam;
import com.qujia.vo.ViewStudent;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StudentDao {
    public Student selectStudentById(@Param("id") Integer id);

    List<Student> selectMultiParam(@Param("myname") String name,@Param("myage") Integer age);

    ViewStudent selectStudentReturnViewStudent(@Param("id")Integer id);

    int countStudent();

    Map<Object,Object> selectMapId(@Param("id") Integer id);//只能返回一行记录  列名为key 列值是value  {name=关羽, id=1005}

    //resultMap
    List<Student> selectAllStudents();

    List<MyStudent> selectDiffColProperty();

    /*第一种模糊查询*/
    List<Student> selectLikeOne(String name);
    /*第二种*/
    List<Student> selectLikeTwo(String name);
}
