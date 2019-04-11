import java.util.Scanner;

/**
Lab to Practice Use of Parameters
@author Nicholas Lorentzen and David Lloyd George
@version 2018/09/26
*/
public class PirateTalker
{

   /**
   In this method, a user inputs a sentence and has it translated
   to David Speak.
   */
   public static void main(String[] args)
   {
      Scanner reader = new Scanner(System.in);
      
      /** Enters and stores sentence for translation. */
      String input;
      System.out.print("Enter your sentence for translation to David Speak: ");
      input = reader.nextLine();
      System.out.println(input);
      
      String output = input;
      
      output = output.replaceAll("hi ", "hoi piloi");
      
      output = output.replaceAll("Hi ", "Hoi piloi");
      
      output = output.replaceAll("hello", "higgins bread");
      
      output = output.replaceAll("Hello", "Higgins bread");
      
      output = output.replaceAll("you all", "riffraffs");
      
      output = output.replaceAll("You all", "Riffraffs");
      
      output = output.replaceAll("Y'all", "Riffraffs");
      
      output = output.replaceAll("y'all", "riffraffs");
      
      output = output.replaceAll("you", "home boy");
      
      output = output.replaceAll("You", "Home boy");
      
      output = output.replaceAll("a challenge has begun", "the game is afoot");
      
      output = output.replaceAll("A challenge has begun", "The game is afoot");
      
      output = output.replaceAll("the tables have turned", "my how the turn tables");
      
      output = output.replaceAll("boy", "boi");
      
      output = output.replaceAll("boys", "bois");
      
      output = output.replaceAll("What are you doing", "Boiyardee");
      
      output = output.replaceAll("Who did", "Whomst've done");
      
      output = output.replaceAll("Who is", "Whomst");
      
      output = output.replaceAll("Who has", "Whomst've");
      
      System.out.println("The sentence \"" + input + "\" translated to \nDavid " + 
         "Speak is \"" + output + ".\"");
   
   }

}