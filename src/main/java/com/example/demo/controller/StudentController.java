package com.example.demo.controller;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.web.bind.annotation.PostMapping;
 import org.springframework.web.bind.annotation.RequestBody;
 import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Student;
import com.example.services.StudentService;
@RestController
public class StudentController{
    @Autowired
    StudentService ser;
    @GetMapping("/adddata")
    public Student createData(@RequestBody Student stu){
        return ser.createData(stu);
    }
}