package com.kuang;

import com.kuang.dao.StudentMapper;
import com.kuang.pojo.Student;
import com.kuang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class TestGetStudents {
    @Test
    public void getStudents(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = mapper.getStudent();
        for (Student student : students) {
            System.out.println(
                    "学生名："+student.getName()
                        +"\t老师:"+student.getTeacher().getName()
            );
        }
    }
    @Test
    public void getStudents2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        List<Student> student2 = mapper.getStudent2();
        for (Student student : student2) {
            System.out.println(
                    "学生名："+student.getName()+
                            "\t老师："+student.getTeacher().getName()
            );
        }
    }

    @Test
    public void getStudents3(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        List<Student> student3 = mapper.getStudent3();
        for (Student student : student3) {
            System.out.println(
                    "学生名：" + student.getName()+
                            "\t老师:" +student.getTeacher().getName()
            );
        }
    }
}
