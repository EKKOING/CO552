import java.util.Scanner;

/**
survey program that outputs your answers
@author david lloyd george
@version 11/9/2018
*/
public class SurveyGraph
{
	/** MC (multiple choice) A */
   private int myAnswerA;
	
	/** MC B */
   private int myAnswerB;
	
	/** MC C */
   private int myAnswerC;
	
	/**MC D  */
   private int myAnswerD;
	
   /**
   sets inital values for number of times that each answer is chosen
   */
   public SurveyGraph()
   {
      myAnswerA = 0;
      myAnswerB = 0;
      myAnswerC = 0;
      myAnswerD = 0;
   }
	
   /**
   clears the results for the histogram 
   */
   public void clearResults()
   {
      myAnswerA = 0;
      myAnswerB = 0;
      myAnswerC = 0;
      myAnswerD = 0;
   }
    /**
    creates a histogram based on the number of values of each choice
    */
   public void storeResults(int k)
   {
      String input;
      
      Scanner reader = new Scanner(System.in);
      
      for(int counter = 1; counter <= k; counter++)
      {
         
         System.out.println("enter answer");
         input = reader.nextLine();
         if( input.equals("A"))
         {
            myAnswerA++;
         }
         else if(input.equals("B"))
         {
            myAnswerB++;
         }
         else if(input.equals("C"))
         {
            myAnswerC++;
         }
         else if(input.equals("D"))
         {
            myAnswerD++;
         }
      
      
         
      }
      
   }
   /**
   prints out the results of the histogram
   */
   public void printResults()
   {
      System.out.println( "Results: \nA: " + myAnswerA + "\nB: " + myAnswerB 
         + "\nC: " + myAnswerC + "\nD: " + myAnswerD);
   }
   
   
	/**
	to string method 
   @ return overall results of the survey
	*/
   public String toString()
   {
      return "SurveyGraph[" 
         + myAnswerA + ","
         + myAnswerB + ","
         + myAnswerC + ","
         + myAnswerD + "]";
   }
	
   public static void main(String[] args)
   {
      SurveyGraph tester = new SurveyGraph();
      System.out.println("Begin, now tester = " + tester);
   	
   	 
      tester.storeResults(10);
      System.out.println("Stored, now tester = " + tester);
   	
      tester.printResults();
   	
      tester.clearResults();
      System.out.println("Cleared, now tester = " + tester);
   }
}