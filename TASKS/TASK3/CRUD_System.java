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
   private static final String FILEPATHNAME = "database.csv";
   //ArrayList
   public static ArrayList<Person> Person_List = new ArrayList<Person>();

   //Scan Database
   public static void Scan_Database() {
      File file = new File(FILEPATHNAME);
      try (Scanner scan = new Scanner(file)) {
         while (scan.hasNextLine()) {
            String[] Line = scan.nextLine().split(",");
            String FName = Line[0];
            String LName = Line[1];
            String Address = Line[2];
            Person person = new Person(FName, LName, Address);
            Person_List.add(person);
         }
      } 
      catch (FileNotFoundException e) {
         JOptionPane.showMessageDialog(null, "Database file not found!");
      }
   }
   
   //Save to Database
   public static void Save_To_Database() {
      try (PrintWriter writer = new PrintWriter(new FileWriter(FILEPATHNAME))) {
         for (Person person : Person_List) {
            writer.println(person.getFName() + "," + person.getLName() + "," + person.getAddress());
         }
         writer.close();
      } 
      catch (IOException e) {
         JOptionPane.showMessageDialog(null, "Failed to save data to file!");
      }
   }
   
   //Display Menu
   public static int Display_Menu() {
      String[] options = {"Create", "Read", "Update", "Delete", "Open", "Exit"};
      return JOptionPane.showOptionDialog(null, "What do you want to do?", "CRUD System", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]) + 1;
   }
   
   //Create
   public static void Create_Person() {
      String FName = JOptionPane.showInputDialog(null, "Enter first name:");
      if(FName == null) {
         return;
      }
      
      String LName = JOptionPane.showInputDialog(null, "Enter last name:");
      if(LName == null) {
         return;
      }
      
      String Address = JOptionPane.showInputDialog(null, "Enter address:");
      if(LName == null) {
         return;
      }
      
      Person person = new Person(FName, LName, Address);
      Person_List.add(person);
      Save_To_Database();
      JOptionPane.showMessageDialog(null, "Person successfully added to the database!");
   }
   
   //Read
   public static void Read_Person() {
      String Name = JOptionPane.showInputDialog(null, "Enter name to search:");
      if(Name == null) {
         return;
      }
      
      boolean personFound = false;
      for (Person person : Person_List) {
         if (person.getCName().equalsIgnoreCase(Name)) {
            JOptionPane.showMessageDialog(null, "Person Found!\n\n" +
               "First Name: " + person.getFName() + "\n" +
               "Last Name: " + person.getLName() + "\n" +
               "Full Name: " + person.getCName() + "\n" + 
               "Address: " + person.getAddress());
            personFound = true;
            break;
         }
      }
      if (!personFound && Name != null) {
         JOptionPane.showMessageDialog(null, "Person not found!");
      }
   }
   
   //Update
   public static void Update_Person() {
      String Name = JOptionPane.showInputDialog(null, "Enter name to update:");
      if(Name == null) {
         return;
      }
      
      Person personToUpdate = null;
      for (Person person : Person_List) {
         if (person.getCName().equalsIgnoreCase(Name)) {
            personToUpdate = person;
            break;
         }
      }
      if (personToUpdate != null) {
         String[] options = {"First Name", "Last Name", "Full Name", "Address"};
         int choice = JOptionPane.showOptionDialog(null, "What do you want to update?", "Update Person", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
         switch (choice) {
            case 0:
               String newFName = JOptionPane.showInputDialog(null, "Enter new first name:");
               if(newFName == null) {
                  return;
               }
               personToUpdate.setFName(newFName);
               break;
            case 1:
               String newLName = JOptionPane.showInputDialog(null, "Enter new last name:");
               if(newLName == null) {
                  return;
               }
               personToUpdate.setLName(newLName);
               break;
            case 2:
               String newCName = JOptionPane.showInputDialog(null, "Enter new complete name:");
               if(newCName == null) {
                  return;
               }
               String[] Names = newCName.split(" ");
               personToUpdate.setFName(Names[0]);
               personToUpdate.setLName(Names[1]);
               break;
            case 3:
               String newAddress = JOptionPane.showInputDialog(null, "Enter new address:");
               if(newAddress == null) {
                  return;
               }
               personToUpdate.setAddress(newAddress);
               break;
            default:
               JOptionPane.showMessageDialog(null, "Invalid choice, please try again!");
               break;
         }
         Save_To_Database();
         JOptionPane.showMessageDialog(null, "Person successfully updated!");
      } 
      else {
         JOptionPane.showMessageDialog(null, "Person not found!");
      }
   }

   //Delete
   public static void Delete_Person() {
      String[] options = {"Person", "All", "Cancel"};
      int choice = JOptionPane.showOptionDialog(null, "What do you want to delete?", "Delete", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
      switch (choice) {
         case 0:
            String Name = JOptionPane.showInputDialog(null, "Enter complete name to delete:");
            if(Name == null) {
               return;
            }
         
            boolean removed = false;
            for (Person person : Person_List) {
               if (person.getCName().equalsIgnoreCase(Name)) {
                  Person_List.remove(person);
                  removed = true;
                  break;
               }
            }
            if (removed) {
               Save_To_Database();
               JOptionPane.showMessageDialog(null, "Person successfully removed from the database!");
            } 
            else {
               JOptionPane.showMessageDialog(null, "Person not found!");
            }
            break;
         case 1:
            Person_List.subList(1, Person_List.size()).clear();
            Save_To_Database();
            JOptionPane.showMessageDialog(null, "Database successfully cleared!");
            break;
         case 2:
            return;
         default:
            JOptionPane.showMessageDialog(null, "Invalid choice, please try again!");
            break;
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