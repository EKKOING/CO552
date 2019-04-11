import java.util.Scanner;

/**
Base program for Number Primitives lab
@author Liz Williams and Nicholas Lorentzen 
@version 2018/09/10
*/
public class NumberLab
{
   public static void main(String[] args)
   {
 Scanner reader = new Scanner(System.in);  
   
 int input;
 double avg;
 int num;
 input = 0;
 num = 0;
 avg = 0;
 while(input != -1)
 {

   System.out.print("Enter a number: ");
   input = new Integer(reader.nextLine());
   System.out.println("You entered " + input);
   avg = input + avg;
   num = num + 1;  
   }
   System.out.println("You entered " + num + " Numbers");
   avg = avg / num;
   System.out.println("Your average was " + avg);

   }
}