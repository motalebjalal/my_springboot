package com.jalal.studentreg.service;

import com.jalal.studentreg.model.Student;
import com.jalal.studentreg.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepo studentRepo;
    @Override
    public void saveStudent(Student student) {
        Scanner inputRoll = new Scanner(System.in);
        System.out.print("Please type your roll : ");
        int studentRoll = inputRoll.nextInt();

        Scanner inputDepartment = new Scanner(System.in);
        System.out.print("Please type your Department name : ");
        String studentDepartment = inputDepartment.nextLine();

        Scanner inputname = new Scanner(System.in);
        System.out.print("Please type your name : ");
        String studentName = inputname.nextLine();

        Scanner inputAge = new Scanner(System.in);
        System.out.print("Please type your Age : ");
        String studentAge = inputAge.nextLine();


        student.setRoll(studentRoll);
        student.setDepartment(studentDepartment);
        student.setName(studentName);
        student.setAge(studentAge);

        studentRepo.save(student);

    }


    @Override
    public List<Student> fetchStudentList() {
        List<Student> student = studentRepo.findAll();
        return  student;
    }

    @Override
    public Student findByRoll(Student student, Long roll) {
        List<Student> students = studentRepo.findAll();
        for (Student s : students) {
            if (s.getRoll() == roll) {
                student = s;
                break;
            }
        }
        return student;
    }



    @Override
    public void updateStudent(Student student, Long roll) {
        List<Student> students = studentRepo.findAll();
        for (Student s : students) {
            if (s.getRoll() == roll) {
                student = s;
                break;
            }
        }
        Scanner inputname = new Scanner(System.in);
        System.out.print("Please update your name : ");
        String studentName = inputname.nextLine();

        Scanner inputAge = new Scanner(System.in);
        System.out.print("Please update your Age :");
        String studentAge = inputAge.nextLine();


        if (!studentName.isEmpty()) {
            student.setName(studentName);

        } else {
            student.setName(student.getName());

        }

        if (!studentAge.isEmpty()) {
            student.setAge(studentAge);

        } else {
            student.setAge(student.getAge());

        }
        studentRepo.save(student);
    }
    @Override
    public void deleteStudentByRoll(Long roll) {
        studentRepo.deleteById(roll);
    }
}
