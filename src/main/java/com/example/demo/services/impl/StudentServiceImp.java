package com.example.demo.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepo;
import com.example.demo.service.StudentService;

import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    StudentRepo repo;

    @Override
    public Student createData(Student stu){
        return repo.save(stu);
    }

    @Override
    public List<Student> fetchRecord(){
        return repo.findAll();
    }

    public Optional<Student> fetchDataById(int id){
        return repo.findById(id);
    }
}