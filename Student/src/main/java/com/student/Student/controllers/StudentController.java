package com.student.Student.controllers;



import com.student.Student.dao.StudentDao;
import com.student.Student.dao.StudentDaoImpl;
import com.student.Student.entites.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
   private StudentDao studentDao;
    @GetMapping("/getAll")
    public List<Student> getAllStudent() {
        return studentDao.list();
    }
}
