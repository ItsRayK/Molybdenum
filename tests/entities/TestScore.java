package entities;

import java.util.ArrayList;

import junit.framework.TestCase;

public class TestScore extends TestCase {
	public void testStart() {
		// start with sample 6x6
		Board b = new Board();
        Puzzle testLevel = new Puzzle("Test Level",b); 
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
        //testLevel.setOneStarScore(30);
		//testLevel.setTwoStarScore(60);
		//setThreeStarScore(100);
		ArrayList<Square> squares = new ArrayList<Square>();
		squares.add(active[0][4]);
		squares.add(active[1][4]);
		squares.add(active[2][4]);
		
		Word w = new Word(squares);
		assertEquals(6, testLevel.currScore.getScore());
		assertFalse(testLevel.currScore.star1Filled);
	}
}


