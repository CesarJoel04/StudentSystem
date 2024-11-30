package com.caribbean.studentsystem.service;

import com.caribbean.studentsystem.model.Student;
import com.caribbean.studentsystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student saveStudent(Student student) {
        studentRepository.save(student);
        return student;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public void updateStudent(int id, Student student) {
        Student existingStudent = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
        existingStudent.setName(student.getName());
        existingStudent.setAddress(student.getAddress());
        studentRepository.save(existingStudent);
    }

    public void deleteStudent(int id) {
        studentRepository.deleteById(id);
    }
}