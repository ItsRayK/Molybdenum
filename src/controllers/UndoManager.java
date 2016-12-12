package controllers;

import entities.*;
import player.*;

public class UndoManager {
	Puzzle puzzle;
	PuzzleView puzzleview;

	public UndoManager(PuzzleView pV, Puzzle p) {
		puzzleview = pV;
		puzzle = p;
	}

	public void undoLevel() {
		try {
			puzzle.undoWord();
			puzzleview.unselectBoardSquares();
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
