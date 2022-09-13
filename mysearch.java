import java.util.*;

public class mysearch {//sorts a list and finds the index of a certain element in the list

  public static void main (String [] a) {//calls to the sort method
    String[] list= new String[0];
    list= getL();//sets array list to array from method getL
    inssort(list); //calls sort method
    int index = binsearch(list, a[0]);//calls binsearch method
    if(index>=0){
      System.out.println(a[0] + " found at location " + index);
      //if index is 0 or greater, the index of the list is printed
    }
    else{
      System.out.println(a[0] + " not found");
      //if index isn't 0 or greater, the key doesn't exist in the array
    }
  }

  public static String [] getL() {//using input, creates list
    int index = 0; //index to help copy input into a list
    final int max = 1000; //maximum size of list
    try (Scanner a = new Scanner (System.in)) {
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
  }
  public static void inssort(String[] a) {
    int c = 0;//index for sorted elements
    int b = 1;//first unsorted element
    while (b < a.length) {//compares each element of unsorted list to each element in sorted list
      c = b - 1;
      String cp = a[b]; //copies a[b] for when a[b] changes
      while (c >= 0 && a[c].compareTo(cp) > 0) {//inserts a[b] into sorted list
        a[c + 1] = a[c];
        c=c-1;

        }
      if(c>=0){

      }
      b=b+1;//increases b to compare next unsorted element
      a[c + 1] = cp;

    }

  }
  //precondition: array is sorted and increasing
  //parameters: array, target key
  public static int binsearch (String [] a, String key){
    int l = 0;//left index
    int r = a.length - 1; //right index
    int middle; //average of left and right index
    while (l<=r){
      middle = (l + r)/2;
      if(a[middle].compareTo(key)<0){
        l = middle +1;
        //if middle value less than the key, left index is placed after middle value
      }
      else if(a[middle].compareTo(key)==0){
        return middle;
        //if middle value less than key, index of middle value returned
      }

      else {
        r = middle - 1;
        //else, middle value greater than key, index of right value placed before middle value
      }

    }
    return(-1);
    //returns -1 index if the index of middle is never returned in while loop
  }

}
