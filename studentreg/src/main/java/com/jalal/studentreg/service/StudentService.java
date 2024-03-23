package com.jalal.studentreg.service;

import com.jalal.studentreg.model.Student;

import java.util.List;

public interface StudentService {

    // Save Student
    void saveStudent(Student student);

    // Retrieve Student
    List<Student> fetchStudentList();

    // Find Student
    Student findByRoll(Student student, Long roll);

    // Update Student
    void updateStudent(Student student, Long roll);

    // Delete Student
    void deleteStudentByRoll(Long roll);

}
