import java.util.*;
public class Stackqs{

  public static String [] getL() {//using input, creates list
    int index = 0; //index to help copy input into a list
    final int max = 1000; //maximum size of list
    try (Scanner a = new Scanner (System.in)) {
      String [] list = new String [max]; //array which will take input, size 1000
      System.out.println();
      while (a.hasNextLine() && index<list.length){//copies input into array
        list[index]=a.nextLine();
        index++;
      }
      System.out.println();
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
  }
  public static void swap(String[] s, int i, int j){
    String swap = s[i];
    s[i]=s[j];
    s[j]=swap;

  }
  public static void qsStack(String[] s){
    System.out.println();
    Mystack stack = new Mystack(s.length);
    stack.push(0);
    stack.push(s.length-1);
    while(!(stack.isEmpty())){
      int high = stack.pop();
      int low=stack.pop();

      if(high>low){
        String pivot = s[low];
        int i=low-1;
        int j=low;
        while(j<=high){
          if(s[j].compareTo(pivot)<0){
            i++;
            swap(s, i, j);
          }
          j++;
        }
        swap(s, i, low);
        int partition = i;
        stack.push(low);
        stack.push(i);
        stack.push(partition);

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
  public static void main(String [] a){//calls input array, quicksort method, prints list
    System.out.println();
    a = getL();
    qsStack(a);
    printlist(a);
  }
}
