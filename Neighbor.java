import java.io.*;
import java.util.*;

public class Neighbor{
	public static void main(String [] a){
		int[][] array = {{3,3,7},
										 {8,7,6},
										 {1,5,9},
										 {5,3,3}
		};
		printArr(array);
		printBiggest(array);
	}

	public static boolean biggestNeighbor(int[][] array, int i, int j){//finds if given element is biggest in 4 neighborhood
		//parameters: int[][] array, int i, int j
		int v = array[i][j];
		if(i !=(array.length-1) && array[i+1][j]>v){//bottom row case
			return false;
		}
		else if(i != 0 && array[i-1][j]>v){//top row case
			return false;
		}
		else if(j != 0 && array[i][j-1]>v){//left column case
			return false;
		}
		else if(j != array[i].length-1 && array[i][j+1]>v){//right column case
			return false;
		}
		return true; //if none of the four neighbors were bigger, return true
	}

	public static void printBiggest(int array [][]){//prints biggest neighbors
		//parameter: int array [][]
		int ind = 0;
		int ind2 = 0;
		while(ind<array.length){
			ind2 = 0;
			while(ind2<array[0].length){
				if(biggestNeighbor(array, ind, ind2)==true){//if array element is the biggest neighbor
					System.out.println("[" + ind + "]" + "[" + ind2 + "]");//print element
				}
				ind2++;
			}
			ind++;
		}
	}

	public static void printArr(int [][] array){//prints array
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
