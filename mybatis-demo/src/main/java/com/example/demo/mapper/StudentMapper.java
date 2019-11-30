package com.example.demo.mapper;

import com.example.demo.entity.Student;

import java.util.List;

/**
 * @author jingzhidematong
 * @date 2019/11/29
 */
public interface StudentMapper {

    int add(Student student);

    int update(Student student);

    int delete(Integer id);

    Student findById(Integer id);

    List<Student> find();

    Student findStudentWithAddress(Integer id);

    Student findByGradeId(Integer gradeId);

}
