public class Test
{
   public static final int max = 6;
   public static void main(String[] args)
   {
      
      //Nested Loop Numerical Value
      for(int counter1 = 1; counter1 <= max; counter1++)
      {
         double output = 0;
         for(int digit = 1; digit <= counter1; digit++)
         {
            output = output + digit * Math.pow(10, counter1 - digit);
         }
      System.out.println(output);
      }
      
      //One Loop Version
      String output2 = "";
      for(int counter = 1; counter <= max; counter++)
      {
      output2 = output2 + counter;
      System.out.println(output2);
      }
   
   }
}