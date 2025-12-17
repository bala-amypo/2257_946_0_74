package com.example.demo.services;
import java.util.List;
import com.example.demo.entity.Student;
@Service
public interface StudentService{
    Student createData(Student stu);
    List<Student>fetchRecord();
} 