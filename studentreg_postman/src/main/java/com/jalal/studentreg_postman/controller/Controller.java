package com.jalal.studentreg_postman.controller;

import com.jalal.studentreg_postman.model.Student;
import com.jalal.studentreg_postman.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.*;

@RestController
@RequestMapping("/student")
public class Controller {
    @Autowired
    StudentService studentService;

    @GetMapping("/")
    public String home() {
        return " Welcome To Enjoy My Student Crud Operation. ";
    }


    @PostMapping("/create")
    public void createStudent(@RequestBody Student student) {
    studentService.saveStudent(student);
    }

    @GetMapping("/retrieve")
    public List<Student> studentList() {
        return studentService.fetchStudentList();
    }


    @GetMapping("/search")
    public Student findStudent(Student student, @RequestParam long roll) {
        return studentService.findByRoll(student,roll);
    }

    @PutMapping("/update")
    public void updateStudent(@RequestBody Student student, @RequestParam long roll) {
        studentService.updateStudent(student,roll);
    }

    @DeleteMapping("/delete")
    public void deleteStudent(@RequestParam long roll) {
        System.out.println("delete:controller "+ roll);
        studentService.deleteStudentByRoll(roll);
    }
}
