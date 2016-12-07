package entities;

public class Lightning extends Level {
	public Lightning(String n, Board b) {
		super(n, b);
		// TODO Auto-generated constructor stub
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
	void setTimer(int t) {
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
