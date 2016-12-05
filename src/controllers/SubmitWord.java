package controllers;

import entities.*;
import player.PuzzleView;

public class SubmitWord {
	Word word;
	Puzzle level;
	PuzzleView view;

	public SubmitWord(PuzzleView pV, Puzzle p, Word currentWord) {
		view = pV;
		pV.setLevel(p);
		word = currentWord;
	}

	public void submit() {
		level.submitWord();
	}

}
