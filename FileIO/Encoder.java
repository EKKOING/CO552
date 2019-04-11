import java.io.*;
import java.util.Scanner;

/**
can encode a file using a simple shift cipher
@author Roger Wistar
@version 2014/10/15
*/
public class Encoder
{
   /**
   writes the text string to the file
   @param line the string to write
   */
   public void writeString(String line)
   {
      try
      {
         PrintWriter pr = new PrintWriter("codes.txt");
         pr.println(line);
         pr.close();
      }
      catch(IOException ioe)
      {
         System.out.println(ioe);
         System.exit(1);
      }
   }
   
   /**
   encodes a string using a simple shift cipher
   @param input the input string
   @return the string input, with each character shifted by 3
   */
   public String encode(String input)
   {
      String output = "";
      String scramble = "";
      for(int idx = 0; idx < input.length(); idx++)
      {
         char temp = input.charAt(idx);
         temp+= 3;
      
         scramble = scramble + Integer.toHexString((temp * 13) % 7);
      }
      
      System.out.println(scramble);
      
      for (int idx = 0; idx < scramble.length(); idx++)
      {
         char temp = scramble.charAt(idx);
         char temp1 = scramble.charAt(idx);
         
         if (idx < scramble.length() - 1)
         {
            temp1 = input.charAt(scramble.length() - (idx + 1));
         }
         else
         {
            temp1 = input.charAt(0);
         }
         
         temp+= 3;
         temp1-= 3;
      
         output = output + Integer.toHexString((temp1 * 199) % 37 + (temp * 197) % 17) + Integer.toHexString((temp * 199) % 37 + (temp1 * 197) % 17);
      }
      return output;
   }
   
   public static void main(String[] args)
   {
      Encoder encoder = new Encoder();
      
      Scanner reader = new Scanner(System.in);
      System.out.print("Enter string to translate: ");
      String input = reader.nextLine();
      
      String inputCoded = encoder.encode(input);
      System.out.println(input + " -> " + inputCoded);
      encoder.writeString(inputCoded);
      System.out.println("File codes.txt updated");
      
      boolean match = true;
      int test = 124;
      while (match == false)
      {
         String compareCoded = encoder.encode(test + "");
         System.out.println(test + " -> " + compareCoded);
         if (compareCoded.equals(inputCoded))
         {
            System.out.println("Hashing Failed: Match found at " + test);
            match = true;
         }
         test++;
      }
   }
}