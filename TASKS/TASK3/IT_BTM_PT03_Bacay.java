import javax.swing.JOptionPane;

public class IT_BTM_PT03_Bacay {
   //Main method
   public static void main(String[] args) {
      //Scan database
      CRUD_System.Scan_Database();
      boolean running = true;
      while (running) {
         int choice = CRUD_System.Display_Menu();
         switch (choice) {
            case 1:
            //create
               CRUD_System.Create_Person();
               break;
            case 2:
            //read
               CRUD_System.Read_Person();
               break;
            case 3:
            //update
               CRUD_System.Update_Person();
               break;
            case 4:
            //delete
               CRUD_System.Delete_Person();
               break;
            case 5:
            //open database
               CRUD_System.OpenCSV();
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

