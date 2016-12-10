package entities;

import java.util.Iterator;

public class Lightning extends Level {
	public Lightning(String n, Board b) {
		super(n, b);
		// TODO Auto-generated constructor stub
	}

	public Lightning(String name, Board b, Score score) {
		super(name, b);
		this.currScore = score;
	}

	int time;

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
		Board b = new Board(this.board);
		Lightning previous = new Lightning(this.name, b, this.getCurrScore());
		previousLevels.add(previous);
		currScore.addToScore(currentWord.getPoints() * (currentWord.getSquares().size() - 2));
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
	public void setTimer(int t) {
		time = t; // in milliseconds
	}

	public int getTimer() {
		return time;
	}

	@Override
	boolean saveLevel() {
		// The fields that need to be known to save a lightning level are the
		// board configuration, total time allotted, and if the level is locked
		return false;
	}

}
