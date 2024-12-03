/*
 * Vigneswaran Madappan Chinnasami
 */
import java.util.Random;
import java.util.Scanner;

public class HW04 {
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		char [][] matrix = new char[10][10];
		while (true) {
			for (int i = 0; i < 10; i++)// making grid values 
				for (int j = 0; j < 10; j++)
					matrix [i][j] = '-';
			matrix [9][9] = '^';// home position 
			int [] position = new int [2];                            
	        position [0] = 0; position [1] = 0;
	        matrix [position[0]][position [1]] = 'X';   
	        int potholes = 0;
	        Random r = new Random ();
	        while (potholes < 5) {
	        	int x = r.nextInt (10), y = r.nextInt (10);
	        	if ((x == 0) && (y == 0)) 
	        		continue; // Making sure no pot holes in the start and end position
	        	if ((x == 9) && (y == 9))
	        		continue;                  
	        	if (matrix [x][y] == 'o')
	        	    continue;
	        	matrix [x][y] = 'o';
	        	potholes++;
	        	}
	        System.out.println ("Welcome to Pothole Driving! Get home while avoiding potholes!");
	        while (true) {
	        	for (int i = 0; i < 10; i++) { // Displaying the grid 
	        		for (int j = 0; j < 10; j++) {
	        			char ch = matrix [i][j];
	        			if (matrix [i][j] == 'o')  
	        				ch = '-';
	        			System.out.print (ch);
	                    }
	        		System.out.println ();
	        		}
	        	if ((position [0] == 9) && (position [1] == 9)) {// Once reaching the destination  
	        		System.out.println ("Game over!");
	        		break;
	            	}
	        	int dx = -5, dy = -5;
	        	while ((dx < -1) || (dx > 1)) {
	        		System.out.println ("Enter either a -1, 0, or 1 in the X or 9 to quit");
	        		dx = sc.nextInt ();
	        		if (dx == 9) {
	        			System.out.println ("Goodbye!");
	        			return;
	        			}
	        	    }
	        	if (position [0] + dx < 0 || position [0] + dx > 9) { 
	        		System.out.println ("Invalid location!");
	        		continue;
	        	    } 
	        	while ((dy < -1) || (dy > 1)) {
	        		System.out.println ("Enter either a -1,0, or 1 in the Y");
	        	    dy = sc.nextInt ();
	        	    }
	        	if (position [1] + dy < 0 || position [1] + dy > 9) {                 
	        	    System.out.println ("Invalid location!");
	        	    continue;
	        	    } 
	        	if (matrix [position [0] + dx][position [1] + dy] == 'o') {            
	        	    System.out.println ("OH NO! POTHOLE!");
	        	    break; 
	        	    }
	        	matrix [position [0]][position [1]] = '-';// updating position of user 
	        	position [0] += dx;
	        	position [1] += dy;
	        	matrix [position [0]][position [1]] = 'X';
	        }
	        System.out.println ("Would you like to play again?");
	        String s = sc.next();
	        if (s.equals ("N") || s.equals ("No")) {
	        	System.out.println ("Goodbye!");
	        	return;
	        	}
	    	}

	}

}


