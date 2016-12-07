package entities;

import java.util.Iterator;

public class Puzzle extends Level {
	int numWords;

	public Puzzle(String name, Board b) {
		super(name, b);
	}

	/*
	 * Player Functions
	 */
	@Override
	boolean hasWon() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void submitWord() {
		currScore.addToScore(currentWord.getPoints());
		wordsFound.add(currentWord);

		// Be sure to remove content for all squares in the word.
		Iterator<Square> it = currentWord.getSquares().iterator();
		while (it.hasNext()) {
			it.next().removeContents();
		}

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
		// TODO Auto-generated method stub
		return false;
	}

}
