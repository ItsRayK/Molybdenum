package controllers;

import java.io.IOException;
import java.nio.file.*;

import entities.Lightning;
import entities.Puzzle;
import entities.Score;
import player.LightningView;
import player.PuzzleView;

public class LoadLightningLevel {
	int k = 4;
	Lightning lightning;
	String fileName;
	String levelName;
	Score OneStarScore;
	Score TwoStarScore;
	Score ThreeStarScore;

	public LoadLightningLevel(String fileName, Lightning p) throws IOException {
		this.fileName = fileName;
		lightning = p;
		String path = "savedLevels/" + fileName + ".txt";
		levelName = Files.readAllLines(Paths.get(path)).get(0);
		OneStarScore = new Score(Integer.parseInt(Files.readAllLines(Paths.get(path)).get(1)));
		TwoStarScore = new Score(Integer.parseInt(Files.readAllLines(Paths.get(path)).get(2)));
		ThreeStarScore = new Score(Integer.parseInt(Files.readAllLines(Paths.get(path)).get(3)));
		System.out.println(Integer.parseInt(Files.readAllLines(Paths.get(path)).get(3)));
		for (int i = 0; i <= 5; i++) {
			for (int j = 0; j <= 5; j++) {

				String readCheck = Files.readAllLines(Paths.get(path)).get(k);
				if (readCheck.equals("true")) {
					lightning.getBoard().activateSquare(i, j);
				} else {
					lightning.getBoard().deActivateSquare(i, j);

				}
				k++;
			}
		}
	}

	public void loadLightning() {
		LightningView frame = new LightningView(levelName, lightning);
		lightning.setOneStarScore(OneStarScore);
		lightning.setTwoStarScore(TwoStarScore);
		lightning.setThreeStarScore(ThreeStarScore);
		frame.setLevel(lightning);
		frame.initialize();
		frame.setVisible(true);
	}

}
