package com.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.employee.model.Employee;
import com.employee.repository.EmployeeRepository;

/**
 * EmployeeService is annotated with @Component so Spring auto-detects it.
 *
 * It is injected with EmployeeRepository via @Autowired (Dependency Injection).
 * Spring resolves the dependency automatically – no "new" keyword needed.
 *
 * Spring Concepts Demonstrated:
 *   @Component  → Spring-managed bean
 *   @Autowired  → Dependency Injection (Spring injects EmployeeRepository automatically)
 *   DI          → The dependency (repository) is injected by Spring, not created here
 */
@Component
public class EmployeeService {

    /**
     * Spring automatically injects the EmployeeRepository bean here.
     * This is Field-level Dependency Injection using @Autowired.
     */
    @Autowired
    private EmployeeRepository repository;

    /**
     * Business logic: Creates an Employee object and delegates to repository.
     *
     * @param id   Employee ID
     * @param name Employee Name
     * @param dept Department Name
     */
    public void createEmployee(int id, String name, String dept) {
        Employee emp = new Employee(id, name, dept);
        repository.addEmployee(emp);
    }

    /**
     * Retrieves all employees from repository and prints them to the console.
     * Output format: <id> <name> <department>
     */
    public void displayEmployees() {
        System.out.println("\n--- Employee List ---");
        for (Employee emp : repository.getAllEmployees()) {
            System.out.println(emp.getId() + " " +
                               emp.getName()       + " " +
                               emp.getDepartment());
        }
        System.out.println("---------------------\n");
    }
}
