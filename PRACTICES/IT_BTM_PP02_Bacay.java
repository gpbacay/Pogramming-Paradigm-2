import java.util.Scanner;

public class IT_BTM_PP02_Bacay
{
   public static void main(String args[])
   {
      Scanner input = new Scanner(System.in);
      Person person = new Person();
      Person person1 = new Person("Gianne", "Bacay");
      
      System.out.print("Enter First Name: ");
      String fname = input.nextLine();
      
      System.out.print("Enter Last Name: ");
      String lname = input.nextLine();
      
      person.setFName(fname);
      person.setLName(lname);
      
      System.out.println("First Name: " + person.getFName());
      System.out.println("Last Name: " + person.getLName());
      System.out.println("Full Name: " + person.getCName());
      
      System.out.println("First Name: " + person1.getFName());
      System.out.println("Last Name: " + person1.getLName());
      System.out.println("Full Name: " + person1.getCName());
   }
}
