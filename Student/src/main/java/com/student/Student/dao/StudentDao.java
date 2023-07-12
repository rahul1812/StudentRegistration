package com.student.Student.dao;

import com.student.Student.entites.Student;

import java.util.List;
import java.util.Optional;

public interface StudentDao {

    List<Student> list();
    Optional<Integer> create(Student student);

    Optional<Integer> update(Student student, int id);

    Optional<Integer> delete(int id);
    Optional get(int id);
}
