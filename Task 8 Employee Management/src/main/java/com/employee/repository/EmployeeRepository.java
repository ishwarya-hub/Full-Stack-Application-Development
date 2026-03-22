package com.employee.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.employee.model.Employee;

/**
 * EmployeeRepository is annotated with @Component so that Spring
 * automatically detects and registers it as a bean during component scan.
 *
 * It acts as an in-memory data store (no database).
 * Employees are stored in a simple ArrayList.
 *
 * Spring Concept Demonstrated:
 *   @Component  → Spring-managed bean (auto-detected via component-scan in beans.xml)
 *   IoC         → Spring creates and manages this object, not the developer
 */
@Component
public class EmployeeRepository {

    // In-memory storage – no database involved
    private List<Employee> employeeList = new ArrayList<>();

    /**
     * Adds an Employee to the in-memory list.
     *
     * @param employee Employee object to add
     */
    public void addEmployee(Employee employee) {
        employeeList.add(employee);
        System.out.println("[Repository] Employee added: " + employee.getName());
    }

    /**
     * Returns the complete list of stored employees.
     *
     * @return List of all Employee objects
     */
    public List<Employee> getAllEmployees() {
        return employeeList;
    }
}
