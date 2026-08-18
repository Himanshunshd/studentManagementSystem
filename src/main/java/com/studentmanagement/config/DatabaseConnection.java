package com.studentmanagement.config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

   final private static String URL = "jdbc:mysql://localhost:3306/student_management";      // When a variable is final and initialized with a fixed value, Java naming conventions recommend UPPER_CASE names for constants.
   final private static String ROOT = "root";
   final private static String PASSWORD = "your_password";       // Add your MySQL password .

    public static Connection getConnection(){                  //static is useful because we don't need to create a new DatabaseConnection object every time.
           try{     
                Connection con = DriverManager.getConnection(URL, ROOT, PASSWORD);
                // System.out.println("Database Connected");
                // System.out.println();
                return con ;

           } catch(SQLException e){
                   System.out.println("Database is not Connected"); 
                   e.printStackTrace();                                 // Warning is --- printStackTrace() prints the exception directly to the console. In real applications, developers usually use a logging framework such as Log4j, java.util.logging EX- logger.error("Database connection failed", e);
           }
                   return null ;                                        // if the try block fails,the method still needs to return a Connection value.
}
}