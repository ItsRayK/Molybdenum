package controllers;

import java.io.IOException;
import java.nio.file.*;

import entities.Puzzle;
import entities.Score;
import player.PuzzleView;

/**
 * The Controller class for loading a Puzzle Level.
 * <p>
 * This allows the player to load a Puzzle Level.
 * 
 * Creation date: (12/5/2016)
 * 
 * @author Thomas Hagen, Rachel Hahn, Rayyan Khan, Hannah Olshansky, Lauren
 *         Pontbriant (Molybdenum)
 * 
 */

public class LoadPuzzleLevel {
	int k = 4;
	Puzzle puzzle;
	String fileName;
	String levelName;
	Score OneStarScore;
	Score TwoStarScore;
	Score ThreeStarScore;
	int wordLimit;

	public LoadPuzzleLevel(String fileName, Puzzle p) throws IOException {
		this.fileName = fileName;
		puzzle = p;
		String path = "savedLevels/" + fileName + ".txt";
		levelName = Files.readAllLines(Paths.get(path)).get(0);
		OneStarScore = new Score(Integer.parseInt(Files.readAllLines(Paths.get(path)).get(1)));
		TwoStarScore = new Score(Integer.parseInt(Files.readAllLines(Paths.get(path)).get(2)));
		ThreeStarScore = new Score(Integer.parseInt(Files.readAllLines(Paths.get(path)).get(3)));
		wordLimit = Integer.parseInt(Files.readAllLines(Paths.get(path)).get(40));
		for (int i = 0; i <= 5; i++) {
			for (int j = 0; j <= 5; j++) {

				String readCheck = Files.readAllLines(Paths.get(path)).get(k);
				if (readCheck.equals("true")) {
					puzzle.getBoard().activateSquare(i, j);
				} else {
					puzzle.getBoard().deActivateSquare(i, j);

				}
				k++;
			}
		}
	}

	/**
	 * Loads a Puzzle Level that was previously created and saved.
	 */
	public void loadPuzzle() {
		PuzzleView frame = new PuzzleView(levelName, puzzle);
		puzzle.setOneStarScore(OneStarScore);
		puzzle.setTwoStarScore(TwoStarScore);
		puzzle.setThreeStarScore(ThreeStarScore);
		puzzle.setWordLimit(wordLimit);
		frame.setLevel(puzzle);
		frame.initialize();
		frame.setVisible(true);
	}

}
