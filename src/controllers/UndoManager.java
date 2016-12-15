package controllers;

import entities.*;
import player.*;

/**
 * The Controller class for undoing a word.
 * <p>
 * This allows the player to undo the previous word they have created.
 * 
 * Creation date: (12/5/2016)
 * 
 * @author Thomas Hagen, Rachel Hahn, Rayyan Khan, Hannah Olshansky, Lauren
 *         Pontbriant (Molybdenum)
 * 
 */

public class UndoManager {
	Puzzle puzzle;
	PuzzleView puzzleview;
	Theme theme;
	ThemeView themeview;

	public UndoManager(PuzzleView pV, Puzzle p) {
		puzzleview = pV;
		puzzle = p;
	}

	public UndoManager(ThemeView pV, Theme p) {
		themeview = pV;
		theme = p;
	}

	/**
	 * Undo previous move by deleting the word from the list of words, deleting the 
	 * points from getting that word, adding to the words left, and setting the 
	 * board back to its previous state.
	 */
	public void undoLevel() {
		try {
			puzzle.undoWord();
			puzzleview.unselectBoardSquares();
			puzzle.getLettersSelected().clear();
			puzzleview.removeFromWordsFound();
			puzzleview.updateStars();

			for (int i = 0; i <= 5; i++) {
				for (int j = 0; j <= 5; j++) {
					if (puzzle.getBoard().squares[i][j].isActive()) {
						puzzleview.getBoardSquares()[i][j].setText("<html><b>"
								+ puzzle.getBoard().squares[i][j].getContentsString() + "</b><font size = '3'><sub>"
								+ puzzle.getBoard().squares[i][j].getContentsPoints() + "</sub></font></html>");
					}
				}
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("There are no moves to be undone!");
		}
	}

	
}
