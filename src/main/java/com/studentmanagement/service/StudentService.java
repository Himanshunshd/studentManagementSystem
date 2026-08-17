package com.studentmanagement.service;

import java.util.List;

import com.studentmanagement.dao.StudentDao;
import com.studentmanagement.model.Student;

public class StudentService {

      final private StudentDao daoObject = new StudentDao();      //Make the DAO object private because other classes should not access it directly.

                  public boolean addStudent(Student addingStudent){       //1-> Main.java ka same reference addingStuent me store kara and Dao ko send kara 
                         return daoObject.addStudent(addingStudent);      // and reference variable(addingStudent=student) same bhi teeno ko de salte hai.      
                  }  
                   
                  public List<Student> getAllStudents() {     
                         return daoObject.getAllStudents();
                  }
                 
                  public boolean updateStudent(Student updatingStudent){    
                         return daoObject.updateStudent(updatingStudent);            
                  }
                  public boolean studentExists(int id) {
                         return daoObject.studentExists(id);
                  }
                  public void deleteStudent(Student deletingStudent) {
                         daoObject.deleteStudent(deletingStudent);
                  }
}