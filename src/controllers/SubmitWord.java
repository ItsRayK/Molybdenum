package controllers;

import entities.*;
import player.PuzzleView;

public class SubmitWord {
	Word word;
	Puzzle level;
	PuzzleView view;

	public SubmitWord(PuzzleView pV, Puzzle p, Word currentWord) {
		view = pV;
		level = p;
		word = currentWord;
	}

	public void submit() {
		String wordFound = word.getWordString();
		level.submitWord();
		view.addToWordsFound(wordFound);
		view.setLevel(level);
		level.getLettersSelected().clear();

	}

}
