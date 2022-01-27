package cen4010.pa4;

/*Board class - PA3
 * CEN4010
 * T4
 * Latest version: 11/11/21
 */
public class Board {
	
	public static char gameboard[][]; // 2D array game board
	public static char c; // either x or o
	public static int m; // rows
	public static int n; // columns
	public static int k; // score to win
	public static int turn_number=1;
	
	public static int XwinningM; //M for X to win
	public static int XwinningN; //N for X to win 
	public static int OwinningM; //M for O to win
	public static int OwinningN; //N for O to win
	
	
	
	
	
	
	
	
	private static void setWinningNumbers (char c, int m, int n) {
		if (c=='o') {
			Board.OwinningM=m;
			Board.OwinningN=n;
		}
		if (c=='x') {
			Board.XwinningM=m;
			Board.XwinningN=n;
		}
	}
	/**
	 * Instantiates the gameboard with inputs m by n
	 * @param m
	 * @param n
	 */
	public static void createBoard (int m, int n, int k) { // board constructor
		gameboard = new char [m][n];
		initBoard(m, n);
		Board.m = m;
		Board.n = n;
		Board.k = k;
	}
	
	private static void initBoard (int m, int n) {
		for(int i = 0; i < m; i++) {
			for(int j =0 ; j < n; j++) {
				gameboard[i][j] = 0;
			}
		}
		return;
	}
public static boolean hypotheticalPlayerWin(char c) { // checks for winning combinations
	
		
	char tempgameboard[][];
	setWinningNumbers('o',0,0);
	setWinningNumbers('x',0,0);
		for (int outerrow = 0; outerrow < m; outerrow++) {
	    	for (int outercol = 0; outercol < n; outercol++) {
	    		
	    		 tempgameboard= new char [m][n];
	    		
	    		for(int i = 0; i < n; i++) {
	    			tempgameboard[i]=gameboard[i].clone();	
	    		}
	    		
	    	
	    		if (tempgameboard[outerrow][outercol]!=0) {
	    		continue;
	    		}
	    		else {
	    		tempgameboard[outerrow][outercol]=c;
	    		}
		
	    /* check horizontal */
	    for (int row = 0; row < m; row++) {
	    	for (int col = 0; col < n; col++) {
		    	if (tempgameboard[row][col] == c) {
		    		int score = 1;
		    		int i = col+1;
	    			while (i<n && tempgameboard[row][i] == c) { // traverse right
			            i++;
	    				score++;
			            
	    				if (score >= k) { // reached required score
	    					
	    					setWinningNumbers(c,outerrow,outercol);
	    					System.out.println("O's Winning Numbers: "+OwinningM+ ", "+OwinningN);
	    					System.out.println("X's Winning Numbers: "+XwinningM+ ", "+XwinningN);
	    					System.out.println(row+ ", "+col);
			            	return true;
			            }		            				         
	    			}
		    	}
		    }
	    }


	    /* check vertical */
	    for (int col = 0; col < n; col++) {
	    	for (int row = 0; row < m; row++) {
		    	if (tempgameboard[row][col] == c) {
		    		int score = 1;
		    		int i = row+1;
	    			while (i<m && tempgameboard[i][col] == c) { // traverse down
			            score++;
			            i++;
			            
			            if (score >= k) { // reached required score
			            	System.out.println("true");
			            	setWinningNumbers(c,outerrow,outercol);
			            	System.out.println("O's Winning Numbers: "+OwinningM+ ", "+OwinningN);
			            	System.out.println("X's Winning Numbers: "+XwinningM+ ", "+XwinningN);
			            	System.out.println(row+ ", "+col);
			            	return true;
			            }		            
			        }
		    	}
		    }
	    }
	        
	    /* checks diagonals upwards */
	    for (int row = 0; row < m; row++) {
	    	for (int col = 0; col < n; col++) {		    	
	    		if (tempgameboard[row][col] == c) {
	 
			    	int score = 1; 		            
			    	int i = row - 1; // set row index for next point in diagonal		           
		            int j = col + 1; // set column index for next point in diagonal

		            while (i >= 0 && j<n && tempgameboard[i][j] == c) { // traverse diagonally up and to the right   
		                i--;			            	
		                j++;
		                score++;
		                
		                if (score >= k) { // reached required score
		                	setWinningNumbers(c,outerrow,outercol);
		                	System.out.println("O's Winning Numbers: "+OwinningM+ ", "+OwinningN);
		                	System.out.println("X's Winning Numbers: "+XwinningM+ ", "+XwinningN);
		                	System.out.println(row+ ", "+col);
		                	return true;
		                }		           
		            }
			    }
	    	}
	    }
	    
	    /* checks diagonals downwards */
	    for (int row = 0; row < m; row++) {
	    	for (int col = 0; col < n; col++) {		    	
	    		if (tempgameboard[row][col] == c) {
	 
			    	int score = 1; 		            
			    	int i = row + 1; // set row index for next point in diagonal		           
		            int j = col + 1; // set column index for next point in diagonal
		            //if (i<row && j<col) {
		            while (i<m && j<n && tempgameboard[i][j] == c) { //traverse diagonally down and to the right            	 
		                i++;	                	                
		                j++;
		                score++;
		                
		                if (score >= k) { // reach required score
		                	setWinningNumbers(c,outerrow,outercol);
		                	System.out.println("O's Winning Numbers: "+OwinningM+ ", "+OwinningN);
		                	System.out.println("X's Winning Numbers: "+XwinningM+ ", "+XwinningN);
		                	System.out.println(row+ ", "+col);
		           		 //System.out.println("true");
		                	return true;
		                }
		            }		            
			    }
	    	}
	    }
	    
	    
	    
	    tempgameboard[outerrow][outercol]=0;
	}//end outercol
	}//end outerrow
		
		 //System.out.println("false");
		return false;
	}
	public static boolean playerWin(char c) { // checks for winning combinations

	    /* check horizontal */
	    for (int row = 0; row < m; row++) {
	    	for (int col = 0; col < n; col++) {
		    	if (gameboard[row][col] == c) {
		    		int score = 1;
		    		int i = col+1;
	    			while (i<n && gameboard[row][i] == c) { // traverse right
			            i++;
	    				score++;
			            
	    				if (score >= k) { // reached required score
			            	return true;
			            }		            				         
	    			}
		    	}
		    }
	    }


	    /* check vertical */
	    for (int col = 0; col < n; col++) {
	    	for (int row = 0; row < m; row++) {
		    	if (gameboard[row][col] == c) {
		    		int score = 1;
		    		int i = row+1;
	    			while (i<m && gameboard[i][col] == c) { // traverse down
			            score++;
			            i++;
			            
			            if (score >= k) { // reached required score
			            	return true;
			            }		            
			        }
		    	}
		    }
	    }
	        
	    /* checks diagonals upwards */
	    for (int row = 0; row < m; row++) {
	    	for (int col = 0; col < n; col++) {		    	
	    		if (gameboard[row][col] == c) {
	 
			    	int score = 1; 		            
			    	int i = row - 1; // set row index for next point in diagonal		           
		            int j = col + 1; // set column index for next point in diagonal

		            while (i >= 0 && j<n && gameboard[i][j] == c) { // traverse diagonally up and to the right   
		                i--;			            	
		                j++;
		                score++;
		                
		                if (score >= k) { // reached required score
		                	return true;
		                }		           
		            }
			    }
	    	}
	    }
	    
	    /* checks diagonals downwards */
	    for (int row = 0; row < m; row++) {
	    	for (int col = 0; col < n; col++) {		    	
	    		if (gameboard[row][col] == c) {
	 
			    	int score = 1; 		            
			    	int i = row + 1; // set row index for next point in diagonal		           
		            int j = col + 1; // set column index for next point in diagonal
		            //if (i<row && j<col) {
		            while (i<m && j<n && gameboard[i][j] == c) { //traverse diagonally down and to the right            	 
		                i++;	                	                
		                j++;
		                score++;
		                
		                if (score >= k) { // reach required score
		                	return true;
		                }
		            }		            
			    }
	    	}
	    	
	    }
	   
		return false;
	}
	
	public static boolean gameDraw() { // checks for draw condition
	    for (int i = 0; i < m; i++) {
	        for (int j = 0; j < n; j++) {
	            if (gameboard[i][j] == 0) {
	                return false;
	            }
	        }
	    }
	    return true;
	}
}
	
