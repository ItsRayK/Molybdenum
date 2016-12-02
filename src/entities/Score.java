package entities;

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

	public Score addToScore(int scoreAdded) {
		setScore(value + scoreAdded);
		return this;
	}

	public Score subtractFromScore(int scoreSubtracted) {
		setScore(value - scoreSubtracted);
		return this;
	}
}
