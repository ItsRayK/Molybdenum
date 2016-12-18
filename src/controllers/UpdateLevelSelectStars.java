package controllers;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import entities.Level;
import entities.Word;

/**
 * The Controller class for updating the highest score.
 * <p>
 * This allows the player to see their highest score for a level on
 * the level chose screen.
 * 
 * Creation date: (12/5/2016)
 * 
 * @author Thomas Hagen, Rachel Hahn, Rayyan Khan, Hannah Olshansky, Lauren
 *         Pontbriant (Molybdenum)
 * 
 */

public class UpdateLevelSelectStars {
	Level level;
	BufferedWriter bw;
	int savedStars[];
	int savedScores[];

	public UpdateLevelSelectStars(Level p) {
		level = p;

	}

	/**
	 * Updates saved stars based on the highest amount of stars that were achieved
	 * in each game played.
	 * @throws IOException
	 */
	public void updateSavedStars() throws IOException {
		if (level.getLevelName().contains("Level")) {
			int scoreLineNum = Integer.parseInt(level.getLevelName().replace("Level ", ""));
			String path = "src/SavedStars.txt";

			savedStars = new int[16];
			for (int i = 0; i < 16; i++) {
				int readCheck = Integer.parseInt(Files.readAllLines(Paths.get(path)).get(i));
				savedStars[i] = readCheck;

				if (scoreLineNum - 1 == i) {
					int starsFilled;
					if (level.getCurrScore().isStar3Filled()) {
						starsFilled = 3;
						savedStars[i] = starsFilled;

					} else if (level.getCurrScore().isStar2Filled()) {
						starsFilled = 2;
						if (starsFilled >= savedStars[i]) {
							savedStars[i] = starsFilled;
						}

					} else if (level.getCurrScore().isStar1Filled()) {
						starsFilled = 1;
						if (starsFilled >= savedStars[i]) {
							savedStars[i] = starsFilled;
						}
					}
				}
			}

			bw = new BufferedWriter(new FileWriter("src/SavedStars.txt", false));
			for (int i = 0; i < 16; i++) {

				bw.write("" + savedStars[i]);
				bw.newLine();
				bw.flush();
			}
			bw.close();
		}
		
	}

	/**
	 * Updates saved score based on the highest score that was achieved
	 * in each game played.
	 * @throws IOException
	 */
	public void updateSavedScore() throws IOException {
		if (level.getLevelName().contains("Level")) {
			int scoreLineNum = Integer.parseInt(level.getLevelName().replace("Level ", ""));
			String path = "src/SavedScores.txt";

			savedScores = new int[15];
			for (int i = 0; i < 15; i++) {
				int readCheck = Integer.parseInt(Files.readAllLines(Paths.get(path)).get(i));
				savedScores[i] = readCheck;

				if (scoreLineNum - 1 == i) {
					if (level.getCurrScore().getScore() >= readCheck) {
						savedScores[i] = level.getCurrScore().getScore();

					}
				}
			}

			bw = new BufferedWriter(new FileWriter("src/SavedScores.txt", false));
			for (int i = 0; i < 15; i++) {

				bw.write("" + savedScores[i]);
				bw.newLine();
				bw.flush();
			}
			bw.close();
		}
		
	}

}
