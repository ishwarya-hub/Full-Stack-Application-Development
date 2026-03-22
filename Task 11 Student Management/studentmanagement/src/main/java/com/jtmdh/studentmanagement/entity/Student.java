package com.jtmdh.studentmanagement.entity;
 
import jakarta.persistence.*;
 
@Entity
@Table(name = "students")
public class Student {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
 
    private String name;
    private String department;
    private int age;
    private double marks;
 
    // Default Constructor (required by JPA)
    public Student() {}
 
    // Parameterized Constructor
    public Student(String name, String department, int age, double marks) {
        this.name = name;
        this.department = department;
        this.age = age;
        this.marks = marks;
    }
 
    // Getters
    public Long getId()           { return id; }
    public String getName()       { return name; }
    public String getDepartment() { return department; }
    public int getAge()           { return age; }
    public double getMarks()      { return marks; }
 
    // Setters
    public void setName(String name)           { this.name = name; }
    public void setDepartment(String dept)     { this.department = dept; }
    public void setAge(int age)                { this.age = age; }
    public void setMarks(double marks)         { this.marks = marks; }
}
