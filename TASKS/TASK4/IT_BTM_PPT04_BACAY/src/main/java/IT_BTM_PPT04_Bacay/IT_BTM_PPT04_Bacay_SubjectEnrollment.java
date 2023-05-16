/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package IT_BTM_PPT04_Bacay;
import javax.swing.JOptionPane;

/**
 *
 * @author Gianne Bacay
 */
public class IT_BTM_PPT04_Bacay_SubjectEnrollment {
    //Main method
   public static void main(String[] args) {
      //Scan database
      CRUD_System_Enrollment.Scan_Database();
      boolean running = true;
      while (running) {
         int choice = CRUD_System_Enrollment.Display_Menu();
         switch (choice) {
            case 1 -> //create
               CRUD_System_Enrollment.Create_Enrollment();
            case 2 -> //retrieve
               CRUD_System_Enrollment.Retrieve_Enrollment();
            case 3 -> //update
               CRUD_System_Enrollment.Update_Enrollment();
            case 4 -> //delete^
               CRUD_System_Enrollment.Delete_Enrollment();
            case 5 -> //open database
               CRUD_System_Enrollment.OpenCSV();
            case 6 -> {
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
