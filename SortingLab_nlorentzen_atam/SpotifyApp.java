import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

/**
A crude representation of the Spotify App
@author Nicholas Lorentzen and Alex Tam
@version 20190307
*/
public class SpotifyApp
{
   /** name of file to store tracks */
   public static final String TRACK_FILE = "tracks.txt";
   
   /** option to add a new track */
   public static final int ADD = 1;
   
   /** option to print the list */
   public static final int PRINT = 2;
   
   /** option to sort the list */
   public static final int SORT = 3;
   
   /** option to search the list */
   public static final int SEARCH = 4;

   /** option to quit the program */
   public static final int QUIT = 5;   
   
   /** option to use Selection Sort */
   public static final int SELECTION = 1;
   
   /** option to use Insertion Sort */
   public static final int INSERTION = 2;
   
   /** option to use Merge Sort */
   public static final int MERGE = 3;

   // ADD CONSTANTS HERE FOR BUBBLE/QUICK SORT
   
   /** option to use Linear Search */
   public static final int LINEAR = 1;
   
   /** option to use Binary Search */
   public static final int BINARY = 2;

   /** list of all the tracks */
   private ArrayList<Track> myTracks;
   
   /** a Scanner object for convenience */
   public Scanner myReader;
   
   public SpotifyApp()
   {
      myTracks = new ArrayList<Track>();
      myReader = new Scanner(System.in);
   }
   
   /**
   prints the track list
   */
   public void printList()
   {
      System.out.println("TRACK LIST");
      for(Track t : myTracks)
      {
         System.out.println(t);
      }
   }
   
   public void run()
   {
      loadFile(TRACK_FILE);
      
      int choice = -1;
      while(choice != QUIT)
      {
         choice = getChoice();
         
         if(choice == ADD)
         {
            System.out.println();
            addTrack();
            System.out.println();
         }
         else if(choice == PRINT)
         {
            System.out.println();
            printList();
            System.out.println();
         }
         else if(choice == SORT)
         {
            System.out.println();
            sortList();
            System.out.println();
         }
         else if(choice == SEARCH)
         {
            System.out.println();
            searchList();
            System.out.println();
         }
      }
      
      saveFile(TRACK_FILE);
   }
   
   /**
   gets a new menu choice
   @return the user's choice
   */
   public int getChoice()
   {
      System.out.println("MAIN MENU");
      System.out.println("1. Add a new track");
      System.out.println("2. Print the track list");
      System.out.println("3. Sort the track list");
      System.out.println("4. Search the track list");
      System.out.println("5. Quit the program");
      System.out.print("Enter choice: ");
      int choice = new Integer(myReader.nextLine());
      return choice;
   }
   
   /**
   adds a new track to the list
   */
   public void addTrack()
   {
      System.out.print("Enter track title: ");
      String title = myReader.nextLine();
      System.out.print("Enter track artist: ");
      String artist = myReader.nextLine();
      System.out.print("Enter track length: ");
      int length = new Integer(myReader.nextLine());
      
      Track tmp = new Track(title, artist, length);
      myTracks.add(tmp);
   }
   
   /**
   sorts the list according to the user's preferences
   */
   public void sortList()
   {
      System.out.println("Sorting algorithms available:");
      System.out.println("1. Selection Sort");
      System.out.println("2. Insertion Sort");
      System.out.println("3. Merge Sort");
   
         // ADD MENU OPTIONS HERE FOR BUBBLE/QUICK SORT
   
      System.out.print("Enter your choice: ");
      int choice = new Integer(myReader.nextLine());
      
      if(choice == SELECTION)
      {
         SortSearch.selectionSort(myTracks);
      }
      else if(choice == INSERTION)
      {
         SortSearch.insertionSort(myTracks);
      }
      else if(choice == MERGE)
      {
         SortSearch.mergeSort(myTracks);
      }
         // ADD BLOCKS HERE FOR BUBBLE/QUICK SORT
         
   }
   
   /**
   searches for a specific track
   */
   public void searchList()
   {
      System.out.println("Searching algorithms available:");
      System.out.println("1. Linear Search");
      System.out.println("2. Binary Search");
      System.out.print("Enter your choice: ");
      int choice = new Integer(myReader.nextLine());   
      
      if(choice == LINEAR)
      {
         doSearch(LINEAR);   
      }
      else if(choice == BINARY)
      {
         doSearch(BINARY);
      }
              
   }

      /**
      helper method for searching
      @param type search type (LINEAR/BINARY)
      */
   public void doSearch(int type)
   {
      System.out.print("Enter title to find: ");
      String title = myReader.nextLine();
         
      Track result = null;
      if(type == LINEAR)
      {
         result = SortSearch.linearSearch(myTracks, title);
      }
      else if(type == BINARY)
      {
         result = SortSearch.binarySearch(myTracks, title);
      }
         
      if(result != null)
      {
         System.out.println("Found " + result);
      }
      else
      {
         System.out.println("No match!");
      }       
   }

   
   /**
   loads the database from a text file
   @param fname the file name
   */
   public void loadFile(String fname)
   {
      try
      {
         BufferedReader br = new BufferedReader(new FileReader(fname));
         
         int numTracks = new Integer(br.readLine());
         for(int idx = 0; idx < numTracks; idx++)
         {
            String title = br.readLine();
            String artist = br.readLine();
            int length = new Integer(br.readLine());
            
            Track temp = new Track(title, artist, length);
            myTracks.add(temp);
         }
         
         br.close();
      }
      catch(IOException ioe)
      {
         System.out.println("Error opening track file!");
         System.exit(1);
      }
   }

   /**
   saves the database to a text file
   @param fname the file name
   */
   public void saveFile(String fname)
   {
      try
      {
         PrintWriter pr = new PrintWriter(fname);
         
         int numTracks = myTracks.size();
         pr.println(numTracks);
         
         for(int idx = 0; idx < numTracks; idx++)
         {
            Track tmp = myTracks.get(idx);
            pr.println(tmp.myTitle);
            pr.println(tmp.myArtist);
            pr.println(tmp.myLength);
         }
         
         pr.close();
      }
      catch(IOException ioe)
      {
         System.out.println("Error opening track file!");
         System.exit(1);
      }
   }            
   
   public static void main(String[] args)
   {
      SpotifyApp test = new SpotifyApp();
      test.run();
   }
}