package com.qujia.Spring.factorybean;

import com.qujia.Spring.collectiontype.Course;
import org.springframework.beans.factory.FactoryBean;

public class Mybean implements FactoryBean<Course> {

    @Override
    public boolean isSingleton() {
        return FactoryBean.super.isSingleton();
    }
    //定义返回类型（bean）
    @Override
    public Course getObject() throws Exception {
        Course course = new Course();
        course.setCname("java");
        return course;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }
}
