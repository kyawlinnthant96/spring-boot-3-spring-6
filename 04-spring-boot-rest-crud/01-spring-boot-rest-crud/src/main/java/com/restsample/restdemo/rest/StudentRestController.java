package com.restsample.restdemo.rest;

import com.restsample.restdemo.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    

    @GetMapping("/students")
    public List<Student> getStudents() {
        return null;
    }
}
