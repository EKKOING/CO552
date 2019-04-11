/**
Implements a track in Spotify
@author Nicholas Lorentzen and Alex Tam
@version 20190307
*/
public class Track implements Comparable<Track>
{
   /** name of the song */
   public String myTitle;
   
   /** name of the artist */
   public String myArtist;
   
   /** length of the track (seconds) */
   public int myLength;

   public Track()
   {
      myTitle = "";
      myArtist = "";
      myLength = -1;
   }
   
   /**
   @param t the title
   @param a the artist
   @param len the length
   */
   public Track(String t, String a, int len)
   {
      myTitle = t;
      myArtist = a;
      myLength = len;
   }
     
   /**
   compares two Track objects lexicographically by title
   @return this.myTitle compared to other.myTitle
   */
   public int compareTo(Track other)
   {
      return this.myTitle.compareTo(other.myTitle);
   } 
       
   /**
   converts Track object to a String
   @return String representation of Track
   */
   public String toString()
   {
      return "Track[" + myTitle + "," + myArtist + "," + myLength + "]";
   }
   
   public static void main(String[] args)
   {
      Track test = new Track("Let It Go", "Idina Menzel", 253);
      System.out.println(test);
      
      Track test2 = new Track("Ring of Fire", "Johnny Cash", 187);
      System.out.println(test2);
      
      System.out.println("Comp = " + test.compareTo(test2));
      System.out.println("Comp = " + test.compareTo(test));
      System.out.println("Comp = " + test2.compareTo(test));
   }
}