package entities;

import java.util.ArrayList;

public class Theme extends Level {
	String themeName;
	ArrayList<Word> keyWords = new ArrayList<Word>();

	/*
	 * Player Functions
	 */
	@Override
	boolean hasWon() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	void submitWord() {
		// TODO Auto-generated method stub

	}

	@Override
	void reset() {
		// TODO Auto-generated method stub

	}

	@Override
	void undoWord() {
		// TODO Auto-generated method stub

	}

	/*
	 * Builder functions
	 */
	@Override
	boolean saveLevel() {
		// save name of theme and words to be found
		// needs to be saved to a disk (look at online form discussion for more about where)
		return false;
	}

	@Override
	Board fillBoard() {
		// TODO Auto-generated method stub
		return null;
	}
}
