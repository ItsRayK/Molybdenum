package controllers;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import entities.Level;
import entities.Word;

public class UpdateLevelSelectStars {
	Level level;
	BufferedWriter bw;
	int savedStars[];

	public UpdateLevelSelectStars(Level p) {
		level = p;

	}

	public void updateSavedStars() throws IOException {
		int scoreLineNum = Integer.parseInt(level.getLevelName().replace("Level ", ""));
		String path = "src/SavedStars.txt";

		savedStars = new int[15];
		for (int i = 0; i < 15; i++) {
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
		for (int i = 0; i < 15; i++) {

			bw.write("" + savedStars[i]);
			bw.newLine();
			bw.flush();
		}
	}

	
}
