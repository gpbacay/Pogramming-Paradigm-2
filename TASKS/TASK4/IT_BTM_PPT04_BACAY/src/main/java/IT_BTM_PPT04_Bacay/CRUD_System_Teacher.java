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
public class CRUD_System_Teacher {
    //Database
   private static final String FILEPATHNAME = "C:\\Users\\Gianne Bacay\\Desktop\\ProgPara2\\PROG TASKS\\TASK4\\IT_BTM_PPT04_BACAY\\src\\main\\java\\IT_BTM_PPT04_Bacay\\TeacherDatabase.csv";
   //ArrayList
   public static ArrayList<Teacher> teacherList = new ArrayList<Teacher>();

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
            String Rank = Line[4];
            String Designation = Line[5];
            Teacher teacher = new Teacher(FName, LName, ID, Address, Rank, Designation);
            teacherList.add(teacher);
         }
      } 
      catch (FileNotFoundException e) {
         JOptionPane.showMessageDialog(null, "Database file not found!");
      }
   }
   
   //Save to Database
   public static void Save_To_Database() {
      try (PrintWriter writer = new PrintWriter(new FileWriter(FILEPATHNAME))) {
         for (Teacher teacher : teacherList) {
            writer.println(teacher.getFName() + "," + teacher.getLName() + "," + teacher.getID() +
            "," + teacher.getAddress() + "," + teacher.getRank() + "," + teacher.getDesignation());
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
      return JOptionPane.showOptionDialog(null, "What do you want to do?", "Teacher CRUD System", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]) + 1;
   }
   
   //Create
   public static void Create_Teacher() {
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
      
      String Rank = JOptionPane.showInputDialog(null, "Enter Rank:");
      if(Rank == null) {
         return;
      }
      
      String Designation = JOptionPane.showInputDialog(null, "Enter Designation:");
      if(Designation == null) {
         return;
      }
      
      Teacher teacher = new Teacher(FName, LName, ID, Address, Rank, Designation);
      teacherList.add(teacher);
      Save_To_Database();
      JOptionPane.showMessageDialog(null, "Person successfully added to the database!");
   }
   
   //Retrieve
   public static void Retrieve_Teacher() {
      String Name = JOptionPane.showInputDialog(null, "Enter name to search:");
      if(Name == null) {
         return;
      }
      
      boolean teacherFound = false;
      for (Teacher teacher : teacherList) {
         if (teacher.toString().equalsIgnoreCase(Name)) {
            JOptionPane.showMessageDialog(null, "Teacher Found!\n\n" +
               "First Name: " + teacher.getFName() + "\n" +
               "Last Name: " + teacher.getLName() + "\n" +
               "Full Name: " + teacher.toString() + "\n" + 
               "ID: " + teacher.getID() + "\n" +
               "Address: " + teacher.getAddress() + "\n" +
               "Rank: " + teacher.getRank() + "\n" +
               "Designation: " + teacher.getDesignation());
            teacherFound = true;
            break;
         }
      }
      if (!teacherFound && Name != null) {
         JOptionPane.showMessageDialog(null, "Teacher not found!");
      }
   }
   
   //Update
   public static void Update_Teacher() {
      String Name = JOptionPane.showInputDialog(null, "Enter name to update:");
      if(Name == null) {
         return;
      }
      
      Teacher teacherToUpdate = null;
      for (Teacher teacher : teacherList) {
         if (teacher.toString().equalsIgnoreCase(Name)) {
            teacherToUpdate = teacher;
            break;
         }
      }
      if (teacherToUpdate != null) {
         String[] options = {"First Name", "Last Name", "Full Name", "ID", "Address", "Rank", "Designation"};
         int choice = JOptionPane.showOptionDialog(null, "What do you want to update?", "Update Person", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
         switch (choice) {
            case 0:
               String newFName = JOptionPane.showInputDialog(null, "Enter new first name:");
               if(newFName == null) {
                  return;
               }
               teacherToUpdate.setFName(newFName);
               break;
            case 1:
               String newLName = JOptionPane.showInputDialog(null, "Enter new last name:");
               if(newLName == null) {
                  return;
               }
               teacherToUpdate.setLName(newLName);
               break;
            case 2:
               String newCName = JOptionPane.showInputDialog(null, "Enter new complete name:");
               if(newCName == null) {
                  return;
               }
               String[] Names = newCName.split(" ");
               teacherToUpdate.setFName(Names[0]);
               teacherToUpdate.setLName(Names[1]);
               break;
            case 3:
               String newID = JOptionPane.showInputDialog(null, "Enter new ID:");
               if(newID == null) {
                  return;
               }
               teacherToUpdate.setID(newID);
               break;
            case 4:
               String newAddress = JOptionPane.showInputDialog(null, "Enter new Address:");
               if(newAddress == null) {
                  return;
               }
               teacherToUpdate.setAddress(newAddress);
               break;
            case 5:
               String newRank = JOptionPane.showInputDialog(null, "Enter new Rank:");
               if(newRank == null) {
                  return;
               }
               teacherToUpdate.setRank(newRank);
               break;
            case 6:
               String newDesignation = JOptionPane.showInputDialog(null, "Enter new Designation:");
               if(newDesignation == null) {
                  return;
               }
               teacherToUpdate.setDesignation(newDesignation);
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
   public static void Delete_Teacher() {
      String[] options = {"Person", "All", "Cancel"};
      int choice = JOptionPane.showOptionDialog(null, "What do you want to delete?", "Delete", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
      switch (choice) {
         case 0:
            String Name = JOptionPane.showInputDialog(null, "Enter complete name to delete:");
            if(Name == null) {
               return;
            }
         
            boolean removed = false;
            for (Teacher teacher : teacherList) {
               if (teacher.toString().equalsIgnoreCase(Name)) {
                  teacherList.remove(teacher);
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
            teacherList.subList(1, teacherList.size()).clear();
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
