package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @GetMapping
    public List<Map<String, Object>> getCourses() {

        List<Map<String, Object>> list = new ArrayList<>();

        Map<String, Object> c1 = new HashMap<>();
        c1.put("id", 1);
        c1.put("courseName", "Microservices");

        Map<String, Object> c2 = new HashMap<>();
        c2.put("id", 2);
        c2.put("courseName", "Cloud Computing");

        list.add(c1);
        list.add(c2);

        return list;
    }
}