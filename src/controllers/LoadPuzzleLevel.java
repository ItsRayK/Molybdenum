package controllers;

import java.io.IOException;
import java.nio.file.*;

import entities.Puzzle;
import entities.Score;
import player.PuzzleView;

public class LoadPuzzleLevel {
	int k = 4;
	Puzzle puzzle;
	String fileName;
	String levelName;
	Score OneStarScore;
	Score TwoStarScore;
	Score ThreeStarScore;
	String userName = System.getProperty("user.name");;

	public LoadPuzzleLevel(String fileName, Puzzle p) throws IOException {
		this.fileName = fileName;
		puzzle = p;

		levelName = Files
				.readAllLines(
						Paths.get("C:\\Users\\" + userName + "\\Desktop\\LetterCrazeLevels\\" + fileName + ".txt"))
				.get(0);
		OneStarScore = new Score(Integer.parseInt(
				Files.readAllLines(Paths.get("C:\\Users\\" + userName + "\\Desktop\\LetterCrazeLevels\\" + fileName + ".txt"))
						.get(1)));
		TwoStarScore = new Score(Integer.parseInt(
				Files.readAllLines(Paths.get("C:\\Users\\" + userName + "\\Desktop\\LetterCrazeLevels\\" + fileName + ".txt"))
						.get(2)));
		ThreeStarScore = new Score(Integer.parseInt(
				Files.readAllLines(Paths.get("C:\\Users\\" + userName + "\\Desktop\\LetterCrazeLevels\\" + fileName + ".txt"))
						.get(3)));
		System.out.println(Integer.parseInt(
				Files.readAllLines(Paths.get("C:\\Users\\" + userName + "\\Desktop\\LetterCrazeLevels\\" + fileName + ".txt"))
						.get(3)));
		for (int i = 0; i <= 5; i++) {
			for (int j = 0; j <= 5; j++) {
				
				String readCheck = Files
						.readAllLines(Paths
								.get("C:\\Users\\" + userName + "\\Desktop\\LetterCrazeLevels\\" + levelName + ".txt"))
						.get(k);
				if (readCheck.equals("true")) {
					puzzle.getBoard().activateSquare(i, j);
				} else{
					puzzle.getBoard().deActivateSquare(i, j);

				}
				k++;
			}
		}
	}

	public void loadPuzzle(){
		PuzzleView frame = new PuzzleView(levelName, puzzle, OneStarScore, TwoStarScore, ThreeStarScore);
		frame.setLevel(puzzle);
		frame.initialize();
		frame.setVisible(true);
	}

}
