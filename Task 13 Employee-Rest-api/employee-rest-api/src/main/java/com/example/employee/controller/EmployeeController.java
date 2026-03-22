package com.example.employee.controller;

import com.example.employee.entity.Employee;
import com.example.employee.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

// @RestController = @Controller + @ResponseBody
// Automatically converts return values to JSON
// @RequestMapping sets the base URL for all endpoints
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    // Constructor injection (preferred approach)
    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    // ============================================================
    // POST /api/employees
    // Create a new employee
    // @Valid triggers validation annotations on Employee entity
    // Returns: 201 Created + saved employee JSON
    // ============================================================
    @PostMapping
    public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee employee) {
        Employee saved = service.createEmployee(employee);
        return new ResponseEntity<>(saved, HttpStatus.CREATED); // 201
    }

    // ============================================================
    // GET /api/employees/{id}
    // Get a single employee by ID
    // Returns: 200 OK + employee JSON, or 404 if not found
    // ============================================================
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable Long id) {
        return ResponseEntity.ok(service.getEmployeeById(id)); // 200
    }

    // ============================================================
    // GET /api/employees
    // Get all employees
    // Returns: 200 OK + list of employee JSON objects
    // ============================================================
    @GetMapping
    public ResponseEntity<List<Employee>> getAll() {
        return ResponseEntity.ok(service.getAllEmployees()); // 200
    }

    // ============================================================
    // PUT /api/employees/{id}
    // Update an existing employee by ID
    // @Valid triggers validation on the request body
    // Returns: 200 OK + updated employee JSON, or 404 if not found
    // ============================================================
    @PutMapping("/{id}")
    public ResponseEntity<Employee> update(
            @PathVariable Long id,
            @Valid @RequestBody Employee employee) {
        return ResponseEntity.ok(service.updateEmployee(id, employee)); // 200
    }

    // ============================================================
    // DELETE /api/employees/{id}
    // Delete an employee by ID
    // Returns: 200 OK + success message, or 404 if not found
    // ============================================================
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        service.deleteEmployee(id);
        return ResponseEntity.ok("Employee deleted successfully"); // 200
    }
}
