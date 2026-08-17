package com.studentmanagement.app;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.studentmanagement.model.Student;
import com.studentmanagement.service.StudentService;

    public class Main {

           public static void showMenu(){

                 System.out.println("1. Add Student");
                 System.out.println("2. View All Students");
                 System.out.println("3. Update Student");
                 System.out.println("4. Delete Student");
                 System.out.println("5. Exit");
                 System.out.println();
        }

    public static void addStudentMenu(Scanner sc, StudentService service) {
                  Student student = new Student();     //"student" naam ka object hai.
                  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy"); 

                  while (true) {
                         System.out.print("Enter student name: ");
                         String name = sc.nextLine();
                  if (name.matches("[A-Za-z ]+") ) {
                         student.setName(name);
                         break;
                  } else {
                         System.out.println("Invalid name.");
                  }
                  }

                  while (true) {
                  try {         // If String input given, it throws InputMismatchException so use try{}.
                        System.out.print("Enter age (between 1 and 120): ");
                        int age = sc.nextInt();
                        sc.nextLine();   // consume newline

                  if (age >= 1 && age <= 120) {
                       student.setAge(age);
                       break;
                } else {
                       System.out.println("Invalid age. Please enter age between 1 and 120.");
                }

                } catch (InputMismatchException e) {
                      System.out.println("Invalid input. Please enter numbers only.");
                      sc.nextLine();   // clear the invalid input
            }
        }

        while (true) {
            System.out.print("Enter email: ");
            String email = sc.nextLine();

            if (email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
                student.setEmail(email);
                break;
            } else {
                System.out.println("Invalid email format.");
            }
        }

        while (true) {
            System.out.print("Enter gender (Male/Female/Other): ");
            String gender = sc.nextLine();

            if (gender.equalsIgnoreCase("Male")
                    || gender.equalsIgnoreCase("Female")
                    || gender.equalsIgnoreCase("Other")) {

                student.setGender(gender);
                break;

            } else {
                System.out.println("Invalid gender. Enter Male, Female, or Other.");
            }
        }

        while (true) {
            try {
                System.out.print("Enter date of birth (dd-MM-yyyy): ");
                student.setDateOfBirth(LocalDate.parse(sc.nextLine(), formatter));
                break;
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please enter in dd-MM-yyyy format.");
            }
        }

        while (true) {
            System.out.print("Enter course (MCA/BCA/BTech/MTech): ");
            String course = sc.nextLine();

            if (course.equalsIgnoreCase("MCA")
                    || course.equalsIgnoreCase("BCA")
                    || course.equalsIgnoreCase("BTech")
                    || course.equalsIgnoreCase("MTech") ) {

                student.setCourse(course.toUpperCase());
                break;

            } else {
                System.out.println("Invalid course. Enter MCA, BCA, BTech, or MTech.");
            }
        }

        boolean added = service.addStudent(student);     //1->service ko call kara aur reference(student) diya.
        if (added) {                                     //if added me true aya toh condition true hi hogi toh if execute hoga.
            System.out.println("Student added successfully!");
            System.out.println();
        } else {
            System.out.println("Failed to add student.");
        }
 }

    public static void viewStudentMenu(StudentService service) {    

                   System.out.println("===> All Students <===");
                   System.out.println();
                   List<Student> students = service.getAllStudents();

                   if (students.isEmpty()) {
                       System.out.println("No students found.");
                       return;
                    }
                   for (Student student : students) {
                       System.out.println("ID           : " + student.getId());
                       System.out.println("Name          : " + student.getName());
                       System.out.println("Age           : " + student.getAge());
                       System.out.println("Email         : " + student.getEmail());
                       System.out.println("Gender        : " + student.getGender());
                       System.out.println("Date of Birth : " + student.getDateOfBirth());
                       System.out.println("Course        : " + student.getCourse());
                       System.out.println("-----------------------------------");
                    }
                      System.out.println();
    }

    public static void updateStudentMenu(Scanner sc, StudentService service) {
                       Student updatingStudent = new Student(); 
                       DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy"); 
                       List<Student> students = service.getAllStudents();

                       System.out.println("===> Update Student <===");
                       System.out.println();
                       
                       if (students.isEmpty()) {
                           System.out.println("No students found.");
                           return;
                       }
                        viewStudentMenu(service);

                        System.out.print("Enter the ID of the student to update : ");
                        int id = sc.nextInt();
                        sc.nextLine();      

                   if (!service.studentExists(id)) {
                         System.out.println("Student with ID " + id + " not found.");
                         return;
                    }
                       updatingStudent.setId(id);

                       while (true) {
                              System.out.print("Enter student name: ");
                              String name = sc.nextLine();
                       if (name.matches("[A-Za-z ]+")) {
                              updatingStudent.setName(name);
                              break;
                       } else {
                              System.out.println("Invalid name.");
                        }
                        }
        while (true) {
            try {
                System.out.print("Enter age (between 1 and 120): ");
                int age = sc.nextInt();
                sc.nextLine(); // consume newline

                if (age >= 1 && age <= 120) {
                    updatingStudent.setAge(age);
                    break;
                } else {
                    System.out.println("Invalid age. Please enter age between 1 and 120.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter numbers only.");
                sc.nextLine(); // clear the invalid input
            }
        }
        while (true) {
            System.out.print("Enter email: ");
            String email = sc.nextLine();

            if (email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
                updatingStudent.setEmail(email);
                break;
            } else {
                System.out.println("Invalid email format.");
            }
        }
        while (true) {
            System.out.print("Enter gender (Male/Female/Other): ");
            String gender = sc.nextLine();

            if (gender.equalsIgnoreCase("Male")
                    || gender.equalsIgnoreCase("Female")
                    || gender.equalsIgnoreCase("Other")) {

                updatingStudent.setGender(gender);
                break;

            } else {
                System.out.println("Invalid gender. Enter Male, Female, or Other.");
            }
        }

        while (true) {
            try {
                System.out.print("Enter date of birth (dd-MM-yyyy): ");
                updatingStudent.setDateOfBirth(LocalDate.parse(sc.nextLine(), formatter));
                break;
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please enter in dd-MM-yyyy format.");
            }
        }

        while (true) {
            System.out.print("Enter course (MCA/BCA/BTech/MTech): ");
            String course = sc.nextLine();

            if (course.equalsIgnoreCase("MCA")
                    || course.equalsIgnoreCase("BCA")
                    || course.equalsIgnoreCase("BTech")
                    || course.equalsIgnoreCase("MTech")) {

                updatingStudent.setCourse(course.toUpperCase());
                break;

            } else {
                System.out.println("Invalid course. Enter MCA, BCA, BTech, or MTech.");
            }
        }
                boolean updated = service.updateStudent(updatingStudent);  
        if (updated) {
                System.out.println("Student updated successfully!");
                System.out.println();
        } else {
                System.out.println("Failed to update student.");
        }
    }

    public static void deleteStudentMenu(Scanner sc, StudentService service) {

                                Student deletingStudent = new Student();

                                List<Student> students = service.getAllStudents();
                         
                                if (students.isEmpty()) {
                                System.out.println("No students found.");
                                return;
                                }
                                viewStudentMenu(service);

                               System.out.print("Enter the ID of the student to delete : ");
                               int id = sc.nextInt();
                               sc.nextLine();
 
                               if (!service.studentExists(id)) {
                               System.out.println("Student with ID " + id + " not found.");
                               return;
                               }
                               deletingStudent.setId(id);
                               service.deleteStudent(deletingStudent);
        }
    public static void main(String[] args){
   
                          System.out.println("===> Student Management System <===");
                          Scanner sc = new Scanner(System.in);
                          StudentService service = new StudentService();   //"service" naam ka object banaya.

                          System.out.println();
                          int choice = 0;

            while(choice != 5){
                  showMenu();
                  System.out.print("Enter your choice: ");

                  choice = sc.nextInt();
                           sc.nextLine(); // very important, Consume the leftover "Enter".
                           switch (choice) {
                               case 1 ->  addStudentMenu(sc, service);  //Function me argument as "Object" pass kara hai.
                               case 2 ->  viewStudentMenu(service);
                               case 3 ->  updateStudentMenu(sc, service);
                               case 4 ->  deleteStudentMenu(sc, service);
                               case 5 ->  System.out.println("Exiting...");
                               default -> System.out.println("Invalid choice");

                            }                        
             } 
    }
} 