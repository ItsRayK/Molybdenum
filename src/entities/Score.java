package entities;

public class Score {
	int value;
	boolean star1Filled;

	boolean star2Filled;

	boolean star3Filled;

	public Score setScore(int i) {
		value = i;
		return this;
	}

	public Score addToScore(int scoreAdded) {
		setScore(value + scoreAdded);
		return this;
	}
}
