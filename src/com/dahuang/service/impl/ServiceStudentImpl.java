package com.dahuang.service.impl;

import com.dahuang.dao.StudentDao;
import com.dahuang.domain.Student;
import com.dahuang.service.ServiceStudent;
import com.dahuang.utils.SqlSessionUtil;

/**
 * @author dahuang
 * @create 2020-08-08 17:07
 */
public class ServiceStudentImpl implements ServiceStudent {
    private StudentDao studentDao =SqlSessionUtil.getSqlSession().getMapper(StudentDao.class);
    @Override
    public Student queryStudentById(Integer id) {
        return studentDao.selectStudent(id);
    }

    @Override
    public int addStudent(Student student) {

        return studentDao.insertStudent(student);

    }
}
