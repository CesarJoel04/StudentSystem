package com.caribbean.studentsystem.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.caribbean.studentsystem.model.Student;
import com.caribbean.studentsystem.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/student")

public class StudentController {

    private final StudentService studentService;

    // Constructor-based dependency injection
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addStudent(@RequestBody Student student) {
        // Validate student object
        if (student == null || student.getName() == null || student.getName().isEmpty()) {
            return ResponseEntity.badRequest().body("Invalid student data. Name is required.");
        }

        studentService.saveStudent(student);
        return ResponseEntity.ok("Student added successfully");
    }


    @GetMapping("/getAll")
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        if (students.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(students);
    }
}
