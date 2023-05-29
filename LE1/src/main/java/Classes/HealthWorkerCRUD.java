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
public class HealthWorkerCRUD {
    //Database
    private static final String FILEPATHNAME = "C:\\Users\\Gianne Bacay\\Documents\\NetBeansProjects\\LE1\\src\\main\\java\\Databases\\HealthWorker.csv";
    //ArrayList
    public static ArrayList<HealthWorker> HealthWorkerList = new ArrayList<>();

    //Populate Database
    public static void Populate_Database() {
        File file = new File(FILEPATHNAME);
        try (Scanner input = new Scanner(file)) {
            while (input.hasNextLine()) {
                String[] Line = input.nextLine().split(",");
                String ID = Line[0];
                String Name = Line[1];
                String Address = Line[2];
                String Age = Line[3];
                String Sex = Line[4];
                String Password = Line[5];
                HealthWorker hW = new HealthWorker(Integer.parseInt(ID), Name, Address, Age, Sex, Password);
                HealthWorkerList.add(hW);
            }
        } 
        catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Database file not found!");
        }
    }
   
   //Save to Database
   public static void Save_To_Database() {
      try (PrintWriter writer = new PrintWriter(new FileWriter(FILEPATHNAME))) {
         for (HealthWorker hW : HealthWorkerList) {
            writer.println(String.format("%06d", hW.getID()) + "," + hW.getName() + "," + hW.getAddress() + "," + hW.getAge() + "," + hW.getSex() + "," + hW.getPassword());
         }
         writer.close();
      } 
      catch (IOException e) {
         JOptionPane.showMessageDialog(null, "Failed to save data to file!");
      }
   }
   
   //Display Menu
   public static int Display_Menu() {
      String[] options = {"Create", "Retrieve", "Open", "Exit"};
      return JOptionPane.showOptionDialog(null, "What do you want to do?", "Health worker CRUD System", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]) + 1;
   }
   
   //Create
   public static void CreateAccount() {
      String ID = JOptionPane.showInputDialog(null, "Enter ID number:");
      if(ID == null) {
         return;
      }
      
      String Name = JOptionPane.showInputDialog(null, "Enter Name:");
      if(Name == null) {
         return;
      }
      
      String Address = JOptionPane.showInputDialog(null, "Enter Address:");
      if(Address == null) {
         return;
      }
      
      String Age = JOptionPane.showInputDialog(null, "Enter Age:");
      if(Age == null) {
         return;
      }
      
      String Sex = JOptionPane.showInputDialog(null, "Enter Sex:");
      if(Sex == null) {
         return;
      }
      
      String Password = JOptionPane.showInputDialog(null, "Enter Password:");
      if(Password == null) {
         return;
      }
      
      HealthWorker hW = new HealthWorker(Integer.parseInt(ID), Name, Address, Age, Sex, Password);
      HealthWorkerList.add(hW);
      Save_To_Database();
      JOptionPane.showMessageDialog(null, "Health worker successfully added to the database!");
   }
   
   //Retrieve
   public static void RetrieveAccount() {
      String ID = JOptionPane.showInputDialog(null, "Enter ID number:");
      if(ID == null) {
         return;
      }
      
      boolean hWFound = false;
      for (HealthWorker hW : HealthWorkerList) {
         if (ID.equalsIgnoreCase(String.valueOf(hW.getID()))) {
            JOptionPane.showMessageDialog(null, "Health worker Found!\n\n" +
               "ID: " + hW.getID() + "\n" +
               "Password: " + hW.getPassword());
            hWFound = true;
            break;
         }
      }
      if (!hWFound && ID != null) {
         JOptionPane.showMessageDialog(null, "Health worker not found!");
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
