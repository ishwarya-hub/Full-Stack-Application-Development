package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/students")
public class studentcontroller {

    @GetMapping
    public List<Map<String, Object>> getStudents() {

        List<Map<String, Object>> list = new ArrayList<>();

        Map<String, Object> s1 = new HashMap<>();
        s1.put("id", 1);
        s1.put("name", "John");

        Map<String, Object> s2 = new HashMap<>();
        s2.put("id", 2);
        s2.put("name", "Alice");

        list.add(s1);
        list.add(s2);

        return list;
    }
}