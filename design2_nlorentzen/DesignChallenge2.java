import java.util.Random;
import java.util.Scanner;

/**
Design Challenge 2
@author Nicholas Lorentzen, Ben Meyers, Max Duchesne, Jed Thomas
@version 2018/09/28
*/
public class DesignChallenge2
{
   public static final int ATTACK = 10;
   public static final int BLOCKED_ATTACK = 5;
   
   public static void main(String[] args)
   {
      Scanner reader = new Scanner(System.in);
      
      Random gen = new Random();
      System.out.print("Do you want to play a game? \n" + 
         "Enter your name: ");
      String myName;
      myName = reader.nextLine();
      
      int myHealth = 100;
      int enemyHealth = 100;
      int myBlock = 0;
      int enemyChoice;
      int enemyBlock = 0;
      int counter = 0;
      int choice;
      while(myHealth > 0)
      {
         if (enemyHealth <=0) 
         {
            System.out.println("YOU KILLED AN ENEMY");
            System.out.println("A new enemy approaches!");
            enemyHealth = 100;
            counter = counter + 1;
         }
      
         System.out.println("Your current health is " + myHealth + ".");
         System.out.println("The enemy's health is " + enemyHealth + ".");
         System.out.println("Do you want to attack(1) or defend(2)?");
         choice =new Integer(reader.nextLine());
         if (choice == 1)
         {  
            System.out.println("You chose attack!");
            enemyHealth = enemyHealth - (ATTACK + myBlock);
            enemyChoice = 1 + gen.nextInt(2);
            
            if (enemyChoice == 1)
            {  
               System.out.println("Enemy chose attack!");
               myHealth = myHealth - (ATTACK + enemyBlock);
            }
            if (enemyChoice == 2)
            {  
               System.out.println("Enemy chose defend!");
               enemyHealth = enemyHealth + BLOCKED_ATTACK;
            }
         }
         if (choice == 2)
         {  
            System.out.println("You chose defend!");
            enemyChoice = 1 + gen.nextInt(2);
            System.out.println(enemyChoice);
            if (enemyChoice == 1)
            {  
               System.out.println("Enemy chose attack!");
               myHealth = myHealth - (ATTACK + enemyBlock);
               myHealth = myHealth + BLOCKED_ATTACK;
               myBlock = myBlock + 5;
            }
            if (enemyChoice == 2)
            {  
               System.out.println("Enemy chose defend!");
            }
         }
      
          
      }
      System.out.println(myName + ", you died!");
      System.out.println("You killed " + counter + " enemies!");
      System.out.println("Thanks for playing! GAME OVER");
   }
}