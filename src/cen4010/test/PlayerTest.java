package cen4010.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.Test;

import cen4010.pa4.Board;
import cen4010.pa4.Player;



class PlayerTest {

	@Test
	void testIsRobot() {
		Player testPlayer = new Player(true);
		if(testPlayer.isRobot())
			return;
		else
			fail();
	}

	@Test
	/*
	 * This test passes if every single move on the board is replaced with an 'x' this tests the easy version of the player object
	 * The goal is to have the player keep playing until the game state no longer allows it to continue.
	 */
	void testGetMove() {
		Player testAI = new Player(true);
		Random rand = new Random();
		int dimM = rand.nextInt(100);
		int dimN = rand.nextInt(100);
		Board.createBoard(dimM, dimN, 5);
		int[] moveResult = new int[2];
		for(int i = 0; i < dimM*dimN; i++) {
			moveResult = testAI.getMove('x');
			Board.gameboard[moveResult[0]][moveResult[1]] = 'x';
			System.out.println("Testing " + moveResult[0] + " "+ moveResult[1]);
		}
		for(int i = 0; i < dimM; i++) {
			for(int j = 0; j < dimN; j++) {
				if(Board.gameboard[i][j] != 'x')
					fail();
			}
				
		}
		return;
			
	
	}
	@Test
	void testPlayer() {
		Player testAI = new Player(true);
		testAI.toString();
		return;
	}
	@Test
	void testIsHarderRobot() {
		
			Player testAI = new Player(true);
			testAI.setHarderRobot();
			if(testAI.isHarderRobot())
				return;
			else
				fail();
	}
	@Test
	void testSetHarderRobot() {
		Player testAI = new Player(true);
		
		try {
			testAI.setHarderRobot();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return;
	}
	




	//In theory hard player 'x' should always win vs the dumber rng based fake Player
	@Test
	void testGetHardMove() {
		Player testAI = new Player(true);
		testAI.setHarderRobot();
		Player testAI2 = new Player(true);
		
		Board.createBoard(3, 3, 3);
		int[] moveResult = new int[2];
		boolean xcurrentPlayer = true;
		for(int i = 0; i < 3*3; i++) {
			if(xcurrentPlayer) {
				moveResult = testAI.getMove('x');
				Board.gameboard[moveResult[0]][moveResult[1]] = 'x';
				xcurrentPlayer = false;
			}else {
				moveResult= testAI2.getMove('o');
				Board.gameboard[moveResult[0]][moveResult[1]] = 'o';
				xcurrentPlayer = true;
			}
		}
		if(Board.playerWin('x')) {
			return;
		}
		fail();
		
			
	
	}

}
