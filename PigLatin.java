import java.io.*;
import java.util.*;


public class PigLatin { //Translates string array a from English to Pig Latin
    public static void main (String [] a ) {
        int b = 0;
        while (b<a.length){
          System.out.print(translate(a[b]));
          b++;
        }

    System.out.println(""); //Prints a new line after array A is translated to Pig Latin from English
}

public static String translate(String l){ //translate method takes a given string and translates to Pig Latin
    char [] vowels = {'a' , 'e' , 'i', 'o', 'u'}; // Array of vowels
    int i=0; //Index for vowel array
    int c=0; //Index for consonant rule
    int y=0; //Index for 'y'  
    String op="";
    if(exception(l)==true){//Calls exception method
        op = l + " ";
        return op;
    }
    while(i<vowels.length){ //This while loop checks if the first index of l is a vowel
      if (l.charAt(0)==(vowels[i])){
        op = l + "way ";
        return op;
      }
      i++;
    }
    i = 0;

    while(y<l.length()){ //This while loop makes the code treat y as a consonant when it
                            //begins a word and as a vowel if it is preceded by a consonant
      while(i<vowels.length){
        if(l.charAt(0)=='y'){
          op = l.substring(y+1) + l.charAt(y) + "ay ";
          return op;
        }
        else if(l.charAt(y) == 'y' && (l.charAt(y-1)) != vowels[i]){
          op = l.substring(y)+l.substring(0,y) + "ay ";
          return op;
        }
        i++;
      }
      i=0;
      y++;
    }
    i= 0;
    while(c<l.length()){//This while loop works for the consonant rule in Pig Latin
      while(i<vowels.length){
        if(l.charAt(c)==vowels[i]){
          op = l.substring(c)+l.substring(0,c) + "ay ";
          return op;
        }
        i++;
      }
      i=0;
      c++;
    }
      return op; //Returns op if not already returned
  }
    public static boolean exception (String e) {//exception method takes a given string and checks if the string matches an exception
        String [] dictionary = {"at", "in","on", "a",  "i", "of", "be", "is", "by", "my",
        "it", "the"};
        int i = 0; //Index for exception dictionary array
        while(i<dictionary.length){
          if(e.equals(dictionary[i])){
            return true;
          }

          i++;
        }
        return false;
      }

}
