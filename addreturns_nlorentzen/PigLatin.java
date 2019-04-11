import java.util.Scanner;

/**
Translates from English -> Pig Latin
@author Nicholas Lorentzen and CiCi Bu
@version 10/15/2018
*/

public class PigLatin
{

	/**
	converts the corresponding word to Pig Latin
	@param word the word in English
	@return the word in Pig Latin
	*/
   public String translate(String word)
   {
      word = word.toLowerCase();
      	
      char firstLetter;
      firstLetter = word.charAt(0);
      	
      if(firstLetter == 'a'
      	|| firstLetter == 'e'
      	|| firstLetter == 'i'
      	|| firstLetter == 'o'
      	|| firstLetter == 'u')
      {
         
         word = vowelTranslate(word);
      }
      else
      {
         word = consTranslate(word);
      }
      	
      return word;
   }
   /**
	Translates a word starting with a vowel
	@param word the word in English
	@return the word in Pig Latin
	*/
   public String vowelTranslate(String word)
   {
      return word + "way";
   }
   /**
	Translates a word starting with a consonant
	@param word the word in English
	@return the word in Pig Latin
	*/
   public String consTranslate(String word)
   {
      return word.substring(1) + word.substring(0,1) + "way";
   
   }

   public static void main(String[] args)
   {
      Scanner reader = new Scanner(System.in);
   		
      System.out.print("Enter word to translate: ");
      String input;
      input = reader.nextLine();
   		
      PigLatin converter;
      converter = new PigLatin();
      String translated;
      translated = converter.translate(input);
   		
      System.out.println(input + " -> " + translated);
   }
}