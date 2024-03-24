package com.jalal.studentreg_postman.service;

import com.jalal.studentreg_postman.model.Student;
import com.jalal.studentreg_postman.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepo studentRepo;

    @Override
    public void saveStudent(Student student) {
        student.setRoll(student.getRoll());
        student.setDepartment(student.getDepartment());
        student.setName(student.getName());
        student.setAge(student.getAge());

        studentRepo.save(student);

    }


    @Override
    public List<Student> fetchStudentList() {
        return studentRepo.findAll();
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
        Student oldStudent = new Student();

        List<Student> students = studentRepo.findAll();
        for (Student s : students) {
            if (s.getRoll() == roll) {
                oldStudent = s;
                break;
            }
        }

        student.setRoll(oldStudent.getRoll());
        student.setDepartment(oldStudent.getDepartment());

        if (!oldStudent.getName().isEmpty()) {
            student.setName(student.getName());
        } else {
            student.setName(oldStudent.getName());
        }

        if (oldStudent.getAge().isEmpty()) {
            student.setAge(student.getAge());

        } else {
            student.setAge(oldStudent.getAge());

        }
        studentRepo.save(student);
    }

    @Override
    public void deleteStudentByRoll(Long roll) {
        System.out.println("serviece impl: " + roll);
        studentRepo.deleteById(roll);
    }
}
