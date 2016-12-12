package controllers;

import entities.*;
import player.*;

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

	public void undoLevelTheme() {
		try {
			theme.undoWord();
			themeview.unselectBoardSquares();
			theme.getLettersSelected().clear();
			themeview.removeFromWordsFound();
			themeview.updateStars();

			for (int i = 0; i <= 5; i++) {
				for (int j = 0; j <= 5; j++) {
					if (theme.getBoard().squares[i][j].isActive()) {
						if (!themeview.getBoardSquares()[i][j].isVisible()) {

							if (theme.getBoard().squares[i][j].isEmpty())
								themeview.getBoardSquares()[i][j].setVisible(false);

							themeview.getBoardSquares()[i][j].setVisible(true);
						}
						themeview.getBoardSquares()[i][j].setText(
								"<html><b>" + theme.getBoard().squares[i][j].getContentsString() + "</font></html>");
					}

				}
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("There are no moves to be undone!");
		}
	}
}
