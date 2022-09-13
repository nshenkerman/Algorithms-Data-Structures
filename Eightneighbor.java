import java.io.*;
import java.util.*;

public class Eightneighbor{
	public static void main(String [] a){
		boolean[][] array = {{true,true,false,false},
										 		 {false,false,true,true},
										 	   {true,true,false,false},
												 {true,false,false,true}
		};

		Location loc = new Location(0,3);
		System.out.println("Element: " + "[" + loc.getRow() + "]" + "[" + loc.getCol() + "]");
		int i = 0;
		int j=0;
		while(i<array.length){//prints initial boolean array
			j=0;
			while(j<array[0].length){
				if(array[i][j]==true){
					System.out.print("t ");
				}
				else{
					System.out.print("f ");
				}
				j++;
			}
			System.out.println();
			i++;
		}
		ArrayList<Location> list = trueNeighbors(array, loc);

		for(Location l : list){
			System.out.println("["+l.getRow()+", " + l.getCol()+"]");//prints locations
		}
	}
	public static ArrayList<Location> trueNeighbors(boolean[][] array, Location loc){
		//parameters: boolean[][] array, specified location
		//purpose: returns ArrayList with locations of true values in the inputted boolean[][]

		ArrayList <Location> list = new ArrayList<Location>();
		if(loc.getRow()>0){
			if(loc.getCol()>0 && array[loc.getRow()-1][loc.getCol()-1]==true){
				list.add(new Location(loc.getRow()-1,loc.getCol()-1));
				//northwest case
			}
			if(array[loc.getRow()-1][loc.getCol()] == true){
				list.add(new Location(loc.getRow() - 1, loc.getCol()));
				//north case
			}
			if(loc.getCol()<array[loc.getRow()].length-1 && array[loc.getRow()-1][loc.getCol()+1]){
				list.add(new Location(loc.getRow()-1, loc.getCol()+1));
				//northeast case
			}
		}

		if(loc.getCol()>0){
			if(array[loc.getRow()][loc.getCol()-1] == true){
				list.add(new Location(loc.getRow(), loc.getCol()-1));
				//west case
			}
		}
		if(loc.getCol()<array.length-1){
			if(array[loc.getRow()][loc.getCol()+1] == true){
				list.add(new Location(loc.getRow(), loc.getCol()+1));
				//east case
			}
		}


		if(loc.getRow()<array.length-1){
			if(loc.getCol()>0 && array[loc.getRow()+1][loc.getCol()-1]){
				list.add(new Location(loc.getRow()+1, loc.getCol()-1));
				//southwest case
			}

			if(array[loc.getRow()+1][loc.getCol()] == true){
				list.add(new Location(loc.getRow()+1, loc.getCol()));
				//south case
			}

			if(loc.getCol()<array[loc.getRow()].length-1 && array[loc.getRow()+1][loc.getCol()+1]==true){
				list.add(new Location(loc.getRow()+1,loc.getCol()+1));
				//southeast case
			}
		}


		return list;
	}
}
