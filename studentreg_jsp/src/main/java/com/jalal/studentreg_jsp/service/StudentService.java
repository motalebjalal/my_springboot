package com.jalal.studentreg_jsp.service;

import com.jalal.studentreg_jsp.model.Student;

import java.util.List;

public interface StudentService {

    // Save Student
    void saveStudent(Student student);

    // Retrieve Student
    List<Student> fetchStudentList();

    // Find Student
    Student findByRoll(Student student, Long roll);

    // Update Student
    void updateStudent(Student student);

    // Delete Student
    void deleteStudentByRoll(Long roll);

}
