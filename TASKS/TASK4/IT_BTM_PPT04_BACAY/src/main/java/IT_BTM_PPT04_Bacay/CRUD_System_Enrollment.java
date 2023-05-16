/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package IT_BTM_PPT04_Bacay;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import javax.swing.JOptionPane;
import java.awt.Desktop;

/**
 *
 * @author Gianne Bacay
 */
public class CRUD_System_Enrollment {
    //Database
   private static final String FILEPATHNAME = "C:\\Users\\Gianne Bacay\\Desktop\\ProgPara2\\PROG TASKS\\TASK4\\IT_BTM_PPT04_BACAY\\src\\main\\java\\IT_BTM_PPT04_Bacay\\EnrollmentDatabase.csv";
   //ArrayList
   public static ArrayList<SubjectEnrolled> enrollmentList = new ArrayList<>();

   static CRUD_System_Student studentCRUD = new CRUD_System_Student();
   static CRUD_System_Teacher teacherCRUD = new CRUD_System_Teacher();
   static CRUD_System_Subject subjectCRUD = new CRUD_System_Subject();

   //Scan Database
   public static void Scan_Database() {
      File file = new File(FILEPATHNAME);
      try (Scanner scan = new Scanner(file)) {
         while (scan.hasNextLine()) {
            String[] Line = scan.nextLine().split(",");
            String studentID = Line[0];
            String teacherID = Line[1];
            String subjectTC = Line[2];
            double grade;
            try {
               grade = Double.parseDouble(Line[3]);
            }
            catch (NumberFormatException e) {
               System.out.println("Number Format Exception: " + e.getMessage());
               continue;
            }
            SubjectEnrolled subjectEnrolled = new SubjectEnrolled(studentID, teacherID, subjectTC, grade);
            enrollmentList.add(subjectEnrolled);
         }
      } 
      catch (FileNotFoundException e) {
         JOptionPane.showMessageDialog(null, "Database file not found!");
      }
   }
   
   //Save to Database
   public static void Save_To_Database() {
      try (PrintWriter writer = new PrintWriter(new FileWriter(FILEPATHNAME))) {
         for (SubjectEnrolled subjectEnrolled : enrollmentList) {
            writer.println(subjectEnrolled.getStudentID() + "," + subjectEnrolled.getTeacherID() + "," + subjectEnrolled.getSubjectTC() +
               "," + subjectEnrolled.getGrade());
         }
         writer.close();
      } 
      catch (IOException e) {
         JOptionPane.showMessageDialog(null, "Failed to save data to file!");
      }
   }
   
   //Display Menu
   public static int Display_Menu() {
      String[] options = {"Create", "Retrieve", "Update", "Delete", "Open", "Exit"};
      return JOptionPane.showOptionDialog(null, "What do you want to do?", "Enrollment CRUD System", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]) + 1;
   }
   
   //Create
   public static void Create_Enrollment() {
      String[] options = {"Enroll", "Enlist Student", "Enlist Teacher", "Enlist Subject", "Exit"};
      int choice = JOptionPane.showOptionDialog(null, "What do you want to do?", "Enrollment CRUD System", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
      switch (choice) {
         case 0 -> {
             //Search for enlisted Student
             String StudentID = null;
             boolean studentIDFound = false;
             while(studentIDFound == false) {
                 StudentID = JOptionPane.showInputDialog(null, "Enter Student ID:");
                 if(StudentID == null) {
                     return;
                 }
                 CRUD_System_Student.Scan_Database();
                 for(Student student : CRUD_System_Student.studentList) {
                     if (student.getID().equals(StudentID)) {
                         studentIDFound = true;
                         break;
                     }
                 }
                 if(studentIDFound == false) JOptionPane.showMessageDialog(null, "Student not yet Enlisted!");
             }
             
             //Search for enlisted Teacher
             String TeacherID = null;
             boolean teacherIDFound = false;
             while(teacherIDFound == false) {
                TeacherID = JOptionPane.showInputDialog(null, "Enter Teacher ID:");
                if(TeacherID == null) {
                    return;
                }
                 CRUD_System_Teacher.Scan_Database();
                 for(Teacher teacher : CRUD_System_Teacher.teacherList) {
                     if (teacher.getID().equals(TeacherID)) {
                         teacherIDFound = true;
                         break;
                     }
                 }
                 if(teacherIDFound == false) JOptionPane.showMessageDialog(null, "Teacher not yet Enlisted!");
             }
             
             //Search for enlisted Subject
             String SubjectTC = null;
             boolean subjectTCFound = false;
             while(subjectTCFound == false) {
                SubjectTC = JOptionPane.showInputDialog(null, "Enter Subject Title Code:");
                if(SubjectTC == null) {
                    return;
                }
                 CRUD_System_Subject.Scan_Database();
                 for(Subject subject : CRUD_System_Subject.subjectList) {
                     if (subject.getTitleCode().equals(SubjectTC)) {
                         subjectTCFound = true;
                         break;
                     }
                 }
                 if(subjectTCFound == false) JOptionPane.showMessageDialog(null, "Subject not yet Enlisted!");
             }
             
             String Grade = JOptionPane.showInputDialog(null, "Enter student Grade:");
             if(Grade == null) {
                 return;
             }
             
             SubjectEnrolled subjectEnrolled = new SubjectEnrolled(StudentID, TeacherID, SubjectTC, Double.parseDouble(Grade));
             enrollmentList.add(subjectEnrolled);
             Save_To_Database();
             JOptionPane.showMessageDialog(null, "Enrollment data successfully saved to database!\n\n" +
                        "Student ID: " + subjectEnrolled.getStudentID() + "\n" +
                        "Teacher ID: " + subjectEnrolled.getTeacherID() + "\n" +
                        "Subject Title Code: " + subjectEnrolled.getSubjectTC() + "\n" + 
                        "Grade: " + subjectEnrolled.getGrade());
           }
         case 1 -> CRUD_System_Student.Create_Student();
         case 2 -> CRUD_System_Teacher.Create_Teacher();
         case 3 -> CRUD_System_Subject.Create_Subject();
         case 4 -> {
             return;
           }
         default -> JOptionPane.showMessageDialog(null, "Invalid choice, please try again!");
      }
   }
   
   //Retrieve
    public static void Retrieve_Enrollment() {
      String[] options = {"Student Record", "Class List", "Subject Enrolled", "Faculty Load", "Exit"};
      int choice = JOptionPane.showOptionDialog(null, "What do you want to retrieve?", "Enrollment CRUD System", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
      switch (choice) {
         case 0:
            String StudentID = JOptionPane.showInputDialog(null, "Enter Student ID:");
            if(StudentID == null) {
               return;
            }

            boolean enrollmentFound = false;
            for (SubjectEnrolled subjectEnrolled : enrollmentList) {
               if (subjectEnrolled.getStudentID().equalsIgnoreCase(StudentID)) {
                  JOptionPane.showMessageDialog(null, "Student Record Found!\n\n" +
                        "Student ID: " + subjectEnrolled.getStudentID() + "\n" +
                        "Teacher ID: " + subjectEnrolled.getTeacherID() + "\n" +
                        "Subject Title Code: " + subjectEnrolled.getSubjectTC() + "\n" + 
                        "Grade: " + subjectEnrolled.getGrade());
                  enrollmentFound = true;
                  break;
               }
            }
            if (!enrollmentFound && StudentID != null) {
               JOptionPane.showMessageDialog(null, "Student not found!");
            }
            break;
         case 1:
            String SubjectTC = JOptionPane.showInputDialog(null, "Enter Subject Title Code:");
            if(SubjectTC == null) {
               return;
            }

            boolean classListFound = false;
            for (SubjectEnrolled subjectEnrolled : enrollmentList) {
                if (subjectEnrolled.getSubjectTC().equalsIgnoreCase(SubjectTC)) {
                    JOptionPane.showMessageDialog(null, "Class List Found!\n\n" +
                    "Subject Title Code: " + subjectEnrolled.getSubjectTC() + "\n" +
                    "Teacher ID: " + subjectEnrolled.getTeacherID() + "\n" +
                    "Student ID: " + subjectEnrolled.getStudentID() + "\n" + 
                    "Grade: " + subjectEnrolled.getGrade());
                    classListFound = true;
                }
            }
            if (!classListFound && SubjectTC != null) {
                JOptionPane.showMessageDialog(null, "No Class List found!");
            }
            break;
         case 2:
            StudentID = JOptionPane.showInputDialog(null, "Enter Student ID:");
            if(StudentID == null) {
               return;
            }

            boolean subjectEnrolledFound = false;
            for (SubjectEnrolled subjectEnrolled : enrollmentList) {
                if (subjectEnrolled.getStudentID().equalsIgnoreCase(StudentID)) {
                    JOptionPane.showMessageDialog(null, "Subject(s) Enrolled Found!\n\n" +
                    "Student ID: " + subjectEnrolled.getStudentID() + "\n" +
                    "Subject Title Code: " + subjectEnrolled.getSubjectTC() + "\n" +
                    "Teacher ID: " + subjectEnrolled.getTeacherID() + "\n" + 
                    "Grade: " + subjectEnrolled.getGrade());
                    subjectEnrolledFound = true;
                }
            }
            if (!subjectEnrolledFound && StudentID != null) {
                JOptionPane.showMessageDialog(null, "No Subjects Enrolled Record found!");
            }
            break;
         case 3:
            String TeacherID = JOptionPane.showInputDialog(null, "Enter Teacher ID:");
            if(TeacherID == null) {
               return;
            }

            boolean facultyLoadFound = false;
            for (SubjectEnrolled subjectEnrolled : enrollmentList) {
                if (subjectEnrolled.getTeacherID().equalsIgnoreCase(TeacherID)) {
                    JOptionPane.showMessageDialog(null, "Faculty Load Found!\n\n" +
                    "Teacher ID: " + subjectEnrolled.getTeacherID() + "\n" +
                    "Subject Title Code: " + subjectEnrolled.getSubjectTC() + "\n" +
                    "Student ID: " + subjectEnrolled.getStudentID() + "\n" + 
                    "Grade: " + subjectEnrolled.getGrade());
                    facultyLoadFound = true;
                }
            }
            if (!facultyLoadFound && TeacherID != null) {
                JOptionPane.showMessageDialog(null, "No Faculty Load found!");
            }
            break;
         case 4:
            return;
         default:
            JOptionPane.showMessageDialog(null, "Invalid choice, please try again!");
            break;
      }
      Save_To_Database();
      JOptionPane.showMessageDialog(null, "Enrollment data successfully retrieved!");
   }
   
   //Update
   public static void Update_Enrollment() {
      String StudentID = JOptionPane.showInputDialog(null, "Enter student ID to update:");
      if(StudentID == null) {
         return;
      }
      String TeacherID = JOptionPane.showInputDialog(null, "Enter student's teacher ID:");
      if(TeacherID == null) {
         return;
      }
      String SubjectTC = JOptionPane.showInputDialog(null, "Enter student's subject Title Code:");
      if(SubjectTC == null) {
         return;
      }
      
      SubjectEnrolled subjectEnrolledToUpdate = null;
      for (SubjectEnrolled subjectEnrolled : enrollmentList) {
         if (subjectEnrolled.getStudentID().equalsIgnoreCase(StudentID) && 
                 subjectEnrolled.getTeacherID().equalsIgnoreCase(TeacherID) &&
                 subjectEnrolled.getSubjectTC().equalsIgnoreCase(SubjectTC)) {
            subjectEnrolledToUpdate = subjectEnrolled;
            JOptionPane.showMessageDialog(null, "Enrollment data found!\n\n" +
                        "Student ID: " + subjectEnrolled.getStudentID() + "\n" +
                        "Teacher ID: " + subjectEnrolled.getTeacherID() + "\n" +
                        "Subject Title Code: " + subjectEnrolled.getSubjectTC() + "\n" + 
                        "Grade: " + subjectEnrolled.getGrade());
            break;
         }
      }
      
      if (subjectEnrolledToUpdate != null) {
         String[] options = {"Student ID", "Teacher ID", "Subject Title Code", "Grade", "Exit"};
         int choice = JOptionPane.showOptionDialog(null, "What do you want to update?", "Update Person", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
         switch (choice) {
            case 0 -> {
                String newStudentID = JOptionPane.showInputDialog(null, "Enter new Student ID:");
                if(newStudentID == null) {
                    return;
                }
                subjectEnrolledToUpdate.setStudentID(newStudentID);
              }
            case 1 -> {
                String newTeacherID = JOptionPane.showInputDialog(null, "Enter new Teacher ID:");
                if(newTeacherID == null) {
                    return;
                }
                subjectEnrolledToUpdate.setTeacherID(newTeacherID);
              }
            case 2 -> {
                String newSubjectTC = JOptionPane.showInputDialog(null, "Enter new Subject Title Code:");
                if(newSubjectTC == null) {
                    return;
                }
                subjectEnrolledToUpdate.setSubjectTC(newSubjectTC);
              }
            case 3 -> {
                String newGrade = JOptionPane.showInputDialog(null, "Enter new Unit(s):");
                if(newGrade == null) {
                    return;
                }
                subjectEnrolledToUpdate.setGrade(Double.parseDouble(newGrade));
              }
            case 4 -> {
                return;
              }
            default -> JOptionPane.showMessageDialog(null, "Invalid choice, please try again!");
         }
         Save_To_Database();
         JOptionPane.showMessageDialog(null, "Enrollment data successfully updated!");
      } 
      else {
         JOptionPane.showMessageDialog(null, "Enrollment data not found!");
      }
   }

   //Delete
   public static void Delete_Enrollment() {
      String[] options = {"Student Enrollment Data", "Clear All Data", "Cancel"};
      int choice = JOptionPane.showOptionDialog(null, "What do you want to delete?", "Delete", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
      switch (choice) {
         case 0 -> {
             String StudentID = JOptionPane.showInputDialog(null, "Enter Student ID to delete:");
             if(StudentID == null) {
                 return;
             }
             String TeacherID = JOptionPane.showInputDialog(null, "Enter student's teacher ID:");
             if(TeacherID == null) {
                 return;
             }
             String SubjectTC = JOptionPane.showInputDialog(null, "Enter student's subject Title Code:");
             if(SubjectTC == null) {
                 return;
             }
             
             boolean removed = false;
             for (SubjectEnrolled subjectEnrolled : enrollmentList) {
                 if (subjectEnrolled.getStudentID().equalsIgnoreCase(StudentID) &&
                         subjectEnrolled.getTeacherID().equalsIgnoreCase(TeacherID) &&
                         subjectEnrolled.getSubjectTC().equalsIgnoreCase(SubjectTC)) {
                     enrollmentList.remove(subjectEnrolled);
                     removed = true;
                     break;
                 }
             }
             if (removed) {
                 Save_To_Database();
                 JOptionPane.showMessageDialog(null, "Student ID successfully removed from the database!");
             }
             else {
                 JOptionPane.showMessageDialog(null, "Student ID not found!");
             }
           }
         case 1 -> {
             enrollmentList.subList(1, enrollmentList.size()).clear();
             Save_To_Database();
             JOptionPane.showMessageDialog(null, "Database successfully cleared!");
           }
         case 2 -> {
             return;
           }
         default -> JOptionPane.showMessageDialog(null, "Invalid choice, please try again!");
      }
   }
   
   //Open
   public static void OpenCSV() {
        String[] options = {"Enrollment Database", "Student Database", "Teacher Database", "Subject Database", "Cancel"};
        int choice = JOptionPane.showOptionDialog(null, "What do you want to open?", "Delete", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        switch (choice) {
        case 0 -> {
            File file = new File(FILEPATHNAME);
            try {
                Desktop.getDesktop().open(file);
            }
            catch (IOException e) {
                e.getMessage();
            }
           }
         case 1 -> CRUD_System_Student.OpenCSV();
         case 2 -> CRUD_System_Teacher.OpenCSV();
         case 3 -> CRUD_System_Subject.OpenCSV();
         case 4 -> {
             return;
           }
         default -> JOptionPane.showMessageDialog(null, "Invalid choice, please try again!");
      }
   }
}
