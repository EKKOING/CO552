import java.util.Scanner;
import java.util.Random;
/**
Tests the BattleShip game
@author Nick A. Nick L. Max D. Alex T.
@version 10/26/19
*/

public class TestChallenge
{
   public static void main(String[] args)
   {
      System.out.println("Ready to play BattleShip?");
      
      System.out.println("Press q,w,e,a,s,d,z,x,c to guess where the battle"
         + "ships are!");
   
      Scanner sc = new Scanner(System.in);
      String coordinateInput = sc.nextLine();
      
      int coordinate = 0;
      
      Random gen = new Random();
      int shipLocation = 1 + gen.nextInt(9);
      hitscan test = new hitscan(shipLocation);
      shipLocation = 1 + gen.nextInt(9);
      test.changeLocation(shipLocation);
      
      
      if(coordinateInput == "q")
      {
         coordinate = 1;
      }
      if(coordinateInput == "w")
      {
         coordinate = 2;
      }
   
      if(coordinateInput == "e")
      {
         coordinate = 3;
      }
   
      if(coordinateInput == "a")
      {
         coordinate = 4;
      }
   
      if(coordinateInput == "s")
      {
         coordinate = 5;
      }
   
      if(coordinateInput == "d")
      {
         coordinate = 6;
      }
   
      if(coordinateInput == "z")
      {
         coordinate = 7;
      }
      if(coordinateInput == "x")
      {
         coordinate = 8;
      }
      if(coordinateInput == "c")
      {
         coordinate = 9;
      }
      test.guessLocation(coordinate);
      if (test.checkHit() == true)
      {
         System.out.println("You Won");
      }
      {
         System.out.println("You Lost");
      }
      System.out.println("You had " + test.checkGuess() + " guesses");
      
      System.out.println("Do you want to know where the ship was? (yes/no)");
      coordinateInput = sc.nextLine();
      
      
      System.out.println("It was at coordinate " + test.whereShipAt(shipLocation));
      
   
   }

}