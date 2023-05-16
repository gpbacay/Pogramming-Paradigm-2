import javax.swing.JOptionPane;

public class IT_BTM_PPT04_Bacay_SubjectEnrollment {
   //Main method
   public static void main(String[] args) {
      //Scan database
      CRUD_System_Enrollment.Scan_Database();
      boolean running = true;
      while (running) {
         int choice = CRUD_System_Enrollment.Display_Menu();
         switch (choice) {
            case 1:
            //create
               CRUD_System_Enrollment.Create_Enrollment();
               break;
            case 2:
            //retrieve
               CRUD_System_Enrollment.Retrieve_Enrollment();
               break;
            case 3:
            //update
               CRUD_System_Enrollment.Update_Enrollment();
               break;
            case 4:
            //delete
               CRUD_System_Enrollment.Delete_Enrollment();
               break;
            case 5:
            //open database
               CRUD_System_Enrollment.OpenCSV();
               break;
            case 6:
            //exit
               int confirmation = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Confirmation", JOptionPane.YES_NO_OPTION);
                  if (confirmation == JOptionPane.YES_OPTION) {
                     System.exit(0);
                  }
                  break;
            default:
            //exit
               confirmation = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Confirmation", JOptionPane.YES_NO_OPTION);
               if (confirmation == JOptionPane.YES_OPTION) {
                  System.exit(0);
               }
               break;
         }
      }
   }
}

