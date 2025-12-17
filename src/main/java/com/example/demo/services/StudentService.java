package com.example.demo.services;
import java.util.*;
import com.example.demo.entity.Student;

public interface StudentService{

    Student createData(Student stu);
    List<Student> fetchRecord();
    Optional<Student> fetchDataById(int id);
    
}