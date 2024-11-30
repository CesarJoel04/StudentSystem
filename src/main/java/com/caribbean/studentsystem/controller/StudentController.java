package com.caribbean.studentsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.caribbean.studentsystem.model.Student;
import com.caribbean.studentsystem.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/student")
@CrossOrigin

public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/add")
    public String add(@RequestBody Student student){
        studentService.saveStudent(student);
        return "New student is added";
    }

    @GetMapping("/getAll")
    public List<Student> list(){
        return studentService.getAllStudents();
    }

    @PutMapping("/update/{id}")
    public String update(@PathVariable int id, @RequestBody Student student){
        studentService.updateStudent(id, student);
        return "Student record updated";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        studentService.deleteStudent(id);
        return "Student record deleted";
    }
}

