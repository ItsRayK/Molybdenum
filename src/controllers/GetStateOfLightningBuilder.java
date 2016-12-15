package controllers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.Timer;

import builder.LightningBuilder;
import builder.PreviewLightning;
import entities.Lightning;
import entities.Score;

/**
 * The Controller class for getting the state of the Lightning Builder.
 * <p>
 * This allows the user to preview, save, and delete a Lightning Level 
 * in the Builder.
 * 
 * Creation date: (12/5/2016)
 * 
 * @author Thomas Hagen, Rachel Hahn, Rayyan Khan, Hannah Olshansky, Lauren
 *         Pontbriant (Molybdenum)
 * 
 */

public class GetStateOfLightningBuilder {
	Lightning lightning;
	LightningBuilder lightningBuilder;
	String levelName;
	Score OneStarScore;
	Score TwoStarScore;
	Score ThreeStarScore;
	BufferedWriter bw = null;
	File file;
	int timerInt;

	public GetStateOfLightningBuilder(LightningBuilder lb, Lightning l) {
		lightningBuilder = lb;
		lightning = l;

		for (int i = 0; i <= 5; i++) {
			for (int j = 0; j <= 5; j++) {
				if (lightningBuilder.getCheckBox()[i][j].isSelected())
					lightning.getBoard().activateSquare(i, j);
				else
					lightning.getBoard().deActivateSquare(i, j);

			}

		}

		levelName = lightningBuilder.getNameText();

		timerInt = Integer.parseInt(lightningBuilder.getTimerText());

	}

	/**
	 * Allows user to preview a created level.
	 */
	public void makePreview() {
		PreviewLightning lightningView = new PreviewLightning(levelName, lightning, OneStarScore, TwoStarScore,
				ThreeStarScore, timerInt);
		lightningView.setVisible(true);
	}

	/**
	 * Allows user to save a level they have created.
	 */
	public void saveLevel() {
		OneStarScore = new Score(Integer.parseInt(lightningBuilder.getTxt1StarThresh().getText()));
		TwoStarScore = new Score(Integer.parseInt(lightningBuilder.getTxt2StarThresh().getText()));
		ThreeStarScore = new Score(Integer.parseInt(lightningBuilder.getTxt3StarThresh().getText()));

		file = new File("savedLevels/" + levelName + ".txt");

		try {
			bw = new BufferedWriter(new FileWriter(file, false));
			bw.write(levelName);
			bw.newLine();
			bw.flush();
			bw.write(lightningBuilder.getTxt1StarThresh().getText());
			bw.newLine();
			bw.flush();
			bw.write(lightningBuilder.getTxt2StarThresh().getText());
			bw.newLine();
			bw.flush();
			bw.write(lightningBuilder.getTxt3StarThresh().getText());
			bw.newLine();
			bw.flush();

			for (int i = 0; i <= 5; i++) {
				for (int j = 0; j <= 5; j++) {
					if (lightningBuilder.getCheckBox()[i][j].isSelected()) {
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

			bw.write(lightningBuilder.getTimerText());
			bw.newLine();
			bw.flush();
			bw.write("Lightning");
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
		String path = "savedLevels/" + levelName + ".txt";
		file = new File(path);
		if (file.delete()) {
			System.out.println("'" + levelName + "'" + " has been deleted");
		} else
			System.out.println("'" + levelName + "'" + " already does not exist");
		;

	}
}
