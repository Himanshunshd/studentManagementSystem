package com.studentmanagement.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.studentmanagement.config.DatabaseConnection;
import com.studentmanagement.model.Student;

public class StudentDao {

       public boolean addStudent(Student addingStudent) {                   
              Connection con = DatabaseConnection.getConnection();          // The DAO needs a connection to execute SQL.
              String sql = "INSERT INTO students (name, age, email, gender, date_of_birth, course) VALUES (?, ?, ?, ?, ?, ?)";

            try {
              PreparedStatement ps = con.prepareStatement(sql);               // Hey database connection, take this SQL query, prepare it,and give me a   
                                                                        // PreparedStatement object that I can use to insert the actual values.
                                                          
                ps.setString(1, addingStudent.getName() );               // DAO reads values from the Student object like ---->"Put the student’s name into the first ? placeholder of the SQL query."
                ps.setInt(2, addingStudent.getAge() );
                ps.setString(3, addingStudent.getEmail() );
                ps.setString(4, addingStudent.getGender() );
                ps.setDate(5, Date.valueOf(addingStudent.getDateOfBirth() ) );
                ps.setString(6, addingStudent.getCourse());

                int rowsAffected = ps.executeUpdate();
                return rowsAffected > 0;      //1-> Main and Service ka reference Dao ko diya and after process ---> let 1 > 0, so DAO return True AND service receive it AND service return in Main.java and if true toh print kara "Student added successfully!".

               } catch (SQLException e) {
                       e.printStackTrace();
                       return false;
               }
  }
                                                                                               
 public List<Student> getAllStudents() {        //Function for show student's data, will return a List containing Student objects.
                                           
              List<Student> studentList = new ArrayList<>();

              String sql = "SELECT * FROM students";
              Connection con = DatabaseConnection.getConnection(); // Because every DAO method currently needs a Connection object to communicate with MySQL.
                                                          
    try {
              PreparedStatement ps = con.prepareStatement(sql);
              ResultSet rs = ps.executeQuery();

      while (rs.next()) {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        int age = rs.getInt("age");
        String email = rs.getString("email");
        String gender = rs.getString("gender");
        LocalDate dateOfBirth = rs.getDate("date_of_birth").toLocalDate();
        String course = rs.getString("course");

        Student student = new Student(id, name, age, email, gender, dateOfBirth, course);
                                                                                           
        studentList.add(student);     // Put this Student object into the list.
      }

       } catch (SQLException e) {
            System.out.println("connection lost");
            e.printStackTrace();
          }
            return studentList; // returns the complete list:- [Student1, Student2, Student3] etc.
  }

public boolean updateStudent(Student updatingStudent) {         //Function for Update student's data. 

                Connection con = DatabaseConnection.getConnection();
                String sql = "UPDATE students SET name = ?, age = ?, email = ?, gender = ?, date_of_birth = ?, course = ? WHERE id = ?";
            try {
                PreparedStatement ps = con.prepareStatement(sql);

                    ps.setString(1, updatingStudent.getName());    //"Get the name from the student object and set it as the value of the first ? in the SQL query."
                    ps.setInt(2, updatingStudent.getAge());
                    ps.setString(3, updatingStudent.getEmail());
                    ps.setString(4, updatingStudent.getGender());
                    ps.setDate(5, Date.valueOf(updatingStudent.getDateOfBirth()));
                    ps.setString(6, updatingStudent.getCourse());
                    ps.setInt(7, updatingStudent.getId());

                    int rowsAffected = ps.executeUpdate(); 
                    return rowsAffected > 0;

              } catch (SQLException e) {
                     e.printStackTrace();
                     return false;         //Imagine an exception happens. The execution goes into catch, prints the error, and then reaches the end of the method. Since the method must return a boolean, Java asks: “What should I return here?”
             }
}

public boolean studentExists(int id) {

          Connection con = DatabaseConnection.getConnection();
          String sql = "SELECT id FROM students WHERE id = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            return rs.next();

        } catch (SQLException e) {
              e.printStackTrace();
              return false;
        }
    }

public void deleteStudent(Student deletingStudent) {

             Connection con = DatabaseConnection.getConnection();
             String sql = "DELETE FROM students WHERE id = ?";

    try {
             PreparedStatement ps = con.prepareStatement(sql);

             ps.setInt(1, deletingStudent.getId() );      // it means: 1 → first ? and id → the value to put into that ?
 
             int rowsAffected = ps.executeUpdate();
             if (rowsAffected > 0) {
                 System.out.println("Student deleted successfully");
             } else {
                 System.out.println("Student not found");
             }

     } catch (SQLException e) {
               System.out.println("Connection lost");
               e.printStackTrace();
        }
}
}