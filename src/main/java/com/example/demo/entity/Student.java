package com.example.demo.entity;
public class Student{
    private Long id;
    private String name;
    private String email;
    private float cgpa;

   public Long getId(){
    return id;
   }
   public void setId(){
    this.id=id;
   }
   public String getName(){
    return name;
   }
   public void setName(){
    this.name=name;
   }
   public String getEmail(){
    return email;
   }
   public void setEmail(){
    this.email=email;
   }
   public float getCgpa(){
      return cgpa;
   }
   public float setCgpa(){
    this.cgpa=cgpa;
   }
}