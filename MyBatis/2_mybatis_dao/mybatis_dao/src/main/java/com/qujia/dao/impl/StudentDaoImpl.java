package com.qujia.dao.impl;

import com.qujia.dao.StudentDao;
import com.qujia.domain.Student;
import com.qujia.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class StudentDaoImpl implements StudentDao {
    @Override
    public List<Student> selectStudents() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        String sqlId="com.qujia.dao.StudentDao.selectStudents";
        List<Student> studentList = sqlSession.selectList(sqlId);
        sqlSession.close();
        return studentList;
    }

    @Override
    public int insertStudent(Student student) {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        String sqlId="com.qujia.dao.StudentDao.insertStudent";
        int insert = sqlSession.insert(sqlId, student);
        sqlSession.commit();
        sqlSession.close();
        return insert;
    }
}
