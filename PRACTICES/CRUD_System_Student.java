import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import javax.swing.JOptionPane;
import java.awt.Desktop;

public class CRUD_System_Student {
   //Database
   private static final String FILEPATHNAME = "StudentDatabase.csv";
   //ArrayList
   public static ArrayList<Student> studentList = new ArrayList<Student>();

   //Scan Database
   public static void Scan_Database() {
      File file = new File(FILEPATHNAME);
      try (Scanner scan = new Scanner(file)) {
         while (scan.hasNextLine()) {
            String[] Line = scan.nextLine().split(",");
            String FName = Line[0];
            String LName = Line[1];
            String ID = Line[2];
            String Address = Line[3];
            String Course = Line[4];
            String YearLevel = Line[5];
            Student student = new Student(FName, LName, ID, Address, Course, YearLevel);
            studentList.add(student);
         }
      } 
      catch (FileNotFoundException e) {
         JOptionPane.showMessageDialog(null, "Database file not found!");
      }
   }
   
   //Save to Database
   public static void Save_To_Database() {
      try (PrintWriter writer = new PrintWriter(new FileWriter(FILEPATHNAME))) {
         for (Student student : studentList) {
            writer.println(student.getFName() + "," + student.getLName() + "," + student.getID() + 
            "," + student.getAddress() + "," + student.getCourse() + "," + student.getYearLevel());
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
      return JOptionPane.showOptionDialog(null, "What do you want to do?", "Student CRUD System", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]) + 1;
   }
   
   //Create
   public static void Create_Student() {
      String FName = JOptionPane.showInputDialog(null, "Enter first name:");
      if(FName == null) {
         return;
      }
      
      String LName = JOptionPane.showInputDialog(null, "Enter last name:");
      if(LName == null) {
         return;
      }
      
      String ID = JOptionPane.showInputDialog(null, "Enter ID:");
      if(ID == null) {
         return;
      }
      
      String Address = JOptionPane.showInputDialog(null, "Enter Address:");
      if(Address == null) {
         return;
      }
      
      String Course = JOptionPane.showInputDialog(null, "Enter Course:");
      if(Course == null) {
         return;
      }
      
      String YearLevel = JOptionPane.showInputDialog(null, "Enter Year Level:");
      if(YearLevel == null) {
         return;
      }
      
      Student student = new Student(FName, LName, ID, Address, Course, YearLevel);
      studentList.add(student);
      Save_To_Database();
      JOptionPane.showMessageDialog(null, "Student successfully added to the database!");
   }
   
   //Retrieve
   public static void Retrieve_Student() {
      String Name = JOptionPane.showInputDialog(null, "Enter name to search:");
      if(Name == null) {
         return;
      }
      
      boolean studentFound = false;
      for (Student student : studentList) {
         if (student.toString().equalsIgnoreCase(Name)) {
            JOptionPane.showMessageDialog(null, "Student Found!\n\n" +
               "First Name: " + student.getFName() + "\n" +
               "Last Name: " + student.getLName() + "\n" +
               "Full Name: " + student.toString() + "\n" + 
               "ID: " + student.getID() + "\n" +
               "Address: " + student.getAddress() + "\n" +
               "Course: " + student.getCourse() + "\n" +
               "Year Level: " + student.getYearLevel());
            studentFound = true;
            break;
         }
      }
      if (!studentFound && Name != null) {
         JOptionPane.showMessageDialog(null, "Student not found!");
      }
   }
   
   //Update
   public static void Update_Student() {
      String Name = JOptionPane.showInputDialog(null, "Enter name to update:");
      if(Name == null) {
         return;
      }
      
      Student studentToUpdate = null;
      for (Student student : studentList) {
         if (student.toString().equalsIgnoreCase(Name)) {
            studentToUpdate = student;
            break;
         }
      }
      if (studentToUpdate != null) {
         String[] options = {"First Name", "Last Name", "Full Name", "ID", "Address", "Course", "Year Level"};
         int choice = JOptionPane.showOptionDialog(null, "What do you want to update?", "Update Person", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
         switch (choice) {
            case 0:
               String newFName = JOptionPane.showInputDialog(null, "Enter new first name:");
               if(newFName == null) {
                  return;
               }
               studentToUpdate.setFName(newFName);
               break;
            case 1:
               String newLName = JOptionPane.showInputDialog(null, "Enter new last name:");
               if(newLName == null) {
                  return;
               }
               studentToUpdate.setLName(newLName);
               break;
            case 2:
               String newCName = JOptionPane.showInputDialog(null, "Enter new complete name:");
               if(newCName == null) {
                  return;
               }
               String[] Names = newCName.split(" ");
               studentToUpdate.setFName(Names[0]);
               studentToUpdate.setLName(Names[1]);
               break;
            case 3:
               String newID = JOptionPane.showInputDialog(null, "Enter new ID:");
               if(newID == null) {
                  return;
               }
               studentToUpdate.setID(newID);
               break;
            case 4:
               String newAddress = JOptionPane.showInputDialog(null, "Enter new Address:");
               if(newAddress == null) {
                  return;
               }
               studentToUpdate.setAddress(newAddress);
               break;
            case 5:
               String newCourse = JOptionPane.showInputDialog(null, "Enter new Course:");
               if(newCourse == null) {
                  return;
               }
               studentToUpdate.setCourse(newCourse);
               break;
            case 6:
               String newYearLevel = JOptionPane.showInputDialog(null, "Enter new Year Level:");
               if(newYearLevel == null) {
                  return;
               }
               studentToUpdate.setYearLevel(newYearLevel);
               break;
            default:
               JOptionPane.showMessageDialog(null, "Invalid choice, please try again!");
               break;
         }
         Save_To_Database();
         JOptionPane.showMessageDialog(null, "Person successfully updated!");
      } 
      else {
         JOptionPane.showMessageDialog(null, "Person not found!");
      }
   }

   //Delete
   public static void Delete_Student() {
      String[] options = {"Person", "All", "Cancel"};
      int choice = JOptionPane.showOptionDialog(null, "What do you want to delete?", "Delete", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
      switch (choice) {
         case 0:
            String Name = JOptionPane.showInputDialog(null, "Enter complete name to delete:");
            if(Name == null) {
               return;
            }
         
            boolean removed = false;
            for (Student student : studentList) {
               if (student.toString().equalsIgnoreCase(Name)) {
                  studentList.remove(student);
                  removed = true;
                  break;
               }
            }
            if (removed) {
               Save_To_Database();
               JOptionPane.showMessageDialog(null, "Person successfully removed from the database!");
            } 
            else {
               JOptionPane.showMessageDialog(null, "Person not found!");
            }
            break;
         case 1:
            studentList.subList(1, studentList.size()).clear();
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