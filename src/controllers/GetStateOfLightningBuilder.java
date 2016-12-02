package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import builder.LightningBuilder;
import builder.PuzzleBuilder;
import entities.Lightning;
import entities.Puzzle;
import entities.Score;
import player.LevelSelect;
import player.LightningView;
import player.PuzzleView;

public class GetStateOfLightningBuilder {
	Lightning lightning;
	LightningBuilder lightningBuilder;
	String levelName;
	Timer timer;
	Score OneStarScore;
	Score TwoStarScore;
	Score ThreeStarScore;
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
		

		OneStarScore = new Score(Integer.parseInt(lightningBuilder.getTxt1StarThresh().getText()));
		TwoStarScore = new Score(Integer.parseInt(lightningBuilder.getTxt2StarThresh().getText()));
		ThreeStarScore = new Score(Integer.parseInt(lightningBuilder.getTxt3StarThresh().getText()));
	}

	public void makePreview() {
		LightningView lightningView = new LightningView(levelName, lightning, OneStarScore, TwoStarScore,
				ThreeStarScore, timerInt);
		lightningView.setVisible(true);
	}

	public void saveLevel() {

	}
}
