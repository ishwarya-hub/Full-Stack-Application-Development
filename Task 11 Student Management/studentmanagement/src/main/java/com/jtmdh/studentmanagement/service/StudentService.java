package com.jtmdh.studentmanagement.service;
 
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import com.jtmdh.studentmanagement.entity.Student;
import com.jtmdh.studentmanagement.repository.StudentRepository;
 
@Service
public class StudentService {
 
    @Autowired
    private StudentRepository repo;
 
    // Save or Update student
    public void saveStudent(Student student) {
        repo.save(student);
    }
 
    // Get all students
    public List<Student> getAllStudents() {
        return repo.findAll();
    }
 
    // Get student by ID
    public Student getStudentById(Long id) {
        return repo.findById(id).get();
    }
 
    // Delete student by ID
    public void deleteStudent(Long id) {
        repo.deleteById(id);
    }
 
    // Custom Query - filter by Department
    public List<Student> getStudentsByDepartment(String dept) {
        return repo.findByDepartment(dept);
    }
 
    // Custom Query - filter by Age
    public List<Student> getStudentsByAge(int age) {
        return repo.findByAgeGreaterThan(age);
    }
 
    // Pagination + Sorting
    public Page<Student> getStudentsWithPagination(int pageNo, int pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        return repo.findAll(pageable);
    }
}
