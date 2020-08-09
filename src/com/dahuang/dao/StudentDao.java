package com.dahuang.dao;

import com.dahuang.domain.Student;

/**
 * @author dahuang
 * @create 2020-08-08 17:11
 */
public interface StudentDao {
    public Student selectStudent(Integer id);
    public int insertStudent(Student student);
}
