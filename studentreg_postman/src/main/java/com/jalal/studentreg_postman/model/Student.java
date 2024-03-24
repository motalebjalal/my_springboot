package com.jalal.studentreg_postman.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "registration")

public class Student {
    @Id
    @Min(value = 1, message = "Roll number must be greater than or equal to 1")
    @Max(value = 9, message = "Roll number must be less than or equal to 9")
    long roll;

    @NotEmpty(message = "Department must not be empty")
    String department;
    @Column(nullable = false)
    @NotEmpty(message = "Name must not be empty")
    @Pattern(regexp = "[a-zA-Z ]+", message = "Name must contain only letters from a to z and A to Z")

    String name;
    @Column(nullable = false)

    @NotBlank(message = "Age is required")
    @Pattern(regexp = "[1-9]+", message = "Age must contain only numbers from 1 to 9 and letters")
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

