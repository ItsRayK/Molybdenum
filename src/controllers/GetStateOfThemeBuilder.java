package controllers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import builder.PreviewPuzzle;
import builder.PreviewTheme;
import builder.PuzzleBuilder;
import builder.ThemeBuilder;
import entities.Puzzle;
import entities.Score;
import entities.Theme;

public class GetStateOfThemeBuilder {
	Theme theme;
	ThemeBuilder themeBuilder;
	String levelName;
	Score OneStarScore;
	Score TwoStarScore;
	Score ThreeStarScore;
	BufferedWriter bw = null;
	File file;

	public GetStateOfThemeBuilder(ThemeBuilder pb, Theme p) {
		themeBuilder = pb;
		theme = p;

		for (int i = 0; i <= 5; i++) {
			for (int j = 0; j <= 5; j++) {
				if (themeBuilder.getCheckBox()[i][j].isSelected())
					theme.getBoard().activateSquare(i, j);
				else
					theme.getBoard().deActivateSquare(i, j);

			}

		}

		levelName = themeBuilder.getNameText();
		
	}

	public void makePreview() {
		OneStarScore = new Score(Integer.parseInt(themeBuilder.getTxt1StarThresh().getText()));
		TwoStarScore = new Score(Integer.parseInt(themeBuilder.getTxt2StarThresh().getText()));
		ThreeStarScore = new Score(Integer.parseInt(themeBuilder.getTxt3StarThresh().getText()));
		
		PreviewTheme themeView = new PreviewTheme(levelName, theme, OneStarScore, TwoStarScore, ThreeStarScore);
		themeView.setLevel(theme);
		themeView.initialize();
		themeView.setVisible(true);
	}

	public void saveLevel() {
		OneStarScore = new Score(Integer.parseInt(themeBuilder.getTxt1StarThresh().getText()));
		TwoStarScore = new Score(Integer.parseInt(themeBuilder.getTxt2StarThresh().getText()));
		ThreeStarScore = new Score(Integer.parseInt(themeBuilder.getTxt3StarThresh().getText()));
		
		file = new File("savedLevels/" + levelName + ".txt");

		FileWriter writer = null;
		try {
			bw = new BufferedWriter(new FileWriter(file, false));
			bw.write(levelName);
			bw.newLine();
			bw.flush();
			bw.write(themeBuilder.getTxt1StarThresh().getText());
			bw.newLine();
			bw.flush();
			bw.write(themeBuilder.getTxt2StarThresh().getText());
			bw.newLine();
			bw.flush();
			bw.write(themeBuilder.getTxt3StarThresh().getText());
			bw.newLine();
			bw.flush();

			for (int i = 0; i <= 5; i++) {
				for (int j = 0; j <= 5; j++) {
					if (themeBuilder.getCheckBox()[i][j].isSelected()) {
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

			bw.write(themeBuilder.getWordsToFind());
			bw.newLine();
			bw.flush();
			bw.write("Theme");
			bw.newLine();
			bw.flush();
			
			for (int i = 0; i <= 5; i++) {
				for (int j = 0; j <= 5; j++) {
					if (!themeBuilder.getLetterField()[i][j].getText().equals("")) {
						bw.write(themeBuilder.getLetterField()[i][j].getText());
						bw.newLine();
						bw.flush();
					} else {
						bw.write("null");
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

	public void deletePuzzle() {
		String path = "savedLevels/" + levelName + ".txt";
		file = new File(path);
		if(file.delete()){
			System.out.println("'" + levelName + "'" + " has been deleted");
		}
		else
			System.out.println("'" + levelName + "'" + " already does not exist");;
		
	}

}
