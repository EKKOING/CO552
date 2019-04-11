/**
Tired Bug Class in Wild Kingdom!
@author Manuel and Nick
@version 2/5/19
*/

public class TiredBug extends Bug
{
   /** stores whether or not the bug will move next turn*/
   private boolean moveCondition = true;  
   /** default constructor for Tired Bug class  */
   public TiredBug()
   {
      this(-1, -1);
      
      System.out.println("*** TiredBug() called");
   }
   
   /** 
   instructor that sets location
   @param row row of bug
   @param col col of bug
   */
   public TiredBug(int row, int col)
   {
      super(row, col); 
      System.out.println("*** TiredBug(row, col) called");      
   }
   
   /**
   moves location
   @return boolean true if succesful
   */
   public boolean move()
   {
      System.out.println("*** TiredBug.move() called");
      
      int rowChg = ((int)(Math.random() * 3) - 1) * 2;
      int colChg = ((int)(Math.random() * 3) - 1) * 2;
      int newCol;
      int newRow;
      
      Coord newLoc = new Coord();
      
      if (moveCondition)
      {
         boolean temp = super.move();
         moveCondition = false;
         return temp;
      }
      else
      {
         System.out.println("Nah too tired m8");
         moveCondition = true;
         return true;
      }   
   }
   
  /**
  Gets symbol
  @return string of symbol
  */
   public String getSymbol()
   {
      // System.out.println("*** Bug.getSymbol() called");
   
      return "t";
   }
   


   public static void main(String[] args)
   {
      WildApp app = new WildApp();
   
      // UNCOMMENT CODE BELOW FOR TESTING!
   
      TiredBug test = new TiredBug();
      System.out.println(test);
          
      TiredBug test2 = new TiredBug(3, 4);
      System.out.println(test2);   
       
      test.setLocation(4, 6);      
      System.out.println(test);
      System.out.println(test.getLocation());
   //       
      System.out.println(test.getSymbol());
      
      WildBoard board = WildApp.getBoard();
      board.add(test);
      test.move();
      System.out.println(test);
      test.move();
      System.out.println(test);
      test.move();
      System.out.println(test);
      test.move();
      System.out.println(test);
      test.move();
      System.out.println(test);
   }
}