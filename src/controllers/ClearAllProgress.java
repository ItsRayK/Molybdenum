package controllers;

import java.io.BufferedWriter;
import java.io.FileWriter;

import entities.Level;
import entities.Square;

/**
 * The Controller class for Clearing all Levels.
 * <p>
 * This allows the player to clear their scores and stars for all letters.
 * 
 * Creation date: (12/5/2016)
 * 
 * @author Thomas Hagen, Rachel Hahn, Rayyan Khan, Hannah Olshansky, Lauren
 *         Pontbriant (Molybdenum)
 * 
 */

public class ClearAllProgress {

	public ClearAllProgress() {

	}

	public void clearAllData() {
		String path = "src/SavedStars.txt";
		String scorePath = "src/SavedScores.txt";
		BufferedWriter bw;
		try {
			bw = new BufferedWriter(new FileWriter(path, false));
			for (int i = 0; i < 16; i++) {
				bw.write("0");
				bw.newLine();
				bw.flush();
				
			}
			bw = new BufferedWriter(new FileWriter(scorePath, false));
			for (int i = 0; i < 15; i++) {
				bw.write("0");
				bw.newLine();
				bw.flush();
			}
			bw.close();
		} catch (Exception e) {

		}

	}
}
