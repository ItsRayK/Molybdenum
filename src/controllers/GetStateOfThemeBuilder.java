package controllers;

import java.awt.Font;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JToggleButton;
import javax.swing.text.BadLocationException;
import javax.swing.text.Utilities;

import builder.PreviewLightning;
import builder.PreviewPuzzle;
import builder.PreviewTheme;
import builder.PuzzleBuilder;
import builder.ThemeBuilder;
import entities.Letter;
import entities.Puzzle;
import entities.Score;
import entities.Theme;
import player.ThemeView;

/**
 * The Controller class for getting the state of the Theme Builder.
 * <p>
 * This allows the user to preview, save, and delete a Theme Level 
 * in the Builder.
 * 
 * Creation date: (12/5/2016)
 * 
 * @author Thomas Hagen, Rachel Hahn, Rayyan Khan, Hannah Olshansky, Lauren
 *         Pontbriant (Molybdenum)
 * 
 */

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
		Letter l = new Letter();
		for (int i = 0; i <= 5; i++) {
			for (int j = 0; j <= 5; j++) {
				if (themeBuilder.getCheckBox()[i][j].isSelected()) {
					theme.getBoard().activateSquare(i, j);
					if (!themeBuilder.getLetterField()[i][j].equals("")) {
						theme.getBoard().squares[i][j]
								.setContents(l.setLetter(themeBuilder.getLetterField()[i][j].getText(), 0));
					} else {
						theme.getBoard().squares[i][j].setContents(l.randomLetterNoPoints());
					}
				} else {
					theme.getBoard().deActivateSquare(i, j);
				}
			}

		}
		levelName = themeBuilder.getNameText();

	}

	/**
	 * Allows user to preview a created level.
	 */
	public void makePreview() {
		PreviewTheme themeView = new PreviewTheme(levelName, theme, themeBuilder);

		theme.setThemeName(themeBuilder.getThemeNameText());
		theme.setWordLimit(Integer.parseInt(themeBuilder.getTxt3StarThresh().getText()));
		themeView.setLevel(theme);
		themeView.initialize();
		themeView.setVisible(true);
	}

	/**
	 * Allows user to save a level they have created.
	 */
	public void saveLevel() {

		OneStarScore = new Score(Integer.parseInt(themeBuilder.getTxt1StarThresh().getText()));
		TwoStarScore = new Score(Integer.parseInt(themeBuilder.getTxt2StarThresh().getText()));
		ThreeStarScore = new Score(Integer.parseInt(themeBuilder.getTxt3StarThresh().getText()));

		file = new File("savedLevels/" + levelName + ".txt");

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

			bw.write(themeBuilder.getThemeNameText());
			bw.newLine();
			bw.flush();
			bw.write("Theme");
			bw.newLine();
			bw.flush();

			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 6; j++) {
					if (!themeBuilder.getLetterField()[i][j].getText().equals("")) {
						bw.write(themeBuilder.getLetterField()[i][j].getText().toUpperCase());
						bw.newLine();
						bw.flush();
					} else {
						bw.write("null");
						bw.newLine();
						bw.flush();
					}
				}
			}

			bw.write(themeBuilder.getWordsToFind());
			bw.newLine();
			bw.flush();
			bw.write("endofdocument");
			bw.newLine();
			bw.flush();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace(); // I'd rather declare method with throws
									// IOException and omit this catch.
		}

		System.out.printf("File is located at %s%n", file.getAbsolutePath());

	}

	/**
	 * Allows user to delete a puzzle they have created.
	 */
	public void deletePuzzle() {
		levelName = themeBuilder.getNameText();
		String path = "savedLevels/" + levelName + ".txt";
		file = new File(path);
		if (file.delete()) {
			System.out.println("'" + levelName + "'" + " has been deleted");
		} else
			System.out.println("'" + levelName + "'" + " already does not exist");
		;

	}

}
