import java.util.Scanner;
import java.util.Random;

public class IT_BTM_PPT01_BACAY
{
   public static void main(String[] args)
   {
      //Initialize methods
      Scanner input = new Scanner(System.in);
      Random rand = new Random();
    
      //Declare variables data types
      int playerScore = 0;
      int computerScore = 0;
      int round_count = 1, i;
      int [][] scores = new int [9999][2];

      //Utilize While Loop and End when score turned to 5
      do
      {
         System.out.print("Enter Rock, Paper, or Scissor: ");
         String playerChoice = input.nextLine();
         int computerChoice = rand.nextInt(3) + 1;
         
         //Computer chose Rock block
         if (computerChoice == 1) 
         {
            System.out.println("Computer chose Rock");
            if (playerChoice.equalsIgnoreCase("Rock")) 
            {
               System.out.println("Round " + round_count + ": " + "It's a Draw!");
            }
            else if (playerChoice.equalsIgnoreCase("Paper")) 
            {
               System.out.println("Round " + round_count + ": " + "You Win!");
               playerScore++;
               scores[round_count][0] = playerScore;
            }
            else if (playerChoice.equalsIgnoreCase("Scissor")) 
            {
               System.out.println("Round " + round_count + ": " + "Computer Wins!");
               computerScore++;
               scores[round_count][1] = computerScore;
            }
         }
         
         //Computer chose Paper block
         else if (computerChoice == 2) 
         {
         System.out.println("Computer chose Paper");
            if (playerChoice.equalsIgnoreCase("Rock")) 
            {
               System.out.println("Round " + round_count + ": " + "Computer Wins!");
               computerScore++;
               scores[round_count][1] = computerScore;
            }
            else if (playerChoice.equalsIgnoreCase("Paper")) 
            {
               System.out.println("Round " + round_count + ": " + "It's a Draw!");
            }
            else if (playerChoice.equalsIgnoreCase("Scissor")) 
            {
               System.out.println("Round " + round_count + ": " + "You Win!");
               playerScore++;
               scores[round_count][0] = playerScore;
            }
         }
         
         //Computer chose Scissor block
         else if (computerChoice == 3) 
         {
         System.out.println("Computer chose Scissor");
            if (playerChoice.equalsIgnoreCase("Rock")) 
            {
               System.out.println("Round " + round_count + ": " + "You Win!");
               playerScore++;
               scores[round_count][0] = playerScore;
            }
            else if (playerChoice.equalsIgnoreCase("Paper")) 
            {
               System.out.println("Round " + round_count + ": " + "Computer Wins!");
               computerScore++;
               scores[round_count][1] = computerScore;
            }
            else if (playerChoice.equalsIgnoreCase("Scissor"))
            {
               System.out.println("Round " + round_count + ": " + "It's a Draw!");
            }
         }
         
         //Print out the Scores
         System.out.println("Player Score: " + playerScore + " Computer Score: " + computerScore);
         round_count++;
      } while (playerScore < 5 && computerScore < 5);
      //Show the Final Result
      if (playerScore == 5) 
      {
         System.out.println("You Won the Game! Congratulations!");
      }
      else 
      {
         System.out.println("Computer Won the Game! Better Luck Next Time.");
      }
   }
}
