package controllers;

import entities.*;
import player.*;

public class LetterClicked {
	Square square;
	Puzzle puzzle;

	public LetterClicked(Puzzle p, Square s) {
		puzzle = p;
		puzzle.getLettersSelected().add(s);
		square = s;
	}

	public void constructWord() {
		puzzle.getCurrentWord().makeWord(puzzle.getLettersSelected().get(puzzle.getLettersSelected().size() - 1));
	}
}
