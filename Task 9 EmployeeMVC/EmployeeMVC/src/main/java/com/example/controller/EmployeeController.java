package com.example.controller;

import com.example.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmployeeController {

    @GetMapping("/employee")
    public String getEmployee(Model model) {

        // Create employee object
        Employee emp = new Employee(101, "Arun", "IT");

        // Add to Model so JSP can access it
        model.addAttribute("employee", emp);

        // Return view name → /WEB-INF/views/employee.jsp
        return "employee";
    }
}
