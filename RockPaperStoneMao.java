import java.util.*;

public class RockPaperStoneMao {
   static int playerScore = 0;
   static int computerScore = 0;

   public static void main(String[] args) {
      String[] choices = { "Rock", "Paper", "Scissor" };
      Scanner scan = new Scanner(System.in);
      System.out.println("What is your name?");
      String name = scan.next();
      System.out.println("How many rounds do you want to play?");
      int rounds = scan.nextInt();
      play(scan, name, choices, rounds);
   }

   public static void play(Scanner scan, String name, String[] choices,
         int rounds) {
      for (int x = 0; x < rounds; x++) {
         System.out.println("Rock, Paper, or Scissor?");
         String playerChoice = scan.next();
         int compChoiceIndex = (int) (Math.random() * 3);
         String computerChoice = choices[compChoiceIndex];
         System.out.println(name + "'s choice is: " + playerChoice);
         System.out.println("Computer's choice is: " + computerChoice);
         System.out.println(
               "Result: " + winner(playerChoice, computerChoice, choices));
         System.out.println("Player Score: " + playerScore
               + "\t\tComputer Score: " + computerScore + "\n");
      }
      if (playerScore > computerScore) {
         System.out.println("Congrats, you won!");
      } else if (playerScore < computerScore) {
         System.out.println("Sorry, you lost");
      } else {
         System.out.println("Ah, you tied");
      }
   }

   public static String winner(String playerChoice, String computerChoice,
         String[] choice) {
      String[] choices = choice;
      String playr = playerChoice;
      String compr = computerChoice;
      int player = number(playr, choices);
      int computer = number(compr, choices);
      String result = "";
      String[][] outcome = { { "Draw", "Person Wins", "Computer Wins" },
            { "Computer Wins", "Draw", "Person Wins" },
            { "Person Wins", "Computer Wins", "Draw" } };
      for (int r = 0; r < outcome.length; r++) {
         if (r == player) {
            for (int c = 0; c < outcome[r].length; c++) {
               if (c == computer) {
                  result = outcome[c][r];
               }
            }
         }
      }
      if (result.equals("Person Wins")) {
         playerScore++;
      } else if (result.equals("Computer Wins")) {
         computerScore++;
      }
      return result;
   }

   public static int number(String choice, String[] choices) {
      int value = 0;
      for (int x = 0; x < choices.length; x++) {
         if (choices[x].equalsIgnoreCase(choice)) {
            value = x;
         }
      }
      return value;
   }

}
