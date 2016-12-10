package controllers;

import java.awt.event.ActionEvent;

import entities.*;
import player.*;

public class LetterClicked {
	Square square;
	Level level;

	public LetterClicked(Level p, Square s) {
		level = p;
		// puzzle.getLettersSelected().add(s);
		square = s;
	}

	public void constructWord() {
		level.getCurrentWord().makeWord(square);
	}
	
	public void deConstructWord() {
		level.getCurrentWord().unMakeWord();
	}
	
	
}
