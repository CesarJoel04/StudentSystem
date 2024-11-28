package com.caribbean.studentsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.caribbean.studentsystem.model.Student;
import com.caribbean.studentsystem.service.StudentService;

import java.util.List;


@RestController
@RequestMapping("/student")

public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/add")
    public String add(@RequestBody Student student) {
        studentService.saveStudent(student);
        return "Student added successfully";
    }

    @GetMapping("/getAll")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }
}
