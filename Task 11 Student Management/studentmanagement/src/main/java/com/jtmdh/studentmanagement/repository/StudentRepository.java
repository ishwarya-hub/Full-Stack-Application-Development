package com.jtmdh.studentmanagement.repository;
 
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.jtmdh.studentmanagement.entity.Student;
 
public interface StudentRepository extends JpaRepository<Student, Long> {
 
    // Custom Query 1: Find students by department
    // Auto generates: SELECT * FROM students WHERE department = ?
    List<Student> findByDepartment(String department);
 
    // Custom Query 2: Find students with age greater than value
    // Auto generates: SELECT * FROM students WHERE age > ?
    List<Student> findByAgeGreaterThan(int age);
}
