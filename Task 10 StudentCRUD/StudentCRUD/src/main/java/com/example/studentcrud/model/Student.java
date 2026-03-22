package com.example.studentcrud.model;

import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String department;

    // Default constructor (required by JPA)
    public Student() {}

    // Getters
    public int getId()            { return id; }
    public String getName()       { return name; }
    public String getDepartment() { return department; }

    // Setters
    public void setId(int id)              { this.id = id; }
    public void setName(String name)       { this.name = name; }
    public void setDepartment(String dept) { this.department = dept; }
}
