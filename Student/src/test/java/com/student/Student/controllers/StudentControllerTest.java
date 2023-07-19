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
import java.util.Optional;

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
        when(studentDao.list()).thenReturn(returnListOfrecord());
        ResponseEntity<List<Student>> allStudent = studentController.getAllStudent();
        List<Student> studentList = allStudent.getBody();
        System.out.println("Response  : " + allStudent.getBody());
        Assertions.assertEquals(1, studentList.size());
    }

    @Test
    public void testGetStudentById() {
        when(studentDao.get(1)).thenReturn(returnOneRecord());
        ResponseEntity<Student> allStudent = studentController.getStudentById(1);
        Student student = allStudent.getBody();
        System.out.println("Response  : " + allStudent.getBody());
        Assertions.assertEquals(1, student.getStudent_id());
        Assertions.assertEquals("ram", student.getFirst_name());
        Assertions.assertEquals("Kumar", student.getLast_name());
        Assertions.assertEquals(20, student.getAge());
        Assertions.assertEquals("Kanpur", student.getAddress());
    }

    @Test
    public void testSaveStudent() {
        Student student= returnOneRecord().get();
        when(studentDao.create(student)).thenReturn(Optional.of(1));
        ResponseEntity updateResult = studentController.saveStudent(student);
        Assertions.assertEquals(200, updateResult.getStatusCodeValue());
        Assertions.assertEquals("Data added Successfully", updateResult.getBody());
    }

    @Test
    public void testUpdateStudent() {
        Student student= returnOneRecord().get();
        when(studentDao.update(student,1)).thenReturn(Optional.of(1));
        ResponseEntity createResult = studentController.updateStudent(student,1);
        Assertions.assertEquals(200, createResult.getStatusCodeValue());
        Assertions.assertEquals("Data Updated Successfully", createResult.getBody());
    }

    @Test
    public void testDeleteStudent() {
        when(studentDao.delete(1)).thenReturn(Optional.of(1));
        ResponseEntity deleteResult = studentController.deleteStudent(1);
        Assertions.assertEquals(200, deleteResult.getStatusCodeValue());
        Assertions.assertEquals("Student deleted successfully", deleteResult.getBody());
    }


    public static List<Student> returnListOfrecord() {
        List<Student> stu = new ArrayList<Student>();
        Student student = new Student();
        student.setStudent_id(1);
        student.setFirst_name("ram");
        student.setLast_name("Kumar");
        student.setAge(20);
        student.setAddress("Kanpur");
        stu.add(student);
        return stu;
    };

    public static Optional<Student> returnOneRecord() {
        Student student = new Student();
        student.setStudent_id(1);
        student.setFirst_name("ram");
        student.setLast_name("Kumar");
        student.setAge(20);
        student.setAddress("Kanpur");
        return Optional.of(student);
    }



}
