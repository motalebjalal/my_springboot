package com.jalal.studentreg.controller;

import com.jalal.studentreg.model.Student;
import com.jalal.studentreg.repository.StudentRepo;
import com.jalal.studentreg.service.StudentService;
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


    @GetMapping("/create")
    public void createStudent(Student student) {
    studentService.saveStudent(student);
    }

    @GetMapping("/retrieve")
    @ResponseBody
    public List<Student> studentList() {
        return studentService.fetchStudentList();
    }


    @GetMapping("/search")
    @ResponseBody
    public Student findStudent(Student student, @RequestParam long roll) {
        return studentService.findByRoll(student,roll);
    }

    @GetMapping("/update")
    @ResponseBody
    public void updateStudent(Student student, @RequestParam long roll) {
        studentService.updateStudent(student,roll);
    }

    @GetMapping("/delete")
    @ResponseBody
    public void deleteStudent(@RequestParam long roll) {
        studentService.deleteStudentByRoll(roll);
    }
}

