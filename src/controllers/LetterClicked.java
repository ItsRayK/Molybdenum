package controllers;

import java.awt.event.ActionEvent;

import entities.*;
import player.*;

public class LetterClicked {
	Square square;
	Puzzle puzzle;

	public LetterClicked(Puzzle p, Square s) {
		puzzle = p;
		// puzzle.getLettersSelected().add(s);
		square = s;
	}

	public void constructWord() {
		puzzle.getCurrentWord().makeWord(square);
	}
	
	public void deConstructWord() {
		puzzle.getCurrentWord().unMakeWord();
	}
	
	
}
