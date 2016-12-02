package entities;

import java.util.ArrayList;

public abstract class Level {
	String name;
	Board board;
	Score highScore;
	Score currScore;
	boolean levelLocked;
	Score oneStarScore;
	Score twoStarScore;
	Score threeStarScore;
	ArrayList<Word> wordsFound = new ArrayList<Word>();

	Level(String n, Board b) {
		name = n;
		board = b;
		currScore = new Score(0);
	}

	// player functions
	abstract boolean hasWon();

	abstract void submitWord();

	abstract void reset();

	abstract void undoWord();

	// builder functions
	abstract boolean saveLevel(
	/*
	 * This over-arching version of the method should assign the level name, the
	 * check box values creating the customized board, and the score values for
	 * each star level
	 */
	);

	abstract Board fillBoard();

	public Board getBoard() {
		return board;
	}
}
