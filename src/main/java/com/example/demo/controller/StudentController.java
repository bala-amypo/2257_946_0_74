package com.example.demo.controller;
@RestController
public class StudentController{
    @Autowired
    StudentService ser;
    @GetMapping("/adddata")
    public Student createData(@RequestBody Student stu){
        return ser.createData(stu);
    }
}