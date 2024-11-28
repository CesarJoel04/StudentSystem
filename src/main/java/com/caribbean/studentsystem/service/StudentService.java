package com.caribbean.studentsystem.service;

import com.caribbean.studentsystem.model.Student;

import java.util.List;

public interface StudentService {
    public Student saveStudent(Student student);
    public List<Student> getStudents();


    List<Student> getAllStudents();
}

