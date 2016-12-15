package controllers;

import java.awt.event.ActionEvent;

import entities.*;
import player.*;

/**
 * The Controller class for selecting letters.
 * <p>
 * This allows the user to select letters to create a word.
 * 
 * Creation date: (12/5/2016)
 * 
 * @author Thomas Hagen, Rachel Hahn, Rayyan Khan, Hannah Olshansky, Lauren
 *         Pontbriant (Molybdenum)
 * 
 */

public class LetterClicked {
	Square square;
	Level level;

	public LetterClicked(Level p, Square s) {
		level = p;
		// puzzle.getLettersSelected().add(s);
		square = s;
	}

	/**
	 * Used the selected squares to make a word.
	 * @return boolean depending if the word was created
	 */
	public boolean constructWord() {
		if (!level.getCurrentWord().getSquares().contains(square)) {
			level.getCurrentWord().makeWord(square);
			return true;
		}
		return false;

	}

	/**
	 * Get rid of the word that was selected.
	 */
	public void deConstructWord() {
		level.getCurrentWord().unMakeWord();
	}

}
