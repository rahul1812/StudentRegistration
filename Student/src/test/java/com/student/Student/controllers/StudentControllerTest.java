package com.student.Student.controllers;

import com.student.Student.dao.StudentDao;
import com.student.Student.entites.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;


@ContextConfiguration(classes = {StudentController.class})
@ExtendWith(SpringExtension.class)
public class StudentControllerTest {

    @MockBean
    private JdbcTemplate jdbcTemplate;
    @MockBean
    private StudentDao studentDao;
    @Autowired
    private StudentController studentController;

    @Test
    public void testList() {
        when(studentDao.list()).thenReturn(returnData());
        ResponseEntity<List<Student>> allStudent = studentController.getAllStudent();
        List<Student> studentList = allStudent.getBody();
        System.out.println("Response  : " + allStudent.getBody());
        Assertions.assertEquals(1, studentList.size());
    }

    public static List<Student> returnData() {
        List<Student> stu = new ArrayList<Student>();
        Student student = new Student();
        student.setStudent_id(1);
        student.setFirst_name("ram");
        student.setLast_name("Kumar");
        student.setAge(20);
        student.setAddress("Kanpur");
        stu.add(student);
        return stu;
    }

    ;
}
