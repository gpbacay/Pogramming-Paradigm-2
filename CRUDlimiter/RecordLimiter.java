import javax.swing.JOptionPane;

public class RecordLimiter {
   private static final int MAX_RECORDS = 50;
   private static boolean full = false;
   
   public static boolean countRecords() {
      if (CRUD_System.Person_List.size() >= MAX_RECORDS + 1) {
         JOptionPane.showMessageDialog(null, "Maximum number of records reached. No new records can be added.");
         full = true;
      }
      return full;
   }
}
