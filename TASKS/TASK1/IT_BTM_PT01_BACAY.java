import java.util.Scanner;
import java.util.Random;

public class IT_BTM_PT01_BACAY 
{
   public static void divider()// New method for dividing sections
   {
      System.out.println("=============================================================");
   }

   public static void main(String[] args) 
   {
      // Initialize methods
      Scanner input = new Scanner(System.in);
      Random rand = new Random();
      
      char PlayAgain;
      
      do
      {
         // Declare variables data types
         int playerScore = 0;
         int computerScore = 0;
         int round_count = 1, i, arrayslot = 0;
         int[] playerScores = {};
         int[] computerScores = {};
         int[] tempplayerScores = {};
         int[] tempcomputerScores = {};
         int FinalScore = 0;
         int Win = 0, Lose = 1, Draw = 2;
         boolean loop = true;
         int requiredFS = 0;
         String STRrequiredFS;
         String result = "";
         String partial_result = "";
         String FinalResult = "";
         
         // Welcome message
         divider();
         System.out.print("          WELCOME TO ROCK, PAPER, or SCISSOR GAME!\n");
         divider();
         
         requiredFS = 0;
         if (requiredFS == 0) 
         {
            while (loop == true)
            {
            // Required FInal Score Selection
               System.out.print("\nChoose a required final score to win the game [3/5]: ");
               try 
               {
                  requiredFS = input.nextInt();
               }
               catch (Exception ex)
               {
                  STRrequiredFS = Integer.toString(requiredFS);
                  STRrequiredFS = input.nextLine();
               }
               
               if (requiredFS == 3) 
               {
                  FinalScore = 3;
                  break;
               }
               else if (requiredFS == 5) 
               {
                  FinalScore = 5;
                  break;
               }
               else
               {
                  divider();
                  System.out.print("Invalid Input! Try Again.");
                  System.out.print("\n");
                  divider();
                  continue;
               }
            
            }
         }
         divider();
         System.out.print("Note: You've chose a Race to " + FinalScore + " Rock, Paper, or Scissor Game.\n");
         System.out.print("The first one who will attain a score of " + FinalScore + " will win the game.\n");
         divider();
         System.out.print("                     LET THE GAME BEGIN!\n");
         divider();
      
         input.nextLine();
         // Utilize While Loop and End when score turned to the chosen Final Score
         do 
         {
            // Prompt for player input
            System.out.print("Enter Rock, Paper, or Scissor: ");
            String playerChoice = input.nextLine();
            // computer input
            int computerChoice = rand.nextInt(3) + 1;
         
            // Computer chose Rock block
            if (computerChoice == 1)
            {
               if (playerChoice.equalsIgnoreCase("Rock"))
               {
                  System.out.println("\nComputer chose Rock");
                  arrayslot++;
                  System.out.println("Round " + round_count + ": " + "It's a Draw!");
                  tempplayerScores = new int[arrayslot];
                  tempcomputerScores = new int[arrayslot];
                  if (arrayslot != 1) 
                  {
                     for (i = 0; i < arrayslot - 1; i++)
                     {
                        tempplayerScores[i] = playerScores[i];
                        tempcomputerScores[i] = computerScores[i];
                     }
                  }
                  tempplayerScores[arrayslot - 1] = Draw;
                  tempcomputerScores[arrayslot - 1] = Draw;
                  playerScores = new int[arrayslot];
                  computerScores = new int[arrayslot];
               
                  for (i = 0; i < arrayslot; i++)
                  {
                     playerScores[i] = tempplayerScores[i];
                     computerScores[i] = tempcomputerScores[i];
                  }
                  round_count++;
               }
               else if (playerChoice.equalsIgnoreCase("Paper"))
               {
                  System.out.println("\nComputer chose Rock");
                  arrayslot++;
                  System.out.println("Round " + round_count + ": " + "You Win!");
                  playerScore++;
                  tempplayerScores = new int[arrayslot];
                  tempcomputerScores = new int[arrayslot];
                  if (arrayslot != 1)
                  {
                     for (i = 0; i < arrayslot - 1; i++)
                     {
                        tempplayerScores[i] = playerScores[i];
                        tempcomputerScores[i] = computerScores[i];
                     }
                  }
                  tempplayerScores[arrayslot - 1] = Win;
                  tempcomputerScores[arrayslot - 1] = Lose;
                  playerScores = new int[arrayslot];
                  computerScores = new int[arrayslot];
                  for (i = 0; i < arrayslot; i++)
                  {
                     playerScores[i] = tempplayerScores[i];
                     computerScores[i] = tempcomputerScores[i];
                  }
                  round_count++;
               }
               else if (playerChoice.equalsIgnoreCase("Scissor"))
               {
                  System.out.println("\nComputer chose Rock");
                  arrayslot++;
                  System.out.println("Round " + round_count + ": " + "Computer Wins!");
                  computerScore++;
                  tempplayerScores = new int[arrayslot];
                  tempcomputerScores = new int[arrayslot];
                  if (arrayslot != 1)
                  {
                     for (i = 0; i < arrayslot - 1; i++)
                     {
                        tempplayerScores[i] = playerScores[i];
                        tempcomputerScores[i] = computerScores[i];
                     }
                  }
                  tempplayerScores[arrayslot - 1] = Lose;
                  tempcomputerScores[arrayslot - 1] = Win;
                  playerScores = new int[arrayslot];
                  computerScores = new int[arrayslot];
                  for (i = 0; i < arrayslot; i++)
                  {
                     playerScores[i] = tempplayerScores[i];
                     computerScores[i] = tempcomputerScores[i];
                  }
                  round_count++;
               }
               else
               {
                  divider();
                  System.out.print("Invalid Input! Please try again.\n");
                  divider();
               }
            }
            
            // Computer chose Paper block
            else if (computerChoice == 2)
            {
               // Player chose Rock block
               if (playerChoice.equalsIgnoreCase("Rock"))
               {
                  System.out.println("\nComputer chose Paper");
                  arrayslot++;
                  System.out.println("Round " + round_count + ": " + "Computer Wins!");
                  computerScore++;
                  tempplayerScores = new int[arrayslot];
                  tempcomputerScores = new int[arrayslot];
                  if (arrayslot != 1)
                  {
                     for (i = 0; i < arrayslot - 1; i++)
                     {
                        tempplayerScores[i] = playerScores[i];
                        tempcomputerScores[i] = computerScores[i];
                     }
                  }
                  tempplayerScores[arrayslot - 1] = Lose;
                  tempcomputerScores[arrayslot - 1] = Win;
                  playerScores = new int[arrayslot];
                  computerScores = new int[arrayslot];
                  for (i = 0; i < arrayslot; i++)
                  {
                     playerScores[i] = tempplayerScores[i];
                     computerScores[i] = tempcomputerScores[i];
                  }
                  round_count++;
               }
               else if (playerChoice.equalsIgnoreCase("Paper"))
               {
                  System.out.println("\nComputer chose Paper");
                  arrayslot++;
                  System.out.println("Round " + round_count + ": " + "It's a Draw!");
                  tempplayerScores = new int[arrayslot];
                  tempcomputerScores = new int[arrayslot];
                  if (arrayslot != 1)
                  {
                     for (i = 0; i < arrayslot - 1; i++)
                     {
                        tempplayerScores[i] = playerScores[i];
                        tempcomputerScores[i] = computerScores[i];
                     }
                  }
                  tempplayerScores[arrayslot - 1] = Draw;
                  tempcomputerScores[arrayslot - 1] = Draw;
                  playerScores = new int[arrayslot];
                  computerScores = new int[arrayslot];
                  for (i = 0; i < arrayslot; i++)
                  {
                     playerScores[i] = tempplayerScores[i];
                     computerScores[i] = tempcomputerScores[i];
                  }
                  round_count++;
               }
               else if (playerChoice.equalsIgnoreCase("Scissor"))
               {
                  System.out.println("\nComputer chose Paper");
                  arrayslot++;
                  System.out.println("Round " + round_count + ": " + "You Win!");
                  playerScore++;
                  tempplayerScores = new int[arrayslot];
                  tempcomputerScores = new int[arrayslot];
                  if (arrayslot != 1)
                  {
                     for (i = 0; i < arrayslot - 1; i++)
                     {
                        tempplayerScores[i] = playerScores[i];
                        tempcomputerScores[i] = computerScores[i];
                     }
                  }
                  tempplayerScores[arrayslot - 1] = Win;
                  tempcomputerScores[arrayslot - 1] = Lose;
                  playerScores = new int[arrayslot];
                  computerScores = new int[arrayslot];
                  for (i = 0; i < arrayslot; i++)
                  {
                     playerScores[i] = tempplayerScores[i];
                     computerScores[i] = tempcomputerScores[i];
                  }
                  round_count++;
               }
               else
               {
                  divider();
                  System.out.print("Invalid Input! Please try again.\n");
                  divider();
               }
            }
            
            // Computer chose Scissor block
            else if (computerChoice == 3)
            {
               if (playerChoice.equalsIgnoreCase("Rock"))
               {
                  System.out.println("\nComputer chose Scissor");
                  arrayslot++;
                  System.out.println("Round " + round_count + ": " + "You Win!");
                  playerScore++;
                  tempplayerScores = new int[arrayslot];
                  tempcomputerScores = new int[arrayslot];
                  if (arrayslot != 1)
                  {
                     for (i = 0; i < arrayslot - 1; i++)
                     {
                        tempplayerScores[i] = playerScores[i];
                        tempcomputerScores[i] = computerScores[i];
                     }
                  }
                  tempplayerScores[arrayslot - 1] = Win;
                  tempcomputerScores[arrayslot - 1] = Lose;
                  playerScores = new int[arrayslot];
                  computerScores = new int[arrayslot];
                  for (i = 0; i < arrayslot; i++)
                  {
                     playerScores[i] = tempplayerScores[i];
                     computerScores[i] = tempcomputerScores[i];
                  }
                  round_count++;
               }
               else if (playerChoice.equalsIgnoreCase("Paper"))
               {
                  System.out.println("\nComputer chose Scissor");
                  arrayslot++;
                  System.out.println("Round " + round_count + ": " + "Computer Wins!");
                  computerScore++;
                  tempplayerScores = new int[arrayslot];
                  tempcomputerScores = new int[arrayslot];
                  if (arrayslot != 1)
                  {
                     for (i = 0; i < arrayslot - 1; i++)
                     {
                        tempplayerScores[i] = playerScores[i];
                        tempcomputerScores[i] = computerScores[i];
                     }
                  }
                  tempplayerScores[arrayslot - 1] = Lose;
                  tempcomputerScores[arrayslot - 1] = Win;
                  playerScores = new int[arrayslot];
                  computerScores = new int[arrayslot];
                  for (i = 0; i < arrayslot; i++)
                  {
                     playerScores[i] = tempplayerScores[i];
                     computerScores[i] = tempcomputerScores[i];
                  }
                  round_count++;
               } else if (playerChoice.equalsIgnoreCase("Scissor"))
               {
                  System.out.println("\nComputer chose Scissor");
                  arrayslot++;
                  System.out.println("Round " + round_count + ": " + "It's a Draw!");
                  tempplayerScores = new int[arrayslot];
                  tempcomputerScores = new int[arrayslot];
                  if (arrayslot != 1)
                  {
                     for (i = 0; i < arrayslot - 1; i++)
                     {
                        tempplayerScores[i] = playerScores[i];
                        tempcomputerScores[i] = computerScores[i];
                     }
                  }
                  tempplayerScores[arrayslot - 1] = Draw;
                  tempcomputerScores[arrayslot - 1] = Draw;
                  playerScores = new int[arrayslot];
                  computerScores = new int[arrayslot];
                  for (i = 0; i < arrayslot; i++)
                  {
                     playerScores[i] = tempplayerScores[i];
                     computerScores[i] = tempcomputerScores[i];
                  }
                  round_count++;
               }
               else
               {
                  divider();
                  System.out.print("Invalid Input! Please try again.\n");
                  divider();
               }
            }
         
            // Print out the Scores
            divider();
            System.out.println("Player Score: " + playerScore + " Computer Score: " + computerScore);
            divider();
         } while (playerScore != FinalScore && computerScore != FinalScore);
      
         // Show the Final Result
         if (playerScore == FinalScore)
         {
            divider();
            System.out.println("YOU WON THE GAME! CONGRATULATIONS!");
            FinalResult = "PLAYER WON";
            divider();
         }
         else
         {
            divider();
            System.out.println("COMPUTER WON THE GAME! BETTER LUCK NEXT TIME!");
            FinalResult = "COMPUTER WON";
            divider();
         }
      
         System.out.println("\n");
         divider();
         System.out.println("                         GAME HISTORY");
         divider();
         for (i = 0; i < arrayslot; i++)
         {
            if (playerScores[i] == computerScores[i])
            {
               result = "Draw";
            } else if (playerScores[i] < computerScores[i])
            {
               result = "Player Won";
            } else if (playerScores[i] > computerScores[i])
            {
               result = "Computer Won";
            }
            System.out.println("Round " + (i + 1) + ": " + result);
         }
         divider();
         System.out.println("Player Score: " + playerScore + " Computer Score: " + computerScore);
         System.out.println("Final Result: " + FinalResult);
         divider();
      
         System.out.print("Do you want to play again? [Y/N]: ");
         PlayAgain = input.next().charAt(0);
      
      } while (PlayAgain == 'y' || PlayAgain == 'Y'); //playerChoice.equalsIgnoreCase("Rock")
   }
}
