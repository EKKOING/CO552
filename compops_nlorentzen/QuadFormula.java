import java.util.Scanner;

/**
Uses the quadratic function to solve equations
@author Nicholas Lorentzen and DJ Lim
@version 10/28/2018
*/
public class QuadFormula
{
	/** Stores the variable "a" from a quadratic equation */
   private double a;

	/** Stores the variable "b" from a quadratic equation */
   private double b;

	/** Stores the variable "c" from a quadratic equation */
   private double c;
   
   /** Stores the value of the the discriminant */
   private double theDisc;
   
   /**
   Creates a new quadratic formula solver with the three variables.
   @param theA The a variable
   @param theB The b variable
   @param theC The c variable
   */
   public QuadFormula(double theA, double theB, double theC)
   {
      a = theA;
      b = theB;
      c = theC;
   }
   
   /**
   Checks for solutions by finding the discriminant.
   @return True or False for whether or not there are solutions.
   */
   public boolean hasSolutions()
   {
      theDisc = Math.pow(b,2) - (4 * a * c);
      boolean hasSolutions;
      if (theDisc >= 0)
      {
         hasSolutions = true;
      }
      else
      {
         hasSolutions = false;
      }
      return hasSolutions;
   }
   
   /**
   Gets the first solution if possible.
   @return The first solution.
   */
   public double getSolution1()
   {
      if (hasSolutions() == true)
      {
         double solution1 = 0;
         solution1 = ((0 - b) + Math.sqrt(theDisc));
         solution1 = solution1 / (2 * a);
         return solution1;
      }
      else
      {
         return 0;
      }
   } 
   
   /**
   Gets the second solution if possible.
   @return The second solution.
   */
   public double getSolution2()
   {
      if (hasSolutions() == true)
      {
         double solution2 = 0;
         solution2 = ((0 - b) - Math.sqrt(theDisc));
         solution2 = solution2 / (2 * a);
         return solution2;
      }
      else
      {
         return 0;
      }
   
   }     
	  	
	/**
   Returns the values of the a, b, and c variables.
   @return a string showing what was plugged in.
   */
   public String toString()
   {
      return "QuadFormula(" + a + "," + b + "," + c + ")";
   }
	
   public static void main(String[] args)
   {
      Scanner reader = new Scanner(System.in);
   	
      System.out.print("Enter a: ");
      double a = reader.nextDouble();
      System.out.print("Enter b: ");
      double b = reader.nextDouble();
      System.out.print("Enter c: ");
      double c = reader.nextDouble();
   	
      QuadFormula test = new QuadFormula(a, b, c);
   	
      if(test.hasSolutions() == false)
      {
         System.out.println("No real solutions!");
      }
      else
      {
         System.out.println("Solution 1 = " + test.getSolution1());
         System.out.println("Solution 2 = " + test.getSolution2());
      }
      
      
   }
}