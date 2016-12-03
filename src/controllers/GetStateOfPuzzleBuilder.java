package controllers;

import player.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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
		
//		puzzleBuilder.getTxt1StarThresh().getText()
//		puzzleBuilder.getTxt2StarThresh().getText()
//		puzzleBuilder.getTxt3StarThresh().getText()

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
		String userName = System.getProperty("user.name");
		File dir = new File("C:\\Users\\" + userName + "\\Desktop\\LetterCrazeLevels\\");
		dir.mkdir();
		File file = new File("C:\\Users\\" + userName + "\\Desktop\\LetterCrazeLevels\\" + levelName +".txt");
		
	    FileWriter writer = null;
	    try {
	        writer = new FileWriter(file);
	        writer.write(levelName + "\r\n" + puzzleBuilder.getTxt1StarThresh().getText() + "\r\n" + puzzleBuilder.getTxt2StarThresh().getText() + "\r\n" + puzzleBuilder.getTxt3StarThresh().getText());
	    } catch (IOException e) {
	        e.printStackTrace(); // I'd rather declare method with throws IOException and omit this catch.
	    } finally {
	        if (writer != null) try { writer.close(); } catch (IOException ignore) {}
	    }
	    System.out.printf("File is located at %s%n", file.getAbsolutePath());
		
	}
}
