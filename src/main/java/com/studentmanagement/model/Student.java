package com.studentmanagement.model;

import java.time.LocalDate;

public class Student {
    private int id;
    private String name;
    private int age;
    private String email; 
    private String gender;
    private LocalDate dateOfBirth;
    private String course;

    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public String getEmail(){
        return email ;
    }
    public String getGender(){
        return gender;
    }
    public LocalDate getDateOfBirth(){
        return dateOfBirth ;
    }
     public String getCourse(){
        return course;
    }

    public void setId(int id){
         this.id = id ;
    }
    public void setName(String name){
         this.name = name ;
    }
    public void setAge(int age){
         this.age = age ;
    }
    public void setEmail(String email){
         this.email = email ;
    }
    public void setGender(String gender){
         this.gender = gender ;
    }
    public void setDateOfBirth(LocalDate dateOfBirth){
         this.dateOfBirth = dateOfBirth ;
    }
    public void setCourse(String course){
         this.course = course ;
    }
 
    public Student(int id, String name, int age, String email, String gender, LocalDate dateOfBirth, String course){   //constructor
        this.id = id ;
        this.name = name;
        this.age = age;
        this.email = email;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.course = course ;
    }

    public Student(){   //empty constructor.
         
                    }
         
    }
