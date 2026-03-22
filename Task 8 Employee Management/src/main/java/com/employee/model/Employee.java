package com.employee.model;

/**
 * Employee Model class representing the Employee entity.
 * Contains id, name, and department fields with a parameterized constructor.
 * This is a plain Java object (POJO) - Spring does NOT manage this as a bean
 * because new instances are created manually in EmployeeService.
 */
public class Employee {

    private int id;
    private String name;
    private String department;

    // Parameterized constructor
    public Employee(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    // Getters
    public int getId()            { return id; }
    public String getName()       { return name; }
    public String getDepartment() { return department; }
}
