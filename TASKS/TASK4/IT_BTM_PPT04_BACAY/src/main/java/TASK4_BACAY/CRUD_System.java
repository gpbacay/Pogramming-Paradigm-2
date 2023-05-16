package TASK4_BACAY;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import javax.swing.JOptionPane;
import java.awt.Desktop;

public class CRUD_System {
   //Database
   private static final String FILEPATHNAME = "C:\\Users\\Gianne Bacay\\Desktop\\ProgPara2\\PROG TASKS\\TASK4\\IT_BTM_PPT04_BACAY\\src\\main\\java\\TASK4_BACAY\\database.csv";
   //ArrayList
   public static ArrayList<Patient> Patient_List = new ArrayList<>();

   //Populate Database
   public static void Populate_Database() {
      File file = new File(FILEPATHNAME);
      try (Scanner input = new Scanner(file)) {
         while (input.hasNextLine()) {
            String[] Line = input.nextLine().split(",");
            String FName = Line[0];
            String LName = Line[1];
            String Address = Line[2];
            String Age = Line[3];
            String Sex = Line[4];
            Patient patient = new Patient(FName, LName, Address, Age, Sex);
            Patient_List.add(patient);
         }
      } 
      catch (FileNotFoundException e) {
         JOptionPane.showMessageDialog(null, "Database file not found!");
      }
   }
   
   //Save to Database
   public static void Save_To_Database() {
      try (PrintWriter writer = new PrintWriter(new FileWriter(FILEPATHNAME))) {
         for (Patient patient : Patient_List) {
            writer.println(patient.getFName() + "," + patient.getLName() + "," + patient.getAddress() + "," + patient.getAge() + "," + patient.getSex());
         }
         writer.close();
      } 
      catch (IOException e) {
         JOptionPane.showMessageDialog(null, "Failed to save data to file!");
      }
   }
   
//   //Display Menu
//   public static int Display_Menu() {
//      String[] options = {"Create", "Read", "Update", "Delete", "View Records", "Exit"};
//      return JOptionPane.showOptionDialog(null, "What do you want to do?", "CRUD System", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]) + 1;
//   }
//   
//   //Create
//   public static void Create_Patient() {
//      String FName = JOptionPane.showInputDialog(null, "Enter first name:");
//      if(FName == null) {
//         return;
//      }
//      
//      String LName = JOptionPane.showInputDialog(null, "Enter last name:");
//      if(LName == null) {
//         return;
//      }
//      
//      String Address = JOptionPane.showInputDialog(null, "Enter address:");
//      if(Address == null) {
//         return;
//      }
//      
//      String Age = JOptionPane.showInputDialog(null, "Enter age:");
//      if(Age == null) {
//         return;
//      }
//      
//      String Sex = JOptionPane.showInputDialog(null, "Enter sex:");
//      if(Sex == null) {
//         return;
//      }
//      
//      Patient patient = new Patient(FName, LName, Address, Age, Sex);
//      Patient_List.add(patient);
//      Save_To_Database();
//      JOptionPane.showMessageDialog(null, "Patient successfully added to the database!");
//   }
//   
//   //Read
//   public static void Read_Patient() {
//      String Name = JOptionPane.showInputDialog(null, "Enter name to search:");
//      if(Name == null) {
//         return;
//      }
//      
//      boolean patientFound = false;
//      for (Patient patient : Patient_List) {
//         if (patient.getCName().equalsIgnoreCase(Name)) {
//            JOptionPane.showMessageDialog(null, "Patient Found!\n\n" +
//               "First Name: " + patient.getFName() + "\n" +
//               "Last Name: " + patient.getLName() + "\n" +
//               "Full Name: " + patient.getCName() + "\n" + 
//               "Address: " + patient.getAddress() + "\n" +
//               "Age: " + patient.getAge() + "\n" +
//               "Sex: " + patient.getSex());
//            patientFound = true;
//            break;
//         }
//      }
//      if (!patientFound && Name != null) {
//         JOptionPane.showMessageDialog(null, "Patient not found!");
//      }
//   }
//   
//   //Update
//   public static void Update_Patient() {
//      String Name = JOptionPane.showInputDialog(null, "Enter name to update:");
//      if(Name == null) {
//         return;
//      }
//      
//      Patient patientToUpdate = null;
//      for (Patient patient : Patient_List) {
//         if (patient.getCName().equalsIgnoreCase(Name)) {
//            patientToUpdate = patient;
//            break;
//         }
//      }
//      if (patientToUpdate != null) {
//         String[] options = {"First Name", "Last Name", "Full Name", "Address"};
//         int choice = JOptionPane.showOptionDialog(null, "What do you want to update?", "Update Person", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
//         switch (choice) {
//            case 0:
//               String newFName = JOptionPane.showInputDialog(null, "Enter new first name:");
//               if(newFName == null) {
//                  return;
//               }
//               patientToUpdate.setFName(newFName);
//               break;
//            case 1:
//               String newLName = JOptionPane.showInputDialog(null, "Enter new last name:");
//               if(newLName == null) {
//                  return;
//               }
//               patientToUpdate.setLName(newLName);
//               break;
//            case 2:
//               String newCName = JOptionPane.showInputDialog(null, "Enter new complete name:");
//               if(newCName == null) {
//                  return;
//               }
//               String[] Names = newCName.split(" ");
//               patientToUpdate.setFName(Names[0]);
//               patientToUpdate.setLName(Names[1]);
//               break;
//            case 3:
//               String newAddress = JOptionPane.showInputDialog(null, "Enter new address:");
//               if(newAddress == null) {
//                  return;
//               }
//               patientToUpdate.setAddress(newAddress);
//               break;
//            default:
//               JOptionPane.showMessageDialog(null, "Invalid choice, please try again!");
//               break;
//         }
//         Save_To_Database();
//         JOptionPane.showMessageDialog(null, "Patient successfully updated!");
//      } 
//      else {
//         JOptionPane.showMessageDialog(null, "Patient not found!");
//      }
//   }

//   //Delete
//   public static void Delete_Patient() {
//      String[] options = {"Individual Record", "All Records", "Cancel"};
//      int choice = JOptionPane.showOptionDialog(null, "What do you want to delete?", "Delete", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
//      switch (choice) {
//         case 0:
//            String Name = JOptionPane.showInputDialog(null, "Enter complete name to delete:");
//            if(Name == null) {
//               return;
//            }
//            
//            String Address = JOptionPane.showInputDialog(null, "Enter corresponding address:");
//            if(Address == null) {
//               return;
//            }
//         
//            boolean removed = false;
//            for (Patient patient : Patient_List) {
//               if (patient.getCName().equalsIgnoreCase(Name) && patient.getAddress().equalsIgnoreCase(Address)) {
//                  Patient_List.remove(patient);
//                  removed = true;
//                  break;
//               }
//            }
//            if (removed) {
//               Save_To_Database();
//               JOptionPane.showMessageDialog(null, "Patient successfully removed from the database!");
//            } 
//            else {
//               JOptionPane.showMessageDialog(null, "Patient not found!");
//            }
//            break;
//         case 1:
//            Patient_List.clear();
//            Save_To_Database();
//            JOptionPane.showMessageDialog(null, "Database successfully cleared!");
//            break;
//         case 2:
//            return;
//         default:
//            JOptionPane.showMessageDialog(null, "Invalid choice, please try again!");
//            break;
//      }
//   }
   
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
