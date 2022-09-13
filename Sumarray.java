import java.io.*;
import java.util.*;

public class Sumarray{
	public static void main(String [] a){
		int[][] array = {{1,2,3},//2D array
										 {1,2,3},
										 {1,2,3},
										 {1,2,3}
		};
		int tot = sum(array); //tot= sum of array
		printArray(array);
		System.out.println("The sum of the elements of the array is: " + tot);//print sum
	}

	public static int sum(int[][] array){//returns sum of array
		//parameter: int[][] array
		int tot=0;//sum
		int ind=0;//goes down array
		int ind2 = 0;//goes across array
		while(ind<array.length){
			ind2 = 0;//reset ind2 to 0 for each new line
			while(ind2<(array[ind].length)){
				tot = tot + array[ind][ind2];
				ind2++;
			}
			ind++;
		}
		return tot;
	}

	public static void printArray(int [][] array){//prints array
		//parameter: int[][] array
		int ind = 0;
		int ind2 = 0;
		while(ind<array.length){
			ind2 = 0;
			while(ind2<array[ind].length){
				System.out.print(array[ind][ind2] + " ");
				ind2++;
			}
			System.out.println("");
			ind++;
		}
	}
}
