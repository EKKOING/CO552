/**
Writing Simple Methods 
@version 10/11/18
@author Liz Williams and Nicholas Lorentzon 
*/
public class TestCandy
{
   public static void main(String[] args)
   {
      CandyMachine test = new CandyMachine();
      System.out.println(test);
      
      test.fillMeUp();
      System.out.println(test);
      
      test.takeCandy();
      test.takeCandy();
      System.out.println(test);
      
      test.emptyCandy();
      System.out.println(test);
   }	
}
