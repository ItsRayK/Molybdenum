package player;

import static org.junit.Assert.*;

import org.junit.Test;

import entities.*;
import entities.Lightning;
import entities.Puzzle;
import entities.Theme;

public class PlayerTestCases {

	public PuzzleView setupPuzzleLevel() {

		Puzzle puzzle = new Puzzle("Test", new Board());
		PuzzleView puzzleView = new PuzzleView("Test", puzzle);
		return puzzleView;
	}

	public LightningView setupLightningLevel() {

		Lightning lightning = new Lightning("Test", new Board());
		LightningView lightningView = new LightningView("Test", lightning);
		return lightningView;
	}

	public ThemeView setupThemeLevel() {

		Theme theme = new Theme("Test", new Board());
		ThemeView themeView = new ThemeView("Test", theme);
		return themeView;
	}

	@Test
	public void testPuzzlePlayer() {
		PuzzleView pV = setupPuzzleLevel();
		pV.initialize();
		// Click a square and see if the current word is that square, then
		// deselect the square
		pV.getBoardSquares()[1][5].doClick();
		assertTrue(pV.getLevel().getCurrentWord().getLastSquare().isSameSquare(pV.getLevel().getBoard().squares[1][5]));
		pV.getBoardSquares()[1][5].doClick();

		// set the values for the score thresholds and the word limit
		pV.getLevel().setOneStarScore(new Score(1));
		pV.getLevel().setTwoStarScore(new Score(5));
		pV.getLevel().setThreeStarScore(new Score(10));
		pV.getLevel().setWordLimit(3);

		// set up a word that will give you some stars
		pV.getLevel().getBoard().squares[0][0].setContents(new Letter('A', 1));
		pV.getLevel().getBoard().squares[0][1].setContents(new Letter('D', 1));
		pV.getLevel().getBoard().squares[0][2].setContents(new Letter('D', 1));

		// setup more words for later
		pV.getLevel().getBoard().squares[0][3].setContents(new Letter('H', 1));
		pV.getLevel().getBoard().squares[0][4].setContents(new Letter('E', 1));
		pV.getLevel().getBoard().squares[0][5].setContents(new Letter('Y', 1));

		pV.getLevel().getBoard().squares[1][1].setContents(new Letter('T', 1));
		pV.getLevel().getBoard().squares[2][2].setContents(new Letter('E', 1));
		pV.getLevel().getBoard().squares[3][1].setContents(new Letter('S', 1));
		pV.getLevel().getBoard().squares[3][2].setContents(new Letter('T', 1));

		// get the squares below those to test float up
		Square square = new Square(0, 3, true);
		square.setContents(pV.getLevel().getBoard().squares[0][3].getContents());
		// pick that word
		pV.getBoardSquares()[0][0].doClick();
		pV.getBoardSquares()[0][1].doClick();
		pV.getBoardSquares()[0][2].doClick();

		// submit that word
		pV.getBtnSubmitWord().doClick();
		assertEquals(pV.getLevel().getCurrScore().getScore(), 3);
		// assertEquals(pV.getLevel().getWordsFound().get(pV.getLevel().getWordsFound().size()
		// - 1).getWordString(), "ADD");
		// test float up
		assertEquals(pV.getLevel().getBoard().squares[0][0].getContentsString(), square.getContentsString());

		// undo that word
		pV.getBtnUndo().doClick();
		assertEquals(pV.getLevel().getCurrScore().getScore(), 0);

		// repick that word
		pV.getBoardSquares()[0][0].doClick();
		pV.getBoardSquares()[0][1].doClick();
		pV.getBoardSquares()[0][2].doClick();

		// pick the second word but first submit you accidently forgot to hit
		// last button
		pV.getBoardSquares()[0][0].doClick();
		pV.getBoardSquares()[0][1].doClick();
		pV.getBtnSubmitWord().doClick();

		pV.getBoardSquares()[0][0].doClick();
		pV.getBoardSquares()[0][1].doClick();
		pV.getBoardSquares()[0][2].doClick();
		pV.getBtnSubmitWord().doClick();

		// pick the third word and you accident pick a square thats too far away
		pV.getBoardSquares()[1][1].doClick();
		pV.getBoardSquares()[2][2].doClick();
		pV.getBoardSquares()[0][0].doClick();
		pV.getBoardSquares()[3][1].doClick();
		pV.getBoardSquares()[3][2].doClick();
		pV.getBtnSubmitWord().doClick();
	}

	@Test
	public void testLightningPlayer() {
		LightningView lV = setupLightningLevel();
		lV.initialize();
	}

	@Test
	public void testThemePlayer() {
		ThemeView tV = setupThemeLevel();
		tV.initialize();
	}

}
