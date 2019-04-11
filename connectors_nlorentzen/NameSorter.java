import java.util.Scanner;

/**
Sorts Names in Alphabetical order
@author Nicholas Lorentzen and Denzel Bullen
@version 10/30/2018
*/
public class NameSorter
{
   /**
   Sorts Names in Alphabetical order
   @param nameA First word to sort
   @param nameB Second word to sort
   @param nameC Third word to sort
   @return The inputs listed in alphabetical order.
   */
   public String getSortedNames(String nameA, String nameB, String nameC)
   {
      String returnStatement = "Error";
      nameA = nameA + " ";
      nameB = nameB + " ";
      nameC = nameC + " ";
      if ((nameA.compareTo(nameB) <= 0) && (nameA.compareTo(nameC) <= 0))
      {
         if (nameB.compareTo(nameC) <= 0)
         {
            returnStatement = nameA + nameB + nameC;
         }
         else
         {
            returnStatement = nameA + nameC + nameB;
         }
      }
      {
         if ((nameB.compareTo(nameC) <= 0) && (nameB.compareTo(nameA) <= 0))
         {
            if (nameA.compareTo(nameC) <= 0)
            {
               returnStatement = nameB + nameA + nameC;
            }
            else
            {
               returnStatement = nameB + nameC + nameA;
            }
         }
         
         if (returnStatement == "Error")
         {
            if (nameA.compareTo(nameB) <= 0)
            {
               returnStatement = nameC + nameA + nameB;
            }
            else
            {
               returnStatement = nameC + nameB + nameA;
            }
         }
         return returnStatement;
      }
   }


   public static void main(String[] args)
   {
      Scanner reader = new Scanner(System.in);
   	
      System.out.print("Enter first name: ");
      String nameA = reader.nextLine();
      System.out.print("Enter second name: ");
      String nameB = reader.nextLine();
      System.out.print("Enter third name: ");
      String nameC = reader.nextLine();
      System.out.println();
   
      NameSorter test = new NameSorter();
      System.out.println("The outputs in sorted order are:");
      System.out.println(test.getSortedNames(nameA, nameB, nameC));
   }
}