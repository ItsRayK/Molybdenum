package controllers;

import player.*;
import builder.*;
import entities.*;

public class GetStateOfPuzzleBuilder {
	Puzzle puzzle;
	PuzzleBuilder puzzleBuilder;
	String levelName;
	Score OneStarScore;
	Score TwoStarScore;
	Score ThreeStarScore;

	public GetStateOfPuzzleBuilder(PuzzleBuilder pb, Puzzle p) {
		puzzleBuilder = pb;
		puzzle = p;

		for (int i = 0; i <= 5; i++) {
			for (int j = 0; j <= 5; j++) {
				if (puzzleBuilder.getCheckBox()[i][j].isSelected())
					puzzle.getBoard().activateSquare(i, j);
				else
					puzzle.getBoard().deActivateSquare(i, j);

			}

		}

		levelName = puzzleBuilder.getNameText();

		OneStarScore = new Score(Integer.parseInt(puzzleBuilder.getTxt1StarThresh().getText()));
		TwoStarScore = new Score(Integer.parseInt(puzzleBuilder.getTxt2StarThresh().getText()));
		ThreeStarScore = new Score(Integer.parseInt(puzzleBuilder.getTxt3StarThresh().getText()));
	}

	public void makePreview() {
		PuzzleView puzzleView = new PuzzleView(levelName, puzzle, OneStarScore, TwoStarScore, ThreeStarScore);
		puzzleView.setLevel(puzzle);
		puzzleView.setVisible(true);
	}

	public void saveLevel() {

	}
}
