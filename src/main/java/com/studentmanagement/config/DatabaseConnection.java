package com.studentmanagement.config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

   private static String url = "jdbc:mysql://localhost:3306/student_management";
   private static String root = "root";
   private static String password = "##mySql";

    public static Connection getConnection(){     //static is useful because we don't need to create a new DatabaseConnection object every time.
    try{     
       Connection con = DriverManager.getConnection(url, root, password);
          System.out.println("database connected");
          return con ;

      } catch(SQLException e){
          System.out.println("database is not connected"); 
          e.printStackTrace();
         }
          return null ;  //if the try block fails,the method still needs to return a Connection value.
}
}     //application starts from Main.java.So keep DatabaseConnection.java as the connection utility, and test it from Main.java.
 