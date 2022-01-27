package cen4010.pa4;

import java.util.Random;

public class Player {
	
	boolean isRobot;
	boolean isHarderRobot=false;
	
	public Player(boolean robot) {
		this.isRobot = robot;
	}
	public void setHarderRobot() {
		this.isHarderRobot=true;
	}
	public boolean isHarderRobot() {
		return this.isHarderRobot;
	}
	
	
	public boolean isRobot() {
		return this.isRobot;
	}
/**
 * Generates a move for an ai player	
 * @return
 */
public int[] getMove(char player) {
		
		int[] coordinate = new int[2];
		//get maximums of the board
		int maxM = Board.m;
		int maxN = Board.n;
		//if easy
		
		if(!isHarderRobot()) {
			Random rand = new Random();
			int randM;
			int randN;
			do {
				randM = rand.nextInt(maxM);
				randN = rand.nextInt(maxN);
			}while(Board.gameboard[randM][randN] != 0);
			
			coordinate[0] = randM;
			coordinate[1] = randN;
			return coordinate;
		}else {
			//replaces getHardMove()
			System.out.println("Harder Move Played");
			if (Board.hypotheticalPlayerWin('x')&&player=='x') 
			{
				
				System.out.printf("\n\n1"+player + "=x \n\n");
					System.out.println("X should win");
					coordinate[0]=Board.XwinningM;
					coordinate[1]=Board.XwinningN;
					System.out.print(coordinate[0] + ", " + coordinate[1]);
					return coordinate;
				
			}
			else
			if (Board.hypotheticalPlayerWin('o')&&(player=='o') )
			{
				System.out.printf("\n\n2"+player + "=o \n\n");
				
					System.out.println("O should win");
					coordinate[0]=Board.OwinningM;
					coordinate[1]=Board.OwinningN;
					System.out.print(coordinate[0] + ", " + coordinate[1]);
					return coordinate;
				
			}
			
				if (Board.hypotheticalPlayerWin('x')&&(player=='o') ) {
					System.out.printf("\n\n3"+player + "=o \n\n");
					
						System.out.println("O should block");
						coordinate[0]=Board.XwinningM;
						coordinate[1]=Board.XwinningN;
						System.out.print(coordinate[0] + ", " + coordinate[1]);
						return coordinate;
					
				}
				
				if (Board.hypotheticalPlayerWin('o') &&(player=='x') ) {
					System.out.printf("\n\n4"+player + "=x \n\n");
					
						System.out.println("X should block");
						coordinate[0]=Board.OwinningM;
						coordinate[1]=Board.OwinningN;
						System.out.print(coordinate[0] + ", " + coordinate[1]);
						return coordinate;
					
				
				}
				
			
			
				Random rand = new Random();
				int randM;
				int randN;
				do {
					randM = rand.nextInt(maxM);
					randN = rand.nextInt(maxN);
				}while(Board.gameboard[randM][randN] != 0);
				
				coordinate[0] = randM;
				coordinate[1] = randN;
				return coordinate;
				}
		}
		//else use minmaxxing
		/**TODO**/
		
		
		
	



//public int[] getHardMove(char player) {
//	System.out.println("harder move played");
//	int[] coordinate = new int[2];
//	//get maximums of the board
//	int maxM = Board.m;
//	int maxN = Board.n;
//	//if easy
//	
//
//	
//	
//	if (Board.hypotheticalPlayerWin('x')&&player=='x') 
//	{
//		
//		System.out.printf("\n\n1"+player + "=x \n\n");
//			System.out.println("X should win");
//			coordinate[0]=Board.XwinningM;
//			coordinate[1]=Board.XwinningN;
//			System.out.print(coordinate[0] + ", " + coordinate[1]);
//			return coordinate;
//		
//	}
//	else
//	if (Board.hypotheticalPlayerWin('o')&&(player=='o') )
//	{
//		System.out.printf("\n\n2"+player + "=o \n\n");
//		
//			System.out.println("O should win");
//			coordinate[0]=Board.OwinningM;
//			coordinate[1]=Board.OwinningN;
//			System.out.print(coordinate[0] + ", " + coordinate[1]);
//			return coordinate;
//		
//	}
//	
//		if (Board.hypotheticalPlayerWin('x')&&(player=='o') ) {
//			System.out.printf("\n\n3"+player + "=o \n\n");
//			
//				System.out.println("O should block");
//				coordinate[0]=Board.XwinningM;
//				coordinate[1]=Board.XwinningN;
//				System.out.print(coordinate[0] + ", " + coordinate[1]);
//				return coordinate;
//			
//		}
//		
//		if (Board.hypotheticalPlayerWin('o') &&(player=='x') ) {
//			System.out.printf("\n\n4"+player + "=x \n\n");
//			
//				System.out.println("X should block");
//				coordinate[0]=Board.OwinningM;
//				coordinate[1]=Board.OwinningN;
//				System.out.print(coordinate[0] + ", " + coordinate[1]);
//				return coordinate;
//			
//		
//		}
//		
//	
//	
//		Random rand = new Random();
//		int randM;
//		int randN;
//		do {
//			randM = rand.nextInt(maxM);
//			randN = rand.nextInt(maxN);
//		}while(Board.gameboard[randM][randN] != 0);
//		
//		coordinate[0] = randM;
//		coordinate[1] = randN;
//		return coordinate;
//		}

}
