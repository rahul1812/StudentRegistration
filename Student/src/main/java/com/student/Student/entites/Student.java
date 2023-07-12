package com.student.Student.entites;

public class Student {

    private int student_id;
    private String first_name;
    private String last_name;
    private int age;
    private String address;
    public Student(){}
    public Student(int student_id, String first_name, String last_name, int age, String address) {
        this.student_id = student_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.age = age;
        this.address = address;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
