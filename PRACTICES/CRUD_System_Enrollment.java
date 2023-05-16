import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import javax.swing.JOptionPane;
import java.awt.Desktop;

public class CRUD_System_Enrollment {
   //Database
   private static final String FILEPATHNAME = "EnrollmentDatabase.csv";
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
            String grade = Line[3];
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
      String[] options = {"Enroll", "Add Student", "Add Teacher", "Add Subject", "Exit"};
      int choice = JOptionPane.showOptionDialog(null, "What do you want to do?", "Enrollment CRUD System", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
      switch (choice) {
         case 0:
            String StudentID = JOptionPane.showInputDialog(null, "Enter Student ID:");
            if(StudentID == null) {
               return;
            }
            String TeacherID = JOptionPane.showInputDialog(null, "Enter Teacher ID:");
            if(TeacherID == null) {
               return;
            }
            
            String SubjectTC = JOptionPane.showInputDialog(null, "Enter Subject Title Code:");
            if(SubjectTC == null) {
               return;
            }
            
            String Grade = JOptionPane.showInputDialog(null, "Enter student Grade:");
            if(Grade == null) {
               return;
            }
            
            SubjectEnrolled subjectEnrolled = new SubjectEnrolled(StudentID, TeacherID, SubjectTC, Grade);
            enrollmentList.add(subjectEnrolled);
            Save_To_Database();
            JOptionPane.showMessageDialog(null, "Enrollment data successfully saved to database!");
            break;
         case 1:
            studentCRUD.Create_Student();
            break;
         case 2:
            teacherCRUD.Create_Teacher();
            break;
         case 3:
            subjectCRUD.Create_Subject();
            break;
         case 4:
            return;
         default:
            JOptionPane.showMessageDialog(null, "Invalid choice, please try again!");
            break;
      }
   }
   
   //Retrieve
   public static void Retrieve_Enrollment() {
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
   
      String[] options = {"Student Record", "Class List", "Subject Enrolled", "Faculty Load", "Exit"};
      int choice = JOptionPane.showOptionDialog(null, "What do you want to retrieve?", "Enrollment CRUD System", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]) + 1;
      switch (choice) {
         case 0:
         case 1:
         case 2:
         case 3:
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
      
      SubjectEnrolled subjectToUpdate = null;
      for (SubjectEnrolled subjectEnrolled : enrollmentList) {
         if (subjectEnrolled.getStudentID().equalsIgnoreCase(StudentID)) {
            subjectToUpdate = subjectEnrolled;
            break;
         }
      }
      if (subjectToUpdate != null) {
         String[] options = {"Student ID", "Teacher ID", "Subject Title Code", "Grade", "Exit"};
         int choice = JOptionPane.showOptionDialog(null, "What do you want to update?", "Update Person", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
         switch (choice) {
            case 0:
               String newStudentID = JOptionPane.showInputDialog(null, "Enter new Student ID:");
               if(newStudentID == null) {
                  return;
               }
               subjectToUpdate.setStudentID(newStudentID);
               break;
            case 1:
               String newTeacherID = JOptionPane.showInputDialog(null, "Enter new Teacher ID:");
               if(newTeacherID == null) {
                  return;
               }
               subjectToUpdate.setTeacherID(newTeacherID);
               break;
            case 2:
               String newSubjectTC = JOptionPane.showInputDialog(null, "Enter new Subject Title Code:");
               if(newSubjectTC == null) {
                  return;
               }
               subjectToUpdate.setSubjectTC(newSubjectTC);
               break;
            case 3:
               String newGrade = JOptionPane.showInputDialog(null, "Enter new Unit(s):");
               if(newGrade == null) {
                  return;
               }
               subjectToUpdate.setGrade(newGrade);
               break;
            case 4:
               return;
            default:
               JOptionPane.showMessageDialog(null, "Invalid choice, please try again!");
               break;
         }
         Save_To_Database();
         JOptionPane.showMessageDialog(null, "Enrollment data successfully updated!");
      } 
      else {
         JOptionPane.showMessageDialog(null, "Student not found!");
      }
   }

   //Delete
   public static void Delete_Enrollment() {
      String[] options = {"Student Enrollment Data", "Clear All Data", "Cancel"};
      int choice = JOptionPane.showOptionDialog(null, "What do you want to delete?", "Delete", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
      switch (choice) {
         case 0:
            String StudentID = JOptionPane.showInputDialog(null, "Enter Student ID to delete:");
            if(StudentID == null) {
               return;
            }
         
            boolean removed = false;
            for (SubjectEnrolled subjectEnrolled : enrollmentList) {
               if (subjectEnrolled.getStudentID().equalsIgnoreCase(StudentID)) {
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
            break;
         case 1:
            enrollmentList.subList(1, enrollmentList.size()).clear();
            Save_To_Database();
            JOptionPane.showMessageDialog(null, "Database successfully cleared!");
            break;
         case 2:
            return;
         default:
            JOptionPane.showMessageDialog(null, "Invalid choice, please try again!");
            break;
      }
   }
   
   //Open
   public static void OpenCSV() {
      File file = new File(FILEPATHNAME);
      try {
         Desktop.getDesktop().open(file);
      }
      catch (IOException e) {
         e.getMessage();
      }
   }
}