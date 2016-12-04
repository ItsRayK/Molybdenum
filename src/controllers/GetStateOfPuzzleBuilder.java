package controllers;

import player.*;

import java.io.*;

import builder.*;
import entities.*;

public class GetStateOfPuzzleBuilder {
	Puzzle puzzle;
	PuzzleBuilder puzzleBuilder;
	String levelName;
	Score OneStarScore;
	Score TwoStarScore;
	Score ThreeStarScore;
	BufferedWriter bw = null;

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

		// puzzleBuilder.getTxt1StarThresh().getText()
		// puzzleBuilder.getTxt2StarThresh().getText()
		// puzzleBuilder.getTxt3StarThresh().getText()

		OneStarScore = new Score(Integer.parseInt(puzzleBuilder.getTxt1StarThresh().getText()));
		TwoStarScore = new Score(Integer.parseInt(puzzleBuilder.getTxt2StarThresh().getText()));
		ThreeStarScore = new Score(Integer.parseInt(puzzleBuilder.getTxt3StarThresh().getText()));
	}

	public void makePreview() {
		PuzzleView puzzleView = new PuzzleView(levelName, puzzle, OneStarScore, TwoStarScore, ThreeStarScore);
		puzzleView.setLevel(puzzle);
		puzzleView.initialize();
		puzzleView.setVisible(true);
	}

	public void saveLevel() {
		String userName = System.getProperty("user.name");
		File dir = new File("C:\\Users\\" + userName + "\\Desktop\\LetterCrazeLevels\\");
		dir.mkdir();
		File file = new File("C:\\Users\\" + userName + "\\Desktop\\LetterCrazeLevels\\" + levelName + ".txt");

		FileWriter writer = null;
		try {
			bw = new BufferedWriter(new FileWriter(file, false));
//			writer = new FileWriter(file);
//			writer.write(levelName + "\r\n" + puzzleBuilder.getTxt1StarThresh().getText() + "\r\n"
//					+ puzzleBuilder.getTxt2StarThresh().getText() + "\r\n"
//					+ puzzleBuilder.getTxt3StarThresh().getText());
			bw.write(levelName);
			bw.newLine();
			bw.flush();
			bw.write(puzzleBuilder.getTxt1StarThresh().getText());
			bw.newLine();
			bw.flush();
			bw.write(puzzleBuilder.getTxt2StarThresh().getText());
			bw.newLine();
			bw.flush();
			bw.write(puzzleBuilder.getTxt3StarThresh().getText());
			bw.newLine();
			bw.flush();
			

			for (int i = 0; i <= 5; i++) {
				for (int j = 0; j <= 5; j++) {
					if (puzzleBuilder.getCheckBox()[i][j].isSelected()) {
						bw.write("true");
						bw.newLine();
						bw.flush();
					} else {
						bw.write("false");
						bw.newLine();
						bw.flush();
					}
				}
			}

		} catch (IOException e) {
			e.printStackTrace(); // I'd rather declare method with throws
									// IOException and omit this catch.
		} finally {
			if (writer != null)
				try {
					bw.close();
					writer.close();
				} catch (IOException ignore) {
				}
		}

		System.out.printf("File is located at %s%n", file.getAbsolutePath());

	}

}
