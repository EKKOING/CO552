/**
QuickBug Class in Wild Kingdom!
@author Manuel & Nick
@version 2/5/19
*/
public class QuickBug extends Bug
{
   /** Default QuickBug constructor */
   public QuickBug()
   {
      this(-1, -1);
      
      System.out.println("*** QuickBug() called");
   }
   
   /** 
   instructor that sets location
   @param int row row of bug
   @param int col col of bug
   */
   public QuickBug(int row, int col)
   {
      super(row, col);
   
      System.out.println("*** QuickBug(row, col) called");        
   }
   
   /**
   moves location
   @return boolean true if succesful
   */
   public boolean move()
   {
      System.out.println("*** QuickBug.move() called");
      
   
      int rowChg = ((int)(Math.random() * 3) - 1) * 2;
      int colChg = ((int)(Math.random() * 3) - 1) * 2;
      int newRow;
      int newCol;
      
      if((int)(Math.random() * 2) == 1)
      {
         newRow = super.getLocation().row + rowChg;
         newCol = super.getLocation().col;
      }
      else
      {
         newCol = super.getLocation().col + colChg;
         newRow = super.getLocation().row;
      }
         
      Coord newLoc = new Coord();
      newLoc.row = newRow;
      newLoc.col = newCol;
      
      return this.updateBoard(newLoc);
   }
   
   /**
   Gets symbol
   @return string of symbol
   */
   public String getSymbol()
   {
      //System.out.println("*** Bug.getSymbol() called");
   
      return "Q";
   }
   

   public static void main(String[] args)
   {
      WildApp app = new WildApp();
   
      // UNCOMMENT CODE BELOW FOR TESTING!
   
      QuickBug test = new QuickBug();
      System.out.println(test);
   
      QuickBug test2 = new QuickBug(3, 4);
      System.out.println(test2);   
   
      test.setLocation(4, 6);      
      System.out.println(test);
      System.out.println(test.getLocation());
     
      System.out.println(test.getSymbol());
   
      WildBoard board = WildApp.getBoard();
      board.add(test);
      test.move();
      System.out.println(test);
      
   }
}