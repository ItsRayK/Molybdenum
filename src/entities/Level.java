package entities;

import java.util.ArrayList;

public abstract class Level {
	Board board;
	Score highScore;
	Score currScore;
	boolean levelLocked;
	Score oneStarScore;
	Score twoStarScore;
	Score threeStarScore;
	ArrayList<Word> wordsFound = new ArrayList<Word>();

	//player functions
	abstract boolean hasWon();
	abstract void submitWord();
	abstract void reset();
	abstract void undoWord();


	//builder functions
	abstract boolean saveLevel();
	abstract Board fillBoard();

}
