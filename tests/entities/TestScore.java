package entities;

import java.util.ArrayList;

import junit.framework.TestCase;

public class TestScore extends TestCase {
	public void testStart() {
		// start with sample 6x6
		Board b = new Board();
        Lightning testLevel = new Lightning("Test Level",b); 
		// someone needs to do random letter assignment.
		Square[][] active = b.activeSquares();

		String init = "RAINGFLEASHMCARDOEWORDPLMENWOMEQZSNE";
		int idx = 0;
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				active[i][j].fillSquare(new Letter(init.charAt(idx), 1));
				idx++;
			}
		}
 
			//I get an error when I try this and I don't know how to fix it
        testLevel.setOneStarScore(new Score(30));
		testLevel.setTwoStarScore(new Score(60));
		testLevel.setThreeStarScore(new Score(100));
		
		ArrayList<Square> squares = new ArrayList<Square>();
		squares.add(active[0][4]);
		squares.add(active[1][4]);
		squares.add(active[2][4]);
		
		Word w = new Word(squares);
		assertEquals(6, testLevel.currScore.getScore());
		assertFalse(testLevel.currScore.star1Filled);
		assertFalse(testLevel.currScore.star2Filled);
		assertFalse(testLevel.currScore.star3Filled);
		
		testLevel.currentWord = w;
		testLevel.submitWord();
		
		squares.add(active[3][4]);
		squares.add(active[4][4]);
		squares.add(active[5][4]);
		squares.add(active[5][5]);
		squares.add(active[4][5]);
		testLevel.submitWord();
		
		assertEquals(39, testLevel.currScore.getScore());
		assertTrue(testLevel.currScore.star1Filled);
		assertFalse(testLevel.currScore.star2Filled);
		assertFalse(testLevel.currScore.star3Filled);
		
		squares.add(active[0][3]);
		squares.add(active[1][3]);
		squares.add(active[2][3]);
		squares.add(active[3][3]);
		testLevel.submitWord();
		
		assertEquals(59, testLevel.currScore.getScore());
		assertTrue(testLevel.currScore.star1Filled);
		assertFalse(testLevel.currScore.star2Filled);
		assertFalse(testLevel.currScore.star3Filled);

		squares.add(active[3][2]);
		squares.add(active[4][2]);
		squares.add(active[5][2]);
		testLevel.submitWord();
		
		assertEquals(65, testLevel.currScore.getScore());
		assertTrue(testLevel.currScore.star1Filled);
		assertTrue(testLevel.currScore.star2Filled);
		assertFalse(testLevel.currScore.star3Filled);
		
		squares.add(active[0][2]);
		squares.add(active[1][2]);
		squares.add(active[2][2]);
		testLevel.submitWord();
		
		assertEquals(72, testLevel.currScore.getScore());
		assertTrue(testLevel.currScore.star1Filled);
		assertTrue(testLevel.currScore.star2Filled);
		assertFalse(testLevel.currScore.star3Filled);
	    
		squares.add(active[0][1]);
		squares.add(active[1][1]);
		squares.add(active[2][1]);
		squares.add(active[3][1]);
		squares.add(active[4][1]);
		testLevel.submitWord();
		
		assertEquals(102, testLevel.currScore.getScore());
		assertTrue(testLevel.currScore.star1Filled);
		assertTrue(testLevel.currScore.star2Filled);
		assertTrue(testLevel.currScore.star3Filled);
	}
}


