import java.util.Scanner;

/**
Base program for Number Primitives lab
@author YOUR NAME HERE
@version TODAY'S DATE HERE
*/
public class NumberLab2
{
   public static void main(String[] args)
   {
      Scanner reader = new Scanner(System.in);
   	
      int input;
      input = 0;
      while(input != -1)
      {
         System.out.print("Enter a number: ");
         input = new Integer(reader.nextLine());
      	
         System.out.println("You entered " + input);
      }
   	
   }
}