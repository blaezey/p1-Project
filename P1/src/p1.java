import java.io.File;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class p1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner;
		File f = new File("map1.txt");
		
		try {
			//code that might throw a special error
			scanner = new Scanner(f); 
			
			//use the next three methods to grab the first
			//three numbers from the map file
			int rows = scanner.nextInt();
			int cols = scanner.nextInt();
			int rooms = scanner.nextInt();
			
			coordinate[][] grid = new coordinate[rows][cols];
			
			int row = 0;
			
			System.out.println("Rows: "+rows);
			System.out.println("Columns: "+cols);
			System.out.println("Rooms: "+rooms);
			
			//take in the cols and # of rooms
			while(scanner.hasNextLine()) {
				String line = scanner.nextLine();
				
				//use charAt to grab the elements of the map for a given row
				for(int i = 0; i < line.length(); i++) {
					System.out.print(line.charAt(i) + " "+i+ " "+ (row-1));
					System.out.println();
				}
				row++;
				 
			}
			
			
		}catch(Exception e){
			System.out.println(e);
			
		}
		
		
	}

	public void coordinateBase(Scanner scan) {
		
		try {
			int rows = scan.nextInt();
			int cols = scan.nextInt();
			int rooms = scan.nextInt();
			
			coordinate[][] grid = new coordinate[rows][cols];
			
			int row = 0;
			
			while(scan.hasNextLine()) {
				String line = scan.nextLine();
				
				for(int i = 0; i < line.length(); i++) {
					grid[row][i] = new coordinate(line.charAt(i), i, row-1);
				}
			}
			
			
			
		}catch(Exception e){
			System.out.println(e);
		}
		
		
	}
	
	public Queue<coordinate> queueBased(coordinate[][] grid) {
		
		Queue<coordinate> q1 = (Queue<coordinate>) new ArrayList<coordinate>();
		Queue<coordinate> q2;
		
		coordinate start = null;
		coordinate curr = start;
		
		for(int row = 0; row< grid.length; row++) {
			for(int col = 0; col < grid[0].length; col++) {
				if(grid[row][col].getRoom() == 'K') {
					curr = grid[row][col];
				}
			}
		}
		q1.add(curr);
		
		for(int row = 0; row < grid.length; row++) {
			for(int col = 0; col < grid[0].length; col++) {
				if(curr.getRow()!=0) {
					q1.add(new coordinate(grid[row-1][col].getRoom(), grid[row-1][col].getRow(), grid[row-1][col].getCol()));
				}
				if(curr.getRow()!=grid[0].length-1) {
					q1.add(new coordinate(grid[row+1][col].getRoom(), grid[row+1][col].getRow(), grid[row+1][col].getCol()));
				}
				if(curr.getCol()!=grid.length) {
					q1.add(new coordinate(grid[row][col+1].getRoom(), grid[row][col+1].getRow(), grid[row][col+1].getCol()));
				}
				if(curr.getCol()!=0) {
					q1.add(new coordinate(grid[row][col-1].getRoom(), grid[row][col-1].getRow(), grid[row][col-1].getCol()));
				}
				
			}
			
		}
		
		
		
		
		
		return q1;
	}
	
	
	
	
	
	
}
