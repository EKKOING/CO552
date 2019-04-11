/**
Adding Parameters Lab 
@version 10/17/18
@author Liz Williams and Nicholas Lorentzon 
*/

public class InterestCalculator
{
   /**
   Takes the 4 parameters for a compound interest account and calculates and 
   then prints the future value of the account for the given time period.
   @param monthlyDeposit Amount deposited each month
   @param interestRate Interest rate for the account
   @param numCompounds Number of compounds a year
   @param timeYears Amount of time from account creation in years
   */
   public void printTotalAmount(int monthlyDeposit, double interestRate, 
      int numCompounds, int timeYears)
   {
      double mainCalc = 1 + interestRate / numCompounds;
      mainCalc = Math.pow(mainCalc, numCompounds * timeYears) - 1;
      mainCalc = monthlyDeposit * (mainCalc / (interestRate / numCompounds));
      System.out.println("Total Amount: $" + mainCalc);
   }

   public static void main(String[] args)
   {
      InterestCalculator test = new InterestCalculator();
      test.printTotalAmount(100, 0.03, 12, 5);
   }	
}