package com.dahuang.service;

import com.dahuang.domain.Student;

/**
 * @author dahuang
 * @create 2020-08-08 16:35
 */
public interface ServiceStudent {
    /**
     * 查找学生
     * @param id
     * @return
     */
    public Student queryStudentById(Integer id);

    public int addStudent(Student student);
}
