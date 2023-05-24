/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import Classes.CRUD_Account;
import static Classes.CRUD_Account.Display_Menu;
import javax.swing.JOptionPane;

/**
 *
 * @author Gianne Bacay
 */
public class AccountMain {
       public static void main(String[] args) {
      //Scan database
      CRUD_Account.Populate_Database();
      boolean running = true;
      while (running) {
         int choice = Display_Menu();
         switch (choice) {
            case 1 -> //create
               CRUD_Account.CreateAccount();
            case 2 -> //open database
               CRUD_Account.RetrieveAccount();
            case 3 -> //open database
               CRUD_Account.OpenCSV();
            case 4 -> {
                //exit
                int confirmation = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Confirmation", JOptionPane.YES_NO_OPTION);
                if (confirmation == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
              }
            default -> {
                  //exit
                  int confirmation = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Confirmation", JOptionPane.YES_NO_OPTION);
                  if (confirmation == JOptionPane.YES_OPTION) {
                      System.exit(0);
                  }
              }
         }
      }
   }
}
