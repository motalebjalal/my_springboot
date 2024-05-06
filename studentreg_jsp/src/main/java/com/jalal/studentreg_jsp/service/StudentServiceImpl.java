package com.jalal.studentreg_jsp.service;

import com.jalal.studentreg_jsp.model.Student;
import com.jalal.studentreg_jsp.repository.StudentRepo;
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
    public void updateStudent(Student updateStudent) {
        Student oldStudent = new Student();
        List<Student> students = studentRepo.findAll();
        for (Student oneStudent : students) {
            if (oneStudent.getRoll() == updateStudent.getRoll()) {
                oldStudent = oneStudent;
                break;
            }
        }
        updateStudent.setRoll(oldStudent.getRoll());
        updateStudent.setDepartment(oldStudent.getDepartment());

        if (!oldStudent.getName().isEmpty()) {
            updateStudent.setName(updateStudent.getName());
        } else {
            updateStudent.setName(oldStudent.getName());
        }
        if (!oldStudent.getAge().isEmpty()) {
            updateStudent.setAge(updateStudent.getAge());

        } else {
            updateStudent.setAge(oldStudent.getAge());

        }
        studentRepo.save(updateStudent);

    }

    @Override
    public void deleteStudentByRoll(Long roll) {
        System.out.println("serviece impl: " + roll);
        studentRepo.deleteById(roll);
    }
}
