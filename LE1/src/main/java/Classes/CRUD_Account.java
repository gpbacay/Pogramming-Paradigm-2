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
public class CRUD_Account {
    //Database
    private static final String FILEPATHNAME = "C:\\Users\\Gianne Bacay\\Documents\\NetBeansProjects\\LE1\\src\\main\\java\\Databases\\Accounts.csv";
    //ArrayList
    public static ArrayList<Account> AccountList = new ArrayList<>();

    //Populate Database
    public static void Populate_Database() {
        File file = new File(FILEPATHNAME);
        try (Scanner input = new Scanner(file)) {
            while (input.hasNextLine()) {
               String[] Line = input.nextLine().split(",");
               String ID = Line[0];
               String Password = Line[1];
               String Name = Line[2];
               Account acc = new Account(ID, Password, Name);
               AccountList.add(acc);
            }
        } 
        catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Database file not found!");
        }
    }
   
   //Save to Database
   public static void Save_To_Database() {
      try (PrintWriter writer = new PrintWriter(new FileWriter(FILEPATHNAME))) {
         for (Account acc : AccountList) {
            writer.println(acc.getID() + "," + acc.getPassword() + "," + acc.getName());
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
      return JOptionPane.showOptionDialog(null, "What do you want to do?", "Student CRUD System", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]) + 1;
   }
   
   //Create
   public static void CreateAccount() {
      String ID = JOptionPane.showInputDialog(null, "Enter ID number:");
      if(ID == null) {
         return;
      }
      
      String Password = JOptionPane.showInputDialog(null, "Enter Password:");
      if(Password == null) {
         return;
      }
      
      String Name = JOptionPane.showInputDialog(null, "Enter Name:");
      if(Name == null) {
         return;
      }
      
      Account acc = new Account(ID, Password, Name);
      AccountList.add(acc);
      Save_To_Database();
      JOptionPane.showMessageDialog(null, "Person successfully added to the database!");
   }
   
   //Retrieve
   public static void RetrieveAccount() {
      String ID = JOptionPane.showInputDialog(null, "Enter ID number:");
      if(ID == null) {
         return;
      }
      
      boolean accountFound = false;
      for (Account acc : AccountList) {
         if (acc.getID().equalsIgnoreCase(ID)) {
            JOptionPane.showMessageDialog(null, "Account Found!\n\n" +
               "ID: " + acc.getID() + "\n" +
               "Password: " + acc.getPassword());
            accountFound = true;
            break;
         }
      }
      if (!accountFound && ID != null) {
         JOptionPane.showMessageDialog(null, "Account not found!");
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
