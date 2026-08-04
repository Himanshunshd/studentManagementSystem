package com.studentmanagement.app ;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner; 
import com.studentmanagement.model.Student;
import com.studentmanagement.service.StudentService;

public class Main{

       public static void showMenu(){
               
              System.out.println("1. Add Student");
              System.out.println("2. View All Students");
              System.out.println("3. Update Student");
              System.out.println("4. Delete Student");
              System.out.println("5. Exit");
              System.out.println();
        }

        public static void addStudentMenu(Scanner sc, StudentService service){
               Student student = new Student();
               DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");   //

               System.out.print("Enter student name: ");
               String abc ; 
               if(abc == "a"){

               }
               student.setName(sc.nextLine());

               System.out.print("Enter age: ");
               student.setAge(sc.nextInt());
               sc.nextLine(); // consume leftover newline

               System.out.print("Enter email: ");
               student.setEmail(sc.nextLine());

               System.out.print("Enter gender: ");
               student.setGender(sc.nextLine());

               while(true){
                     try{
                           System.out.print("Enter date of birth (dd-MM-yyyy): ");
                           student.setDateOfBirth(LocalDate.parse(sc.nextLine(), formatter));
                           break;
                     } catch (DateTimeParseException e) {
                           System.out.println("Invalid date format. Please enter in dd-MM-yyyy format.");
                     }
               }

               System.out.print("Enter course: ");
               student.setCourse(sc.nextLine());

               boolean added = service.addStudent(student);
               if (added) {
                     System.out.println("Student added successfully!");
               } else {
                     System.out.println("Failed to add student.");
               }
      }

    public static void main(String[] args){
        
        
            //   Student addingStudent = new Student();       //Adding Student,  Create Student object.

                    //   addingStudent.setName("Himanshu");
                    //   addingStudent.setAge(26);
                    //   addingStudent.setEmail("hima1@gmail.com");
                    //   addingStudent.setGender("Male");
                    //   addingStudent.setDateOfBirth(LocalDate.of(2004, 5, 10));
                    //   addingStudent.setCourse("MCA");
            
            //   StudentService service = new StudentService();  
          //     service.addStudent(addingStudent);         
           

        // StudentService service = new StudentService();         //Show Student.
        //        List<Student> getAllStudents = service.getAllStudents();

        //           for (Student student : getAllStudents) {
        //                System.out.println(
        //                student.getId() + " " +
        //                student.getName() + " " + 
        //                student.getAge() + " " +
        //                student.getEmail() + " " +
        //                student.getGender() + " " +
        //                student.getDateOfBirth() + " " +
        //                student.getCourse()); 
        //             }  


            //    Student updatingStudent = new Student();     // Update student, or this time required all fields for updating value.
                  
            //       updatingStudent.setId(9);          // Existing student id
            //       updatingStudent.setName("Himanshu Nishad");
            //       updatingStudent.setAge(23);
            //       updatingStudent.setEmail("himanshu@gmail.com");
            //       updatingStudent.setGender("Female"); 
            //       updatingStudent.setDateOfBirth(LocalDate.of(2004, 5, 10));
            //       updatingStudent.setCourse("MCA");

            //    StudentService service = new StudentService();  
            //    service.updateStudent(updatingStudent);

                   
        //  StudentService service = new StudentService();
        //     service.deleteStudent(9);
  //-----------------------------------------------------------------------------------------------------------------------
            System.out.println("===> Student Management System <===");
            Scanner sc = new Scanner(System.in);
            StudentService service = new StudentService();

            
             System.out.println();
             int choice = 0 ;
             
             while(choice != 5){
                  showMenu();
                  System.out.print("Enter your choice: ");

                  choice = sc.nextInt();
                        sc.nextLine(); // very important
                        switch(choice){
                            case 1 :
                                addStudentMenu(sc, service);
                                break ;
                            case 2 :
                                 System.out.println("2 -> View All Students selected");
                                 break ; 
                            case 3:
                                  System.out.println("3 -> Update Student selected");
                                  break ;
                            case 4:
                                  System.out.println("4 -> Delete Student selected");
                                  break ;
                            case 5:
                                  System.out.println("5 -> Exiting...");
                                  break ;
                            default:
                                  System.out.println("Invalid choice");
                          }
             } 

}
}
