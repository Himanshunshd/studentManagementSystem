package com.studentmanagement.service;

import java.util.List;

import com.studentmanagement.dao.StudentDao;
import com.studentmanagement.model.Student;

public class StudentService {

      private StudentDao daoObject = new StudentDao();      //Make the DAO object private because other classes should not access it directly.

                  public boolean addStudent(Student addingStudent){      
                         return daoObject.addStudent(addingStudent);            
                  }  
                  
                  public List<Student> getAllStudents() {       
                        return daoObject.getAllStudents();
                 } 
                 
                 public void updateStudent(Student updatingStudent){      //updateStudent --- Function name, updatingStudent --- parameter.
                         daoObject.updateStudent(updatingStudent);            
                  }

                  public void deleteStudent(int id) {
                         daoObject.deleteStudent(id);
}
}