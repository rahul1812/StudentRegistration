package com.student.Student.dao;

import com.student.Student.entites.Student;

import java.util.List;
import java.util.Optional;

public interface StudentDao {

    List<Student> list();
    void create(Student student);

    void update(Student student, int id);

    void delete(int id);
    Optional get(int id);
}
