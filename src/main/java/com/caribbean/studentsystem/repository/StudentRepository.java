package com.caribbean.studentsystem.repository;

import com.caribbean.studentsystem.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentRepository extends JpaRepository<Student, Integer> {
}
