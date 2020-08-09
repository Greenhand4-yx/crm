package com.dahuang.test;

import com.dahuang.domain.Student;
import com.dahuang.service.ServiceStudent;
import com.dahuang.service.impl.ServiceStudentImpl;
import com.dahuang.utils.ServiceFactory;
import com.dahuang.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

/**
 * @author dahuang
 * @create 2020-08-08 16:25
 */
public class MyTest {

    public static void main(String[] args) {

        ServiceStudent serviceStudent = (ServiceStudent) ServiceFactory.getService(new ServiceStudentImpl());
//        ServiceStudent serviceStudent = new ServiceStudentImpl();
//        Student student = serviceStudent.queryStudentById(1004);

        Student stu = new Student();
        stu.setId(1008);
        stu.setName("xiaoxue");
        stu.setAge(19);
        serviceStudent.addStudent(stu);
        
//        SqlSession sqlSession = SqlSessionUtil.getSqlSession();


//        Student student = sqlSession.selectOne("test1.selectStudent", 1001);
//
//        System.out.println(student);
//
//        SqlSessionUtil.closeSqlSession(sqlSession);

//        int res = sqlSession.insert("test1.insertStudent", stu);
//        System.out.println(res);
//        sqlSession.commit();
//        SqlSessionUtil.closeSqlSession(sqlSession);

    }
}
