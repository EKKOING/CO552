import java.util.Scanner;
/**
Comparison Objects Lab Test Code
@author Nicholas Lorentzen
@version 2018/10/29
*/
public class GradeTest
{
   public static void main(String[] args)
   {
      Scanner reader = new Scanner(System.in);
      
      Grade test = new Grade("A+");
      System.out.println("Example: An entered value of \"A+\" will yield:");
      System.out.println("Numeric Value: " + test.getNumericGrade());
      
      test.setGrade("C-");
      System.out.println("Example 2: An entered value of \"C-\" will yield:");
      System.out.println("Numeric Value: " + test.getNumericGrade());
      
      System.out.println("Enter a letter grade: ");
      String letterGrade;
      letterGrade = reader.nextLine();
      test.setGrade(letterGrade);
      System.out.println("Numeric Value: " + test.getNumericGrade()); 
      
   }
}