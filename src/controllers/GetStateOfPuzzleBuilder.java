package controllers;

import java.io.*;

import builder.*;
import entities.*;
import player.PuzzleView;

public class GetStateOfPuzzleBuilder {
	Puzzle puzzle;
	PuzzleBuilder puzzleBuilder;
	String levelName;
	Score OneStarScore;
	Score TwoStarScore;
	Score ThreeStarScore;
	BufferedWriter bw = null;
	File file;

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

	}

	public PreviewPuzzle makePreview() {

		PreviewPuzzle puzzleView = new PreviewPuzzle(levelName, puzzle, OneStarScore, TwoStarScore, ThreeStarScore);
		puzzleView.setLevel(puzzle);
		puzzleView.initialize();
		puzzleView.setVisible(true);
		return puzzleView;
	}

	public void saveLevel() {
		OneStarScore = new Score(Integer.parseInt(puzzleBuilder.getTxt1StarThresh().getText()));
		TwoStarScore = new Score(Integer.parseInt(puzzleBuilder.getTxt2StarThresh().getText()));
		ThreeStarScore = new Score(Integer.parseInt(puzzleBuilder.getTxt3StarThresh().getText()));

		file = new File("savedLevels/" + levelName + ".txt");

		FileWriter writer = null;
		try {
			bw = new BufferedWriter(new FileWriter(file, false));
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

			bw.write(puzzleBuilder.getMaxWords().getText());
			bw.newLine();
			bw.flush();
			bw.write("Puzzle");
			bw.newLine();
			bw.flush();

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

	public void deletePuzzle() {
		String path = "savedLevels/" + levelName + ".txt";
		file = new File(path);
		if (file.delete()) {
			System.out.println("'" + levelName + "'" + " has been deleted");
		} else
			System.out.println("'" + levelName + "'" + " already does not exist");
		;

	}

}
