import javax.swing.JOptionPane;

public class IT_BTM_PPT04_Bacay_Subject {
   //Main method
   public static void main(String[] args) {
      //Scan database
      CRUD_System_Subject.Scan_Database();
      boolean running = true;
      while (running) {
         int choice = CRUD_System_Subject.Display_Menu();
         switch (choice) {
            case 1:
            //create
               CRUD_System_Subject.Create_Subject();
               break;
            case 2:
            //read
               CRUD_System_Subject.Read_Subject();
               break;
            case 3:
            //update
               CRUD_System_Subject.Update_Subject();
               break;
            case 4:
            //delete
               CRUD_System_Subject.Delete_Subject();
               break;
            case 5:
            //open database
               CRUD_System_Subject.OpenCSV();
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

