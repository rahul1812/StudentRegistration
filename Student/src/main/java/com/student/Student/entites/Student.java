package com.student.Student.entites;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.management.ConstructorParameters;


@Setter
@Getter
@NoArgsConstructor
public class Student {

    private int student_id;
    private String first_name;
    private String last_name;
    private int age;
    private String address;

    public Student(int student_id, String first_name, String last_name, int age, String address) {
        this.student_id = student_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.age = age;
        this.address = address;
    }
}