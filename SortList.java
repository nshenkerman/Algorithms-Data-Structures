import java.io.*;

public class SortList {//Sorts a given array through selection sorting

  public static void main (String [] a) {//calls to the sort method
    sort(a); //calls sort method
    printlist(a);//calls printlist method
  }


  public static void sort (String [] a) {
    int b=0;//first unsorted element
    int c=0;//current element being compared to the smallest unsorted array element
    int d=0;//current smallest unsorted array element

    String p = "";//helps switch first unsorted element and final smallest array element
    while (b<a.length){

      d=b;//this makes the smallest unsorted element equal to the first unsorted element
      c=d+1;//the first element being compared to the smallest unsorted elementy is d+1

      while (c<a.length){//if the element being compared is greater (alphabetically)
                         //than the element it's being compared to, d=c
                         
        if (a[d].compareTo(a[c])>0){//finds new smallest element
          d = c;

        }
        c=c+1;
      }
      p = a[b];

      a[b]=a[d];

      a[d]=p;

      //this transtively makes a[d] equal to a[b] and a[b] equal to a[d]

      b=b+1;
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
