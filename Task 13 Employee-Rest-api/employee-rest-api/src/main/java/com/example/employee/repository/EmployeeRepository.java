package com.example.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.employee.entity.Employee;
import java.util.Optional;

// Extends JpaRepository<EntityClass, PrimaryKeyType>
// This automatically provides:
//   save()        → INSERT or UPDATE
//   findAll()     → SELECT * FROM employees
//   findById(id)  → SELECT * WHERE id = ?
//   deleteById()  → DELETE WHERE id = ?
//   count()       → SELECT COUNT(*)
//   existsById()  → SELECT CASE WHEN COUNT(*) > 0 ...
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Custom query method — Spring Data JPA generates SQL automatically:
    // SELECT * FROM employees WHERE email = ?
    Optional<Employee> findByEmail(String email);
}
