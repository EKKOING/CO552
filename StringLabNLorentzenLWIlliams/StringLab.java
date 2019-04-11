import java.util.Scanner;
import java.util.Random;

/**
Lab to Practice Use of Strings
@author Nicholas Lorentzen and Liz Williams
@version 2018/09/12
*/
public class StringLab
{
   public static void main(String[] args)
   {
      Scanner reader = new Scanner(System.in);
      
      //Declaration of Variables
      String firstName;
      String lastName;
      String userName;
      
      String done = "no";
      while(done.equals("yes") == false)
      {
         //Enter and print First Name
         System.out.print("Enter your first name: ");
         firstName = reader.nextLine();
         System.out.println("Your first name is " + firstName);
         
         //Enter and print Last Name
         System.out.print("Enter your last name: ");
         lastName = reader.nextLine();
         System.out.println("Your last name is " + lastName);
        
         //Generate username from first and last name
         userName = firstName + " " + lastName;
         System.out.println("Your username is " + userName);
        
         //Genrate modified username
         userName = firstName.substring(0,1) + lastName;
         System.out.println("Your shortened username is " + userName);

         
         System.out.print("Want to quit? Type yes:");
         done = reader.nextLine();
      }
   }

}