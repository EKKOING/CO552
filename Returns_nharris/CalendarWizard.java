import java.util.GregorianCalendar;
import java.util.Calendar;

/**
Base program for Return Values Lab
@author Nate Harris, Nick Lorentzen
@version 2018/09/27
*/
public class CalendarWizard {

   public static final int BIRTH_YEAR = 2000;
   public static final int BIRTHDAY = 23;
   public static final int TIME_ADDED_CAL = 100;
   public static final int TIME_ADDED_BIRTHDAY = 10000;



   public static void main(String[] args){
   
      GregorianCalendar cal = new GregorianCalendar();
      GregorianCalendar birthday = new GregorianCalendar(
         BIRTH_YEAR, Calendar.JULY, BIRTHDAY);
      
      
      //Code for printing the date 100 days from today.
      cal.add(Calendar.DAY_OF_MONTH, TIME_ADDED_CAL);
      int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
      int month = cal.get(Calendar.MONTH);
      int year = cal.get(Calendar.YEAR);
      int weekday = cal.get(Calendar.DAY_OF_WEEK);
      System.out.println("100 Days from today the date will be: " 
         + month + "/" + dayOfMonth + "/" + year);
      
      
      //Code for printing the weekday of my birthday.
      int birthWeekday = birthday.get(Calendar.DAY_OF_WEEK);
      System.out.println("My birthday was on a " + birthWeekday);
      
     
      //Code for printing the date 10,000 days after my birthday
      birthday.add(Calendar.DAY_OF_MONTH, TIME_ADDED_BIRTHDAY);
      int olderBirthdayOfMonth = birthday.get(Calendar.DAY_OF_MONTH);
      int olderBirthmonth = birthday.get(Calendar.MONTH);
      int olderBirthyear = birthday.get(Calendar.YEAR);
      System.out.println("10,000 Days from July 23, 2000 the date was: " 
         + olderBirthmonth + "/" + olderBirthdayOfMonth + "/" + olderBirthyear);
      
   
   }

}