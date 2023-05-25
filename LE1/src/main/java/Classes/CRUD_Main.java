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
public class CRUD_Main {
    //Database
   private static final String FILEPATHNAME = "C:\\Users\\Gianne Bacay\\Documents\\NetBeansProjects\\LE1\\src\\main\\java\\Databases\\Patients.csv";
   //ArrayList
   public static ArrayList<Patient> PatientList = new ArrayList<>();
   public static ArrayList<Person> PersonList = new ArrayList<>();

    
//Populate Database
   public static void Populate_Database() {
      File file = new File(FILEPATHNAME);
      try (Scanner input = new Scanner(file)) {
         while (input.hasNextLine()) {
            String[] Line = input.nextLine().split(",");
            String ID = Line[0];
            String LName = Line[1];
            String FName = Line[2];
            String MName = Line[3];
            String Address = Line[3];
            String Age = Line[4];
            String Sex = Line[5];
            String Height = Line[6];
            String Weight = Line[7];
            String vaccineStatus = Line[8];
            String vaccineName = Line[9];
            Patient patient = new Patient(Integer.parseInt(ID), LName, FName, MName, Address, Age, Sex, Height, Weight, vaccineStatus, vaccineName);
            PatientList.add(patient);
         }
      } 
      catch (FileNotFoundException e) {
         JOptionPane.showMessageDialog(null, "Database file not found!");
      }
   }
         //Populate Database for dashboard
   public static void Populate_Database1() {
      File file = new File(FILEPATHNAME);
      try (Scanner input = new Scanner(file)) {
         while (input.hasNextLine()) {
            String[] Line = input.nextLine().split(",");
            String ID = Line[0];
            String LName = Line[1];
            String FName = Line[2];
            String MName = Line[3];
            String Address = Line[4];
            String Age = Line[5];
            String Sex = Line[6];
            Person person = new Person(Integer.parseInt(ID), LName, FName, MName, Address, Age, Sex);
            PersonList.add(person);
         }
      } 
      catch (FileNotFoundException e) {
         JOptionPane.showMessageDialog(null, "Database file not found!");
      }
   }
   
   
   //Save to Database
   public static void Save_To_Database() {
      try (PrintWriter writer = new PrintWriter(new FileWriter(FILEPATHNAME))) {
         for (Patient patient : PatientList) {
            writer.println(patient.getFName() + "," + patient.getLName() + "," + patient.getAddress() + "," + patient.getAge() + "," + patient.getSex());
         }
         writer.close();
      } 
      catch (IOException e) {
         JOptionPane.showMessageDialog(null, "Failed to save data to file!");
      }
   }
   
   public static void Save_To_Database1() {
      try (PrintWriter writer = new PrintWriter(new FileWriter(FILEPATHNAME))) {
         for (Patient patient : PatientList) {
            writer.println(patient.getFName() + "," + patient.getLName() + "," + patient.getAddress() + "," + patient.getAge() + "," + patient.getSex() + 
                    patient.getHeight() + "," + patient.getWeight() + "," + patient.getVaccineStatus() + "," + patient.getVaccineName());
         }
         writer.close();
      } 
      catch (IOException e) {
         JOptionPane.showMessageDialog(null, "Failed to save data to file!");
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
