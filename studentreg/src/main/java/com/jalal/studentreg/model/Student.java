package com.jalal.studentreg.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "registration")

public class Student {
    @Id
    long roll;
    String department;
    String name;
    String age;

    public Student() {
    }

    public Student(long roll, String department, String name, String age) {
        this.roll = roll;
        this.department = department;
        this.name = name;
        this.age = age;
    }

    public long getRoll() {
        return roll;
    }

    public void setRoll(long roll) {
        this.roll = roll;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
