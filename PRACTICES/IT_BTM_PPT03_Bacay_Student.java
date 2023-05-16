import javax.swing.JOptionPane;

public class IT_BTM_PPT03_Bacay_Student {
   //Main method
   public static void main(String[] args) {
      //Scan database
      CRUD_System_Student.Scan_Database();
      boolean running = true;
      while (running) {
         int choice = CRUD_System_Student.Display_Menu();
         switch (choice) {
            case 1:
            //create
               CRUD_System_Student.Create_Student();
               break;
            case 2:
            //read
               CRUD_System_Student.Read_Student();
               break;
            case 3:
            //update
               CRUD_System_Student.Update_Student();
               break;
            case 4:
            //delete
               CRUD_System_Student.Delete_Student();
               break;
            case 5:
            //open database
               CRUD_System_Student.OpenCSV();
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

