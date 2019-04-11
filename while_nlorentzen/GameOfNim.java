import java.util.Scanner;
import java.util.Random;
/**
Program to play a game of subtraction with the user
@author Nicholas Lorentzen
@version 2018-11-11
*/
public class GameOfNim
{
   /** Stores the player number for the user */
   public static final int USER = 1;
   
   /** Stores the player number for the computer */
   public static final int COMP = 2;
   
   /** Stores the starting number of stones */
   public static final int MAXSTONES = 25;

	/**
	 Creates and plays a game of subtraction with the user
	*/
   public void playGame()
   {
      int numStones = MAXSTONES;
      while (numStones > 0)
      {
         System.out.println("There are currently " + numStones);
         int userMove = getUserMove();
         numStones = numStones - userMove;
         if (numStones <= 0)
         {
            System.out.println("User Won! GG!");
         }
         else if (numStones > 0)
         {
            Random gen = new Random();
            int compMove = 1 + gen.nextInt(3);
            numStones = numStones - compMove;
            if (numStones <= 0)
            {
               System.out.println("Computer Won! GG!");
            }
         }
      }
   }
   
	/**
	Asks for input from the user for the game and outputs an integer
   @return The integer of the user's chosen move
	*/
   public int getUserMove()
   {
      Scanner reader = new Scanner(System.in);
   	
      System.out.print("Enter your move (1-3): ");
      String input = reader.nextLine();
      int num = new Integer(input);
   	
      return num;
   }
   
   public static void main(String[] args)
   {
      GameOfNim game = new GameOfNim();
      game.playGame();
   }
}