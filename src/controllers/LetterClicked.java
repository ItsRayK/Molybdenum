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

	public boolean constructWord() {
		if (!level.getCurrentWord().getSquares().contains(square)) {
			level.getCurrentWord().makeWord(square);
			return true;
		}
		return false;

	}

	public void deConstructWord() {
		level.getCurrentWord().unMakeWord();
	}

}
