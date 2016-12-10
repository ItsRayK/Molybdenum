package controllers;

import java.io.BufferedWriter;
import java.io.FileWriter;

import entities.Level;
import entities.Square;

public class ClearAllProgress {

	public ClearAllProgress() {

	}

	public void clearAllStars() {
		String path = "src/SavedStars.txt";
		BufferedWriter bw;
		try {
			bw = new BufferedWriter(new FileWriter(path, false));
			for (int i = 0; i < 15; i++) {
				bw.write("0");
				bw.newLine();
				bw.flush();
			}
		} catch (Exception e) {

		}

	}
}
