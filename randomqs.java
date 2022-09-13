import java.io.*;
import java.util.*;
import java.lang.*;

public class randomqs{

  public static void main(String [] a){//calls input array, quicksort method, prints list
    a = getL();
    qs(a, 0, a.length-1);
    printlist(a);
  }


  public static String [] getL() {//using input, creates list
    int index = 0; //index to help copy input into a list
    final int max = 1000; //maximum size of list
    Scanner a = new Scanner (System.in);
    String [] list = new String [max]; //array which will take input, size 1000
    while (a.hasNextLine() && index<list.length){//copies input into array
      list[index]=a.nextLine();
      index++;
    }
    int size = index;//when a.hasNextLine() returns false,
                     //the size of index is the size of the final array
    index=0; //resets index for further loop
    String [] finalList= new String [size];
    while(index<size) {//copies elements from first array to final array
      finalList[index] = list[index];
      index++;
    }
    return finalList;
  }

  public static void qs(String[] s, int low, int high){
    if (low<high){//if the subarray has greater than k elements, quicksort runs
      int rd =low + (int) (Math.random() * (high - low + 1)) ;
      //rd is a random index of the array
      String swap;//used to exchange elements
      swap = s[low];
      s[low]=s[rd];
      s[rd]=swap;//switch the random element with the first element of array
      String piv = s[low]; //set pivot to first element of array
      int index = low;//low - 1 is the index for the smaller element
      int c = low+1;
      while(c<=high){ //while loop places all elements smaller than index in the array below index
        if(s[c].compareTo(piv)<0) {
          index=index+1;
          swap = s[index]; //swaps current element with index
          s[index]=s[c];
          s[c]=swap; //increment index whenever an element is lower than the pivot
        }
        c=c+1;
      }
      //s[index] and pivot swapped; all elements below the pivot are lower than pivot
      swap = s[index];
      s[index]= s[low];
      s[low] = swap;

      int rand = index;
      qs(s, low, rand - 1);//sort left subarray
      qs(s, rand + 1, high);//sort right subar`ray
    }
  }


  public static void printlist (String [] a) {//this prints a given array
    int print = 0;
    while(print<a.length){
      System.out.println(a[print]);
      print=print+1;
    }
}

}
