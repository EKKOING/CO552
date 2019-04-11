import java.io.*;
import java.util.Scanner;

/**
can decode a file using a simple shift cipher
@author Roger Wistar
@version 2014/10/15
*/
public class Decoder
{
   /**
   reads the text string from the file
   @return the string that was read
   */
   public String readString()
   {
      try
      {
         BufferedReader br = new BufferedReader(new FileReader("codes.txt"));
         String input = br.readLine();
         br.close();
         
         return input;
      }
      catch(IOException ioe)
      {
         System.out.println(ioe);
         System.exit(1);
      }
      
      return null;
   
   }
   
   /**
   decodes a string using a simple shift cipher
   @param input the input string
   @return the string input, with each character shifted by 3
   */
   public String decode(String input)
   {
      String output = "";
      for(int idx = 0; idx < input.length(); idx++)
      {
         char temp = input.charAt(idx);
         temp--;
         temp--;
         temp--;
         output = output + temp;
      }
      return output;
   }   
   
   public static void main(String[] args)
   {
      Decoder decoder = new Decoder();
      
      String output = decoder.readString();
      String outputCoded = decoder.decode(output);
      System.out.println(output + " -> " + outputCoded);
   }
}