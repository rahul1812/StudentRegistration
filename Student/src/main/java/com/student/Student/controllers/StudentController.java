package com.student.Student.controllers;



import com.student.Student.dao.StudentDao;
import com.student.Student.dao.StudentDaoImpl;
import com.student.Student.entites.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {
    @Autowired
   private StudentDao studentDao;
    @GetMapping("/")
    public ResponseEntity<List<Student>> getAllStudent() {
        List<Student> studentList = studentDao.list();
        return ResponseEntity.ok(studentList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable int id) {
        Optional<Student> students = studentDao.get(id);
        return ResponseEntity.ok(students.get());
    }


}
