import java.util.Random;
import java.util.Scanner;

/**
Base program for Number Primitives lab
@author Nicholas Lorentzen and Alex Tam
@version 2018/09/20
*/
public class PNCreator
{
   public static void main(String[] args)
   {
      Random gen = new Random();
      int randNum1 = 100 + gen.nextInt(900); // randNum = random from 100-999
      int randNum2 = 100 + gen.nextInt(900); // randNum = random from 100-999
      int randNum3 = 1000 + gen.nextInt(9000); // randNum = random from 1000-999
   
   
   
      System.out.println("(" + randNum1 + ")" + randNum2 + "-" + randNum3);
   }
}