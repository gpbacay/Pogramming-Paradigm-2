/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Gianne Bacay
 */
public class MainCRUD {
    //Database
   private static final String FILEPATHNAME = "C:\\Users\\Gianne Bacay\\Documents\\NetBeansProjects\\LE1\\src\\main\\java\\Databases\\Patients.csv";
   //ArrayList
   public static ArrayList<Child> ChildList = new ArrayList<>();

    
//Populate Database
   public static void PopulateDatabase() {
      File file = new File(FILEPATHNAME);
      try (Scanner input = new Scanner(file)) {
         while (input.hasNextLine()) {
            String[] Line = input.nextLine().split(",");
            String ID = Line[0];
            String Name = Line[1];
            String Address = Line[2];
            String Age = Line[3];
            String Sex = Line[4];
            String VaccineName = Line[5];
            String VaccineType = Line[6];
            String DateGiven = Line[7];
            String AdministeredBy = Line[8];
            String NextDoseDate = Line[9];
            String Allergies = Line[10];
            String Reactions = Line[11];
            Child child = new Child(Integer.parseInt(ID), Name, Address, Age, Sex, VaccineName, VaccineType, DateGiven, AdministeredBy, NextDoseDate, Allergies, Reactions);
            ChildList.add(child);
         }
      } 
      catch (FileNotFoundException e) {
         JOptionPane.showMessageDialog(null, "Database file not found!");
      }
   }
   
   public static void SaveToDatabase() {
      try (PrintWriter writer = new PrintWriter(new FileWriter(FILEPATHNAME))) {
         for (Child patient : ChildList) {
            writer.println(String.format("%06d", patient.getID()) + "," + patient.getName() + "," + patient.getAddress() + "," + patient.getAge() + "," + patient.getSex() + "," +
                    patient.getVaccineName() + "," + patient.getVaccineType() + "," + patient.getVaccineType() + "," + patient.getDateGiven() + patient.getAdministeredBy() + "," +
                    patient.getNextDoseDate() + "," + patient.getAllergies() + "," + patient.getReactions());
         }
         writer.close();
      } 
      catch (IOException e) {
         JOptionPane.showMessageDialog(null, "Failed to save data to file!");
      }
   }
   
   //Open Immunized Child Records
   public static void OpenCSV() {
      File file = new File(FILEPATHNAME);
      try {
         Desktop.getDesktop().open(file);
      }
      catch (IOException e) {
         e.getMessage();
      }
   }
   
//   //Open
//   public static void OpenCSV1() {
//        String[] options = {"Registered Patients", "Authorized Health Workers", "Cancel"};
//        int choice = JOptionPane.showOptionDialog(null, "What do you want to open?", "Databases", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
//        switch (choice) {
//        case 0 -> {
//            File file = new File(FILEPATHNAME);
//            try {
//                Desktop.getDesktop().open(file);
//            }
//            catch (IOException e) {
//                e.getMessage();
//            }
//           }
//         case 1 -> HealthWorkerCRUD.OpenCSV();
//         case 2 -> {
//             return;
//           }
//         default -> {return;}
//      }
//   }
}
