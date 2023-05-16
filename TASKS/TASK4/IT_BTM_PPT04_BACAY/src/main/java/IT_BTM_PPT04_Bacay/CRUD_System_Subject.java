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
public class CRUD_System_Subject {
    //Database
   private static final String FILEPATHNAME = "C:\\Users\\Gianne Bacay\\Desktop\\ProgPara2\\PROG TASKS\\TASK4\\IT_BTM_PPT04_BACAY\\src\\main\\java\\IT_BTM_PPT04_Bacay\\SubjectDatabase.csv";
   //ArrayList
   public static ArrayList<Subject> subjectList = new ArrayList<>();

   //Scan Database
   public static void Scan_Database() {
      File file = new File(FILEPATHNAME);
      try (Scanner scan = new Scanner(file)) {
         while (scan.hasNextLine()) {
            String[] Line = scan.nextLine().split(",");
            String TileCode = Line[0];
            String Description = Line[1];
            String Schedule = Line[2];
            String Unit = Line[3];
            Subject subject = new Subject(TileCode, Description, Schedule, Unit);
            subjectList.add(subject);
         }
      } 
      catch (FileNotFoundException e) {
         JOptionPane.showMessageDialog(null, "Database file not found!");
      }
   }
   
   //Save to Database
   public static void Save_To_Database() {
      try (PrintWriter writer = new PrintWriter(new FileWriter(FILEPATHNAME))) {
         for (Subject subject : subjectList) {
            writer.println(subject.getTitleCode() + "," + subject.getDescription() + "," + subject.getSchedule() +
            "," + subject.getUnit());
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
      return JOptionPane.showOptionDialog(null, "What do you want to do?", "Subject CRUD System", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]) + 1;
   }
   
   //Create
   public static void Create_Subject() {
      String TitleCode = JOptionPane.showInputDialog(null, "Enter Title Code:");
      if(TitleCode == null) {
         return;
      }
      
      String Description = JOptionPane.showInputDialog(null, "Enter Description:");
      if(Description == null) {
         return;
      }
      
      String Schedule = JOptionPane.showInputDialog(null, "Enter Schedule:");
      if(Schedule == null) {
         return;
      }
      
      String Unit = JOptionPane.showInputDialog(null, "Enter Unit(s):");
      if(Unit == null) {
         return;
      }
      
      Subject subject = new Subject(TitleCode, Description, Schedule, Unit);
      subjectList.add(subject);
      Save_To_Database();
      JOptionPane.showMessageDialog(null, "Subject successfully added to the database!");
   }
   
   //Retrieve
   public static void Retrieve_Subject() {
      String TitleCode = JOptionPane.showInputDialog(null, "Enter title code of subject to search:");
      if(TitleCode == null) {
         return;
      }
      
      boolean subjectFound = false;
      for (Subject subject : subjectList) {
         if (subject.getTitleCode().equalsIgnoreCase(TitleCode)) {
            JOptionPane.showMessageDialog(null, "Subject Found!\n\n" +
               "Title Code: " + subject.getTitleCode() + "\n" +
               "Description: " + subject.getDescription() + "\n" +
               "Schedule: " + subject.getSchedule() + "\n" + 
               "Unit(s): " + subject.getUnit());
            subjectFound = true;
            break;
         }
      }
      if (!subjectFound && TitleCode != null) {
         JOptionPane.showMessageDialog(null, "Subject not found!");
      }
   }
   
   //Update
   public static void Update_Subject() {
      String TitleCode = JOptionPane.showInputDialog(null, "Enter title code of subject to update:");
      if(TitleCode == null) {
         return;
      }
      
      Subject subjectToUpdate = null;
      for (Subject subject : subjectList) {
         if (subject.getTitleCode().equalsIgnoreCase(TitleCode)) {
            subjectToUpdate = subject;
            break;
         }
      }
      if (subjectToUpdate != null) {
         String[] options = {"Title Code", "Description", "Schedule", "Unit"};
         int choice = JOptionPane.showOptionDialog(null, "What do you want to update?", "Update Person", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
         switch (choice) {
            case 0:
               String newTitleCode = JOptionPane.showInputDialog(null, "Enter new Title Code:");
               if(newTitleCode == null) {
                  return;
               }
               subjectToUpdate.setTitleCode(newTitleCode);
               break;
            case 1:
               String newDescription = JOptionPane.showInputDialog(null, "Enter new Description:");
               if(newDescription == null) {
                  return;
               }
               subjectToUpdate.setDescription(newDescription);
               break;
            case 2:
               String newSchedule = JOptionPane.showInputDialog(null, "Enter new Schedule:");
               if(newSchedule == null) {
                  return;
               }
               subjectToUpdate.setSchedule(newSchedule);
               break;
            case 3:
               String newUnit = JOptionPane.showInputDialog(null, "Enter new Unit(s):");
               if(newUnit == null) {
                  return;
               }
               subjectToUpdate.setUnit(newUnit);
               break;
            default:
               JOptionPane.showMessageDialog(null, "Invalid choice, please try again!");
               break;
         }
         Save_To_Database();
         JOptionPane.showMessageDialog(null, "Subject successfully updated!");
      } 
      else {
         JOptionPane.showMessageDialog(null, "Subject not found!");
      }
   }

   //Delete
   public static void Delete_Subject() {
      String[] options = {"Person", "All", "Cancel"};
      int choice = JOptionPane.showOptionDialog(null, "What do you want to delete?", "Delete", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
      switch (choice) {
         case 0:
            String TitleCode = JOptionPane.showInputDialog(null, "Enter title code of subject to delete:");
            if(TitleCode == null) {
               return;
            }
         
            boolean removed = false;
            for (Subject subject : subjectList) {
               if (subject.getTitleCode().equalsIgnoreCase(TitleCode)) {
                  subjectList.remove(subject);
                  removed = true;
                  break;
               }
            }
            if (removed) {
               Save_To_Database();
               JOptionPane.showMessageDialog(null, "Subject successfully removed from the database!");
            } 
            else {
               JOptionPane.showMessageDialog(null, "Subject not found!");
            }
            break;
         case 1:
            subjectList.subList(1, subjectList.size()).clear();
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
