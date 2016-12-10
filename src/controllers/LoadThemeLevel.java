package controllers;

import java.io.IOException;
import java.nio.file.*;

import entities.Puzzle;
import entities.Score;
import entities.Theme;
import player.PuzzleView;
import player.ThemeView;

public class LoadThemeLevel {
	int k = 4;
	Theme theme;
	String fileName;
	String levelName;
	Score OneStarScore;
	Score TwoStarScore;
	Score ThreeStarScore;
	String themeName;

	public LoadThemeLevel(String fileName, Theme p) throws IOException {
		this.fileName = fileName;
		theme = p;
		String path = "savedLevels/" + fileName + ".txt";
		levelName = Files.readAllLines(Paths.get(path)).get(0);
		OneStarScore = new Score(Integer.parseInt(Files.readAllLines(Paths.get(path)).get(1)));
		TwoStarScore = new Score(Integer.parseInt(Files.readAllLines(Paths.get(path)).get(2)));
		ThreeStarScore = new Score(Integer.parseInt(Files.readAllLines(Paths.get(path)).get(3)));
		themeName = Files.readAllLines(Paths.get(path)).get(40);
		System.out.println(Integer.parseInt(Files.readAllLines(Paths.get(path)).get(3)));
		for (int i = 0; i <= 5; i++) {
			for (int j = 0; j <= 5; j++) {

				String readCheck = Files.readAllLines(Paths.get(path)).get(k);
				if (readCheck.equals("true")) {
					theme.getBoard().activateSquare(i, j);
				} else {
					theme.getBoard().deActivateSquare(i, j);

				}
				k++;
			}
		}
	}

	public void loadTheme() {
		ThemeView frame = new ThemeView(levelName, theme);
		theme.setOneStarScore(OneStarScore);
		theme.setTwoStarScore(TwoStarScore);
		theme.setThreeStarScore(ThreeStarScore);
		theme.setThemeName(themeName);
		frame.setLevel(theme);
		frame.initialize();
		frame.setVisible(true);
	}

}
