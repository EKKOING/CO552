import java.util.ArrayList;

/**
min-sorts ArrayList<Track> collections
@author Alex Tam and Nicholas Lorentzen
@version 20190307
*/
public class SortSearch
{
   /**
   swaps two list elements
   @param list the list to mutate
   @param idx1 the first index
   @param idx2 the second index
   */
   public static void swap(ArrayList<Track> list, int idx1, int idx2)
   {
      Track temp = list.get(idx1);
      list.set(idx1, list.get(idx2));
      list.set(idx2, temp);
   }
   
   /**
   sorts an arraylist using Selection Sort
   @param list the arraylist to sort
   */
   public static void selectionSort(ArrayList<Track> list)
   {
      for(int swapIdx = 0; swapIdx < list.size(); swapIdx++)
      {
         int lowIdx = swapIdx;
         for(int tmpIdx = swapIdx; tmpIdx < list.size(); tmpIdx++)
         {
            if((list.get(tmpIdx).myTitle).compareTo(list.get(lowIdx).myTitle) < 0)
            {
               lowIdx = tmpIdx;
            }
         }
         swap(list, swapIdx, lowIdx);
      }
   }
   
   /**
   sorts an ArrayList using Insertion Sort
   @param list the arraylist to sort
   */
   public static void insertionSort(ArrayList<Track> list)
   {
      for (int swapIdx = 1;swapIdx < list.size(); swapIdx++)
      {
		   int idx = swapIdx;
         Track temp = list.get(swapIdx);
		   String idxVal = list.get(swapIdx).myTitle;
		   while (idx > 0 && list.get(idx-1).myTitle.compareTo(idxVal) > 0)
         {
            list.set(idx, list.get(idx-1));
			   idx = idx - 1;
		   }
         list.set(idx, temp);
	   }
   }
   
   /**
   sorts an ArrayList using Merge Sort
   @param list the list to sort
   */
   public static void mergeSort(ArrayList<Track> list)
   {
      int beg = 0;
      int end = list.size() - 1;
      mSort(list, beg, end);
   }
   
   /**
   recursive helper method for Merge Sort
   @param list the arraylist to sort
   @param beg the beginning of this subsection
   @param end the end of this subsection
   */
   private static void mSort(ArrayList<Track> list, int beg, int end)
   {
      if(beg >= end)
      {
      // nothing to do
      }
      else
      {
         int mid = (beg + end) / 2;
         mSort(list, beg, mid);
         mSort(list, mid + 1, end);
         merge(list, beg, mid, end);
      }
   }
   
   /**
   merges two sorted subsections for Merge Sort 
   @param list the arraylist to sort
   @param beg the beginning of this subsection
   @param mid the middle of this subsection (end of left half)
   @param end the end of this subsection (end of right half)
   */
   public static void merge(ArrayList<Track> list, int beg, int mid, int end)
   {
      ArrayList<Track> temp = new ArrayList<Track>();

      int idx1 = beg;
      int idx2 = mid + 1;
      int tempIdx = beg;
      
      while (idx1  <= mid && idx2 <= end)
      {
         if (list.get(idx1).myTitle.compareTo(list.get(idx2).myTitle) < 0)
         {
            temp.add(list.get(idx1));
            idx1++;
            tempIdx++;
         }
         else
         {
            temp.add(list.get(idx2));
            idx2++;
            tempIdx++;
         }
      }
      while (idx1 <= mid)
      {
         temp.add(list.get(idx1));
         idx1++;
         tempIdx++;
      }
      while (idx2 <= end)
      {
         temp.add(list.get(idx2));
         idx2++;
         tempIdx++;
      }
      tempIdx = 0;
      for (int idx = beg; idx <= end; idx++)
      {
         list.set(idx, temp.get(tempIdx));
         tempIdx++;
      }
   }
   
   /**
   searches using Linear Search
   @param list the list to search
   @param target the title to find
   @return matching Track, or null if no match
   */
   public static Track linearSearch(ArrayList<Track> list, String target)
   {
      for(int idx = 0; idx < list.size(); idx++)
      {
         if((list.get(idx)).myTitle.equals(target))
         {
            return list.get(idx);
         }
      }
      return null;
   }
   
   /**
   searches using Binary Search
   @param list the list to search
   @param target the title to find
   @return matching Track, or null if no match
   */
   public static Track binarySearch(ArrayList<Track> list, String target)
   {
      int low = 0;
      int hi = list.size() - 1;
      while(low <= hi)
      {
         int mid = (low + hi) / 2;
         if(target.equals(list.get(mid).myTitle))
         {
            return list.get(mid);
         }
         else if(target.compareTo(list.get(mid).myTitle) < 0)
         {
            hi = mid - 1;
         }
         else
         {
            low = mid + 1;
         }
      }
		return null;
   }
}