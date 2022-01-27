package cen4010.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.Test;

import cen4010.pa4.Board;
class BoardTest {

		final int maxDimmensions = 100;
		@Test
		void testCreateBoard() {
			
			
			Random rand = new Random();
			int randM = rand.nextInt(maxDimmensions);
			int randN = rand.nextInt(maxDimmensions);
			Board.createBoard(randM, randN, 2);
			if(Board.gameboard[randM-1].length != randN)
				fail();
			else
				return;

		}


		@Test
		void testPlayerWin() {
			
			Random rand = new Random();
			int randM = Math.min(3,rand.nextInt(maxDimmensions));
			int randN = Math.min(3,rand.nextInt(maxDimmensions));
			int randK = Math.min(3,rand.nextInt(Math.min(randM, randN) ));
			
			
			
			//test horizontal
			Board.createBoard(randM, randN, randK);
			if(randK < randM) {
				for(int i = 0; i < randK; i++) {
					Board.gameboard[i][0] = 'x';
				}
				if(!Board.playerWin('x'))
					fail("failed horizontal check");
			}
			//test vertical
			Board.createBoard(randM, randN, randK);
			if(randK < randN) {
				for(int i = 0; i < randK; i++) {
					Board.gameboard[0][i] = 'x';
				}
				if(!Board.playerWin('x'))
					fail("failed vertical check");
			}
			//test Diagonal Bottom left 
			Board.createBoard(randM, randN, randK);
			if(randK < randN && randK < randM) {
				for(int i = 0; i< randK; i++) {
					Board.gameboard[i][i] = 'x';
				}
			}
			if(!Board.playerWin('x'))
				fail("failed vertical check");
			//test Diagonal Top left
			Board.createBoard(randM, randN, randK);
			if(randK < randN && randK < randM) {
				for(int i = 0; i < randK; i++) {
					for(int j = randN -1; j >= randN - randK; j--)
						Board.gameboard[i][j] = 'x';
				}
			}
			if(!Board.playerWin('x'))
				fail("failed vertical check");
			
			return;
		}

		@Test
		void testGameDraw() {
			Random rand = new Random();
			int randM = rand.nextInt(maxDimmensions);
			int randN = rand.nextInt(maxDimmensions);
			int randK = rand.nextInt(Math.min(randM, randN) );
			
			Board.createBoard(randM, randN, randK);
			
			for(int i = 0; i < randM ; i++)
				for(int j = 0; j < randN; j++)
					Board.gameboard[i][j] ='x';
			if(Board.gameDraw())
				return;
			else
				fail();
		}

	}

