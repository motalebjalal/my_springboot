package com.jalal.studentreg_jsp.controller;



import com.jalal.studentreg_jsp.model.Student;
import com.jalal.studentreg_jsp.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import java.util.*;

//@RestController
//@RequestMapping("/student")
@Controller
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping({ "/","/index"})
    public String regForm(Model model) {
        model.addAttribute("student", new Student());
        return "index";
    }
    @PostMapping("/create")
    public String createStudent(@ModelAttribute @Valid Student student, BindingResult result) {
        if (result.hasErrors()) {
            return "/index";
        }
    studentService.saveStudent(student);
        System.out.println("create page : data save");
        return "redirect:/index";
    }

    @GetMapping("/retrieve")
    public String studentList(ModelMap map) {
        List<Student> students = studentService.fetchStudentList();
        students.sort(Comparator.comparingLong(Student::getRoll));
        map.addAttribute("showStudents", students);
        //map.addObject("showStudents", students);

        return "retrieve";
    }


    @GetMapping("/search")
    public Model findStudent(Student student, @RequestParam long roll, Model model) {
        model.addAttribute("oneStudent", studentService.findByRoll(student,roll));
        return model;
    }

    @GetMapping("/editinfo")
    public Model editInfo(Student student, @RequestParam long roll, Model model) {
        System.out.println("Edit form page open");
        model.addAttribute("mydata", studentService.findByRoll(student,roll));
        return model;
    }

    @PostMapping("/update")
    public String updateStudent(@Valid Student student) {
       // List<Student> students = studentService.updateStudent(student,roll);
       // studentService.updateStudent(student,roll);
       studentService.updateStudent(student);
    return "redirect:/retrieve";
    }

    @GetMapping("/delete")
    public String deleteStudent(@RequestParam long roll) {
        System.out.println("delete:controller "+ roll);
        studentService.deleteStudentByRoll(roll);
        return "redirect:/retrieve";
    }
}
