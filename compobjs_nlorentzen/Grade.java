/**
Comparison Objects Lab
@author Nicholas Lorentzen
@version 2018/10/29
*/
public class Grade
{  
   /** Stores the letter  grade*/
   private String letterGrade;
   /** Stores the letter of the letter grade. Ex. "A+" -> "A"*/
   private String letter;
   /** Stores the amount to modify based on the presence of "+" or "-"*/
   private double gradeModifier;
   /** Stores the numeric grade for output*/
   private double numericGrade;

   /**
   Creates a new letter grade converter.
   @param gradeStr The letter grade for conversion. Can include a "+" or "-".
   */
   public Grade(String gradeStr)
   {
      letterGrade = gradeStr;
   }
   
   /**
   Modifies the current letter grade value held by the program for conversion.
   @param gradeStr The letter grade for conversion. Can include a "+" or "-".
   */
   public void setGrade(String gradeStr)
   {
      letterGrade = gradeStr;
   }
   
   /**
   Converts the letter grade to a numeric grade.
   @return The numeric grade for the given letter grade.
   */
   public double getNumericGrade()
   {
      int inputLength = letterGrade.length();
   
      if (letterGrade.substring(1).equals("+"))
      {
         gradeModifier = 0.3;
      }
      else if (letterGrade.substring(1).equals("-"))
      {
         gradeModifier = -0.3;
      }
   
      if (inputLength == 1)
      {
         letter = letterGrade;
         gradeModifier = 0.0;
      }
      {
         letter = letterGrade.substring(0,1);
      }
      
      if (letter.compareTo("A") == 0)
      {
         numericGrade = 4.0;
         if (gradeModifier != 0.3)
         {
            numericGrade = numericGrade + gradeModifier;
         } 
      }
      else if (letter.compareTo("B") == 0)
      {
         numericGrade = 3.0 + gradeModifier;
      }
      else if (letter.compareTo("C") == 0)
      {
         numericGrade = 2.0 + gradeModifier;
      }
      else if (letter.compareTo("D") == 0)
      {
         numericGrade = 1.0 + gradeModifier;
      }
      else if (letter.compareTo("F") == 0)
      {
         numericGrade = 0.0;
      }
      else
      {
         numericGrade = 99.9;
         System.out.println("Error: Not Accepted Input");
      }
      
      return numericGrade;
   }
}