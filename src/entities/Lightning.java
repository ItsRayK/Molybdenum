package entities;

import java.util.Iterator;

/**
 * The Entities class for lightning levels.
 * <p>
 * 
 * Creation date: (12/5/2016)
 * 
 * @author Thomas Hagen, Rachel Hahn, Rayyan Khan, Hannah Olshansky, Lauren
 *         Pontbriant (Molybdenum)
 * 
 */

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

	/**
	 * This function submits the current word and at the same time saves the
	 * state of the level to a list of previous states. After it is done, the
	 * current word will then be cleared.
	 */
	@Override
	public void submitWord() {
		Board b = new Board(this.board);
		Lightning previous = new Lightning(this.name, b, this.getCurrScore());
		previousLevels.add(previous);
		currScore.addToScore(currentWord.getPoints() * (currentWord.getSquares().size() - 2));
		wordsFound.add(currentWord);
		compareToGoalScores();
		// Be sure to remove content for all squares in the word.
		Iterator<Square> it = currentWord.getSquares().iterator();
		while (it.hasNext()) {
			it.next().removeContents();
		}

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

}
