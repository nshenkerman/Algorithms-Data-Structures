import java.io.*;
import java.util.*;
import java.lang.*;
import java.util.Scanner.*;
public class QSstack{
  public static String [] getL() {//using input, creates list
    int index = 0; //index to help copy input into a list
    final int max = 1000; //maximum size of list
    Scanner a = new Scanner(System.in);
    String [] list = new String [max]; //array which will take input, size 1000

    while (a.hasNextLine() && index<list.length){//copies input into array
      list[index]=a.nextLine();
      index=index+1;
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
  public static void swap(String[] s, int i, int j){
    String swap = s[i];
    s[i]=s[j];
    s[j]=swap;

  }
  public static void qsStack(String[] s){
    Mystack stack = new Mystack(s.length+1); //creates stack
    int i=0;//index of smaller element
    int j=0;//loop variable
    int high=s.length-1;
    int low=0;
    stack.push(low); //pushes low
    stack.push(high); //pushes high
    while(!(stack.isEmpty())){

      if(low != i+1){//only begin sorting left partition when right has been sorted
        high = stack.pop(); //pops high from stack
        low=stack.pop();//pops low from stack
      }
      i=low;
      j=low+1;
      if(low<high){

        while(j<=high){//sorting algorithm
          if(s[j].compareTo(s[low])<0){
            i=i+1;
            swap(s, i, j);
          }
          j=j+1;
        }
        swap(s, low, i); //puts pivot into place

        stack.push(low);//sorts list above pivot
        stack.push(i-1);

        low=i+1; //sorts list above pivot

      }
    }
  }



  public static void printlist (String [] a) {//this prints a given array
    int print = 0;
    while(print<a.length){
      System.out.println(a[print]);
      print=print+1;
    }
  }
  public static void main(String [] arg){//calls input array, quicksort method, prints list
    String[] a = getL();
    qsStack(a);
    printlist(a);
  }
}
