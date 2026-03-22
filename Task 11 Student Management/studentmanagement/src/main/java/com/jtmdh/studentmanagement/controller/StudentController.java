package com.jtmdh.studentmanagement.controller;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.jtmdh.studentmanagement.entity.Student;
import com.jtmdh.studentmanagement.service.StudentService;
 
@Controller
public class StudentController {
 
    @Autowired
    private StudentService service;
 
    // HOME PAGE - load first page sorted by name
    @GetMapping("/")
    public String viewHomePage(Model model) {
        return findPaginated(0, "name", model);
    }
 
    // SHOW ADD FORM
    @GetMapping("/showNewStudentForm")
    public String showNewStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "new_student";
    }
 
    // SAVE STUDENT (Create + Update both use this)
    @PostMapping("/saveStudent")
    public String saveStudent(@ModelAttribute("student") Student student) {
        service.saveStudent(student);
        return "redirect:/";
    }
 
    // SHOW EDIT FORM
    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable Long id, Model model) {
        model.addAttribute("student", service.getStudentById(id));
        return "update_student";
    }
 
    // DELETE STUDENT
    @GetMapping("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable Long id) {
        service.deleteStudent(id);
        return "redirect:/";
    }
 
    // SEARCH BY DEPARTMENT
    @GetMapping("/searchByDepartment")
    public String searchByDepartment(@RequestParam String department, Model model) {
        model.addAttribute("studentList", service.getStudentsByDepartment(department));
        return "index";
    }
 
    // SEARCH BY AGE
    @GetMapping("/searchByAge")
    public String searchByAge(@RequestParam int age, Model model) {
        model.addAttribute("studentList", service.getStudentsByAge(age));
        return "index";
    }
 
    // PAGINATION + SORTING
    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable int pageNo,
                               @RequestParam(defaultValue = "name") String sortField,
                               Model model) {
        int pageSize = 5;
        Page<Student> page = service.getStudentsWithPagination(pageNo, pageSize, sortField);
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("studentList", page.getContent());
        model.addAttribute("sortField", sortField);
        return "index";
    }
}
