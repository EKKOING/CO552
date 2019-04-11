import java.util.Random;
import java.util.Scanner;
import java.util.Calendar;

/**
Base program for Design Challenge 1
@author Nicholas Lorentzen, Dajung Lim, Jed Thomas, Denzel Bullen 
@version 2018/09/21
*/
public class AgeInSeconds
{
   //Conversion Constants
   public static final double DAYS_YEAR = 365;
   public static final double HOURS_DAY = 24;
   public static final double MINUTES_HOUR = 60;
   public static final double SECONDS_MINUTE = 60;
   
   public static final double BLINKS_MINUTE = 20;

   public static void main(String[] args)
   {
    Scanner reader = new Scanner(System.in);
   Calendar cal = Calendar.getInstance();
   int doy = cal.get(Calendar.DAY_OF_YEAR);
   int year = cal.get(Calendar.YEAR);
   System.out.print("Enter your birth year: ");
   
   //Input Variables
   double ageYear;
   ageYear = new Integer(reader.nextLine());
   
   //Output Variables
   double years = 0;
   double days = 0;
   double hours = 0;
   double minutes = 0;
   double seconds = 0;
   
   //Converting to Output Forms
   years = year - ageYear;
   days = (years * DAYS_YEAR) + doy;
   hours = (days * HOURS_DAY);
   minutes = (hours * MINUTES_HOUR);
   seconds = (minutes * SECONDS_MINUTE);
   
   System.out.println("You are " + years + " years, " + days + " days, " 
      + hours + " hours, " + minutes + " minutes, \n or " + seconds 
      + " seconds old.");
   
   
   

   
   }
}