import java.util.Scanner;

public class ASA
{
   //Declare Ticket Number data type
   static int Ticket_Number = 0;
   
   //Declare a new array size for Seats 2D array  
   static String Seats [][] = new String [13][6];
   
   // New method for dividing sections
   public static void divider()
   {
      System.out.println("==============================================");
   }
   
   //Seats Initialization method
   public static void Init_Seats()
   {
      for (int i=0; i<13; i++)
      {
         for (int j=0; j<6; j++)
            if (j == 2)
            {
               Seats[i][j] = "* ";
            }
            else
            {
               Seats[i][j] = "*";
            }
      }
   }
   
   //Show Selected Seat method
   public static void Show_Seats()
   {
      for (int i=0; i13; i++)
      {
         if (i==2)
         {
            System.out.print("\nRow " + (i+1) + "    ");
         }
         else if (i==7)
         {
            System.out.print("\nRow " + (i+1) + "    ");
         }
         else if (i<9)
         {
            System.out.print("Row " + (i+1) + "    ");
         }
         else
         {
            System.out.print("Row " + (i+1) + "   ");
         }
         for(int j=0; j<6;j++)
            System.out.print(Seats[i][j] + " ");
         System.out.println();
      }
   }
   
   //Main method
   public static void main(String args[])
   {
      Scanner input = new Scanner (System.in);
   
      //declare Buy_Again data type
      char Buy_Again = ' ';
      
      //Declare data types of other variables
      int Ticket_Type = 0, Seat_Row = 0, Seat_Column_Number = 0;
      char Seat_Column = ' ';
      boolean loop = true;
      String Ticket_Type_String = "";
      String Seat_Row_String = "";
      
      //Call out the Initialization method for Seats
      Init_Seats();
      
      divider();
      System.out.print("            WELCOME TO ASA AIRLINE!   \n");
      
      //Main Do-while Loop
      do
      {
         Ticket_Number++;
         divider();
         System.out.print("                  TICKET TYPE\n");
         divider();
         System.out.print("[1] First Class\n[2] Business Class\n[3] Economy Class\n");
         divider();
         
         //Prompt for Ticket Type input
         do
         {
            System.out.print("Ticket #" + (Ticket_Number) + ":");
            System.out.print("\nSelect a Ticket Type: ");
            try 
            {
               Ticket_Type = input.nextInt();
            }
            catch (Exception ex)
            {
               Ticket_Type_String = Integer.toString(Ticket_Type);
               Ticket_Type_String = input.nextLine();
               divider();
               System.out.print("Invalid Input! Try Again.\n");
               divider();
               continue;
            }
                  
            //First Class block
            if (Ticket_Type == 1)
            {
               do
               {
                  System.out.print("Select a Row [1-2]: ");
                  try 
                  {
                     Seat_Row = input.nextInt();
                  }
                  catch (Exception ex)
                  {
                     Seat_Row_String = Integer.toString(Ticket_Type);
                     Seat_Row_String = input.nextLine();
                     divider();
                     System.out.print("Invalid Input! Try Again.\n");
                     divider();
                     continue;
                  }
                  if (Seat_Row < 1 || Seat_Row > 2)
                  {
                     divider();
                     System.out.print("Invalid Input! Try Again.\n");
                     divider();
                     continue;
                  }
                  else if (Seat_Row >= 1 && Seat_Row <= 2)
                  {
                     break;
                  }
                  else
                  {
                     divider();
                     System.out.print("Invalid Input! Try Again.\n");
                     divider();
                     continue;
                  }
               } while (loop == true);
               break;
            }
            //Business Class block
            else if (Ticket_Type == 2)
            {
               do
               {
                  System.out.print("Select a Row [3-7]: ");
                  try 
                  {
                     Seat_Row = input.nextInt();
                  }
                  catch (Exception ex)
                  {
                     Seat_Row_String = Integer.toString(Ticket_Type);
                     Seat_Row_String = input.nextLine();
                     divider();
                     System.out.print("Invalid Input! Try Again.\n");
                     divider();
                     continue;
                  }
                  if (Seat_Row < 3 || Seat_Row > 7)
                  {
                     divider();
                     System.out.print("Invalid Input! Try Again.\n");
                     divider();
                     continue;
                  }
                  else if (Seat_Row >= 3 && Seat_Row <= 7)
                  {
                     break;
                  }
                  else
                  {
                     divider();
                     System.out.print("Invalid Input! Try Again.\n");
                     divider();
                     continue;
                  }
               } while (loop == true);
               break;
            }
            //Economy Class block
            else if (Ticket_Type == 3)
            {
               do
               {
                  System.out.print("Select a Row [8-13]: ");
                  try 
                  {
                     Seat_Row = input.nextInt();
                  }
                  catch (Exception ex)
                  {
                     Seat_Row_String = Integer.toString(Ticket_Type);
                     Seat_Row_String = input.nextLine();
                     divider();
                     System.out.print("Invalid Input! Try Again.\n");
                     divider();
                     continue;
                  }
                  if (Seat_Row < 8 || Seat_Row > 13)
                  {
                     divider();
                     System.out.print("Invalid Input! Try Again.\n");
                     divider();
                     continue;
                  }
                  else if (Seat_Row >= 8 && Seat_Row <= 13)
                  {
                     break;
                  }
                  else
                  {
                     divider();
                     System.out.print("Invalid Input! Try Again.\n");
                     divider();
                     continue;
                  }
               } while (loop == true);
               break;
            }
            else
            {
               divider();
               System.out.print("Invalid Input! Try Again.\n");
               divider();
               continue;
            }
         } while (loop == true);
         
         do
         {
            //Promt for Seat Column input
            System.out.print("Select a Seat [A-F]: ");
            Seat_Column = input.next().charAt(0);
            
            //Convert char to int
            if (Seat_Column == 'a' || Seat_Column == 'A')
            {
               Seat_Column_Number = 1;
            }
            else if (Seat_Column == 'b' || Seat_Column == 'B')
            {
               Seat_Column_Number = 2;
            }
            else if (Seat_Column == 'c' || Seat_Column == 'C')
            {
               Seat_Column_Number = 3;
            }
            else if (Seat_Column == 'd' || Seat_Column == 'D')
            {
               Seat_Column_Number = 4;
            }
            else if (Seat_Column == 'e' || Seat_Column == 'E')
            {
               Seat_Column_Number = 5;
            }
            else if (Seat_Column == 'f' || Seat_Column == 'F')
            {
               Seat_Column_Number = 6;
            }
            else
            {
               divider();
               System.out.print("Invalid Input! Try Again.\n");
               divider();
               continue;
            }
            break;
         
         } while (loop == true);
         
         //Prompt for selecting another seat if the seat was already reserved
         if (Ticket_Number != 1)
         {
            if (Seats[Seat_Row - 1][Seat_Column_Number - 1] == "X")
            {
               divider();
               System.out.print("The seat was already reserved.\nPlease select another seat. Thank you!\n");
               Ticket_Number--;
               continue;
            }
         }
         
         //Mark the Booked Seat Location
         Seats[Seat_Row - 1][Seat_Column_Number - 1] = "X";
         
         
         //Show Airplane Seating Arrangement
         divider();
         System.out.println("          AIRPLANE SEATING ARRANGEMENT   ");
         divider();
         System.out.print("         A B C  D E F\n");
         
         //Show Airplane Seating Arrangement/ Call out Show_Seats method
         Show_Seats();
         
         input.nextLine();
         //Prompt for buying another ticket
         do
         {
            System.out.print("\n");
            divider();
            System.out.print("Do you want to buy another ticket? [Y/N]: ");
            Buy_Again = input.next().charAt(0);
            
            if (Buy_Again == 'n' || Buy_Again == 'N')//Prompt if user inputs 'n' or No/ Terminates the program
            {
               divider();
               System.out.print("Thank you for choosing ASA Airline!");
               System.out.print("\nYour seating plan is now booked.\n");
               divider();
               break;
            }
            else if (Buy_Again == 'y' || Buy_Again == 'Y')//breaks loop if user inputs 'y' or Yes/ Repeats the program
            {
               break;
            }
            else
            {
               divider();
               System.out.print("Invalid Input! Try Again.\n");//Prompt if user inputs neither 'n' nor 'y'
               divider();
               continue;
            }
         
         } while (loop == true);
         
      } while (Buy_Again == 'y' || Buy_Again == 'Y');
      
   }
}