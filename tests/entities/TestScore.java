package entities;

import java.util.ArrayList;

import junit.framework.TestCase;

public class TestScore extends TestCase {
	public void testStart() {
		// start with sample 6x6
		Board b = new Board();
		Lightning testLevel = new Lightning("Test Level", b);
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

		// I get an error when I try this and I don't know how to fix it
		testLevel.setOneStarScore(new Score(25));
		testLevel.setTwoStarScore(new Score(28));
		testLevel.setThreeStarScore(new Score(45));

		ArrayList<Square> squares = new ArrayList<Square>();
		Word w = new Word(squares);
		w.makeWord(active[0][4]);
		w.makeWord(active[1][4]);
		w.makeWord(active[2][4]);

		assertEquals(3, w.getPoints());

		assertEquals(0, testLevel.currScore.getScore());
		assertFalse(testLevel.currScore.star1Filled);
		assertFalse(testLevel.currScore.star2Filled);
		assertFalse(testLevel.currScore.star3Filled);

		testLevel.setCurrentWord(w);
		testLevel.submitWord();
		ArrayList<Square> squares2 = new ArrayList<Square>();
		Word w2 = new Word(squares2);
		testLevel.setCurrentWord(w2);

		assertEquals(0, testLevel.getCurrentWord().getPoints());
		assertEquals(3, testLevel.getCurrScore().getScore());

		w2.makeWord(active[3][4]);
		w2.makeWord(active[4][4]);
		w2.makeWord(active[5][4]);
		w2.makeWord(active[5][5]);
		w2.makeWord(active[4][5]);
		testLevel.submitWord();
		testLevel.compareToGoalScores();

		assertEquals(18, testLevel.currScore.getScore());
		assertFalse(testLevel.currScore.isStar1Filled());
		assertFalse(testLevel.currScore.isStar2Filled());
		assertFalse(testLevel.currScore.isStar3Filled());

		ArrayList<Square> squares3 = new ArrayList<Square>();
		Word w3 = new Word(squares3);
		testLevel.setCurrentWord(w3);

		w3.makeWord(active[0][3]);
		w3.makeWord(active[1][3]);
		w3.makeWord(active[2][3]);
		w3.makeWord(active[3][3]);
		testLevel.submitWord();

		assertEquals(26, testLevel.currScore.getScore());
		assertTrue(testLevel.currScore.star1Filled);
		assertFalse(testLevel.currScore.star2Filled);
		assertFalse(testLevel.currScore.star3Filled);

		ArrayList<Square> squares4 = new ArrayList<Square>();
		Word w4 = new Word(squares4);
		testLevel.setCurrentWord(w4);

		w4.makeWord(active[3][2]);
		w4.makeWord(active[4][2]);
		w4.makeWord(active[5][2]);
		testLevel.submitWord();

		assertEquals(29, testLevel.currScore.getScore());
		assertTrue(testLevel.currScore.star1Filled);
		assertTrue(testLevel.currScore.star2Filled);
		assertFalse(testLevel.currScore.star3Filled);

		ArrayList<Square> squares5 = new ArrayList<Square>();
		Word w5 = new Word(squares5);
		testLevel.setCurrentWord(w5);

		w5.makeWord(active[0][2]);
		w5.makeWord(active[1][2]);
		w5.makeWord(active[2][2]);
		testLevel.submitWord();

		assertEquals(32, testLevel.currScore.getScore());
		assertTrue(testLevel.currScore.star1Filled);
		assertTrue(testLevel.currScore.star2Filled);
		assertFalse(testLevel.currScore.star3Filled);

		ArrayList<Square> squares6 = new ArrayList<Square>();
		Word w6 = new Word(squares6);
		testLevel.setCurrentWord(w6);

		w6.makeWord(active[0][1]);
		w6.makeWord(active[1][1]);
		w6.makeWord(active[2][1]);
		w6.makeWord(active[3][1]);
		w6.makeWord(active[4][1]);
		testLevel.submitWord();

		assertEquals(47, testLevel.currScore.getScore());
		assertTrue(testLevel.currScore.star1Filled);
		assertTrue(testLevel.currScore.star2Filled);
		assertTrue(testLevel.currScore.star3Filled);
	}
}
