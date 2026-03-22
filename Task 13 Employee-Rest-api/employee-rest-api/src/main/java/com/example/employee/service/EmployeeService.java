package com.example.employee.service;

import com.example.employee.entity.Employee;
import com.example.employee.repository.EmployeeRepository;
import com.example.employee.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

// @Service - Marks this class as a Spring-managed Service bean
// Contains all business logic — sits between Controller and Repository
@Service
public class EmployeeService {

    // Constructor Injection (preferred over @Autowired field injection)
    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    // =========== CREATE ===========
    // Saves new employee to database
    // SQL: INSERT INTO employees (name, email, salary, department) VALUES (?, ?, ?, ?)
    public Employee createEmployee(Employee employee) {
        return repository.save(employee);
    }

    // =========== READ ONE ===========
    // Finds employee by ID; throws ResourceNotFoundException if not found
    // SQL: SELECT * FROM employees WHERE id = ?
    public Employee getEmployeeById(Long id) {
        return repository.findById(id)
            .orElseThrow(() ->
                new ResourceNotFoundException("Employee not found with id: " + id));
    }

    // =========== READ ALL ===========
    // Returns all employees from database
    // SQL: SELECT * FROM employees
    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    // =========== UPDATE ===========
    // Updates existing employee fields; throws exception if ID not found
    // SQL: UPDATE employees SET name=?, email=?, salary=?, department=? WHERE id=?
    public Employee updateEmployee(Long id, Employee emp) {
        // First verify employee exists (throws ResourceNotFoundException if not)
        Employee existing = getEmployeeById(id);

        // Update all editable fields
        existing.setName(emp.getName());
        existing.setEmail(emp.getEmail());
        existing.setSalary(emp.getSalary());
        existing.setDepartment(emp.getDepartment());

        // Save returns the updated record
        return repository.save(existing);
    }

    // =========== DELETE ===========
    // Deletes employee by ID; throws exception if ID not found
    // SQL: DELETE FROM employees WHERE id = ?
    public void deleteEmployee(Long id) {
        Employee emp = getEmployeeById(id); // throws if not found
        repository.delete(emp);
    }
}
