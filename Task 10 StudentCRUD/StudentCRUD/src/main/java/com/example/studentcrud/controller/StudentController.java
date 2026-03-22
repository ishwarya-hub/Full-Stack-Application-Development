package com.example.studentcrud.controller;

import com.example.studentcrud.model.Student;
import com.example.studentcrud.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentRepository repository;

    // CREATE — POST /students
    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return repository.save(student);
    }

    // READ ALL — GET /students
    @GetMapping
    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    // READ ONE — GET /students/{id}
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable int id) {
        return repository.findById(id).orElse(null);
    }

    // UPDATE — PUT /students/{id}
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable int id,
                                 @RequestBody Student updatedStudent) {
        updatedStudent.setId(id);
        return repository.save(updatedStudent);
    }

    // DELETE — DELETE /students/{id}
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable int id) {
        repository.deleteById(id);
        return "Student deleted successfully";
    }
}
