import java.util.ArrayList;
import java.util.Scanner;

/**
app to run the Wild Kingdom! program
@author Manuel and Nick
@version 2/5/19
*/
public class WildApp
{
   /** number of actors */
   public static final int NUM_ACTORS = 5;
   
   /** number of steps */
   public static final int NUM_STEPS = 5;   

   /** the board for the app */
   private static WildBoard myBoard;
   
   /** the list of actors */
   private ArrayList<Actor> myBugs;
   
   /**
   default constructor
   */
   public WildApp()
   {
      System.out.println("*** WildApp() called");
   
      myBoard = new WildBoard();
      myBugs = new ArrayList<Actor>();
   }
   
   
   /**
   method to get the board
   @return myBoard 
   */
   public static WildBoard getBoard()
   {
      System.out.println("*** WildApp.getBoard() called");
   
      return myBoard;
   }
   
   /**
   runs the simulation
   */
   public void run()
   {
      System.out.println("*** WildApp.run() called");
   
      Scanner reader = new Scanner(System.in);
   
      Bug b = new Bug(3, 6);
      myBugs.add(b);
      myBoard.add(b);
      
      Bug c = new Bug(4, 6);
      myBugs.add(c);
      myBoard.add(c);
      
      Bug d = new Bug(5, 6);
      myBugs.add(d);
      myBoard.add(d);
      
      Bug e = new Bug(5, 3);
      myBugs.add(e);
      myBoard.add(e);
   
      QuickBug q = new QuickBug(6, 6);
      myBugs.add(q);
      myBoard.add(q);
     
      Rock r = new Rock(3, 7);
      myBugs.add(r);
      myBoard.add(r);
      
      TiredBug t = new TiredBug(2, 2);
      myBugs.add(t);
      myBoard.add(t);
      
      myBoard.printBoard();
      
      for(int count = 1; count <= NUM_STEPS; count++)
      {
         System.out.println();
         System.out.println("***** STEP #" + count + " *****");
         
         for(Actor act: myBugs)
         {
            act.move();
         }
      
         myBoard.printBoard();
      
         System.out.println();
         System.out.println("Type 'n' to continue");
         String input = reader.nextLine();
      }
  
   }
   
   public static void main(String[] args)
   {
      WildApp testApp = new WildApp();
      
      testApp.run();
   }

}