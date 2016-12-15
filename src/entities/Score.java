package entities;

/**
 * The Entities class for the score.
 * <p>
 * 
 * Creation date: (12/5/2016)
 * 
 * @author Thomas Hagen, Rachel Hahn, Rayyan Khan, Hannah Olshansky, Lauren
 *         Pontbriant (Molybdenum)
 * 
 */

public class Score {
	int value;
	boolean star1Filled;

	boolean star2Filled;

	boolean star3Filled;

	public Score(int val) {
		value = val;
	}

	public Score setScore(int i) {
		value = i;
		return this;
	}

	public int getScore() {
		return value;
	}

	/**
	 * Adds the value of the current score with the parameter scoreAdded.
	 * 
	 * @param scoreAdded
	 * @return
	 */

	public Score addToScore(int scoreAdded) {
		setScore(value + scoreAdded);
		return this;
	}

	/**
	 * Subtracts the value of the current score with the parameter
	 * scoreSubtracted.
	 * 
	 * @param scoreSubtracted
	 * @return
	 */
	public Score subtractFromScore(int scoreSubtracted) {
		setScore(value - scoreSubtracted);
		return this;
	}

	/**
	 * Adds a score with theme levels because the score is not determined by the
	 * values of the word.
	 * 
	 * @return
	 */
	public Score addToScoreTheme() {
		setScore(value + 1);
		return this;
	}

	/**
	 * Subtracts a score with theme levels because the score is not determined
	 * by the values of the word.
	 * 
	 * @return
	 */

	public Score subtractFromScoreTheme() {
		setScore(value - 1);
		return this;
	}

	public boolean isStar1Filled() {
		return star1Filled;
	}

	public boolean isStar2Filled() {
		return star2Filled;
	}

	public boolean isStar3Filled() {
		return star3Filled;
	}
}
