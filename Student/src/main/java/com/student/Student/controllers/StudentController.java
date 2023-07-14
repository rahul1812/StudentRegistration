package com.student.Student.controllers;

import com.student.Student.dao.StudentDao;
import com.student.Student.entites.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {
    @Autowired
    private StudentDao studentDao;

    @GetMapping("/getAll")
    public ResponseEntity<List<Student>> getAllStudent() {
        List<Student> studentList = studentDao.list();
        return ResponseEntity.ok(studentList);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable int id) {
        Optional<Student> students = studentDao.get(id);
        return ResponseEntity.ok(students.get());
    }

    @PostMapping("/save")
    public ResponseEntity getStudentById(@RequestBody Student student) {
        Optional<Integer> result = studentDao.create(student);
        return (result.get() == 1) ? ResponseEntity.ok("Data added Successfully") :
                ResponseEntity.badRequest().body("Failed to delete student");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity getStudentById(@RequestBody Student student, @PathVariable int student_id) {
        Optional<Integer> result = studentDao.update(student, student_id);
        return (result.get() == 1) ? ResponseEntity.ok("Data Updated Successfully") :
                ResponseEntity.badRequest().body("Failed to delete student");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable int student_id) {
        Optional<Integer> result = studentDao.delete(student_id);
        return (result.get() == 1) ? ResponseEntity.ok("Student deleted successfully") :
                ResponseEntity.badRequest().body("Failed to delete student");
    }

}