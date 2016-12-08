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
	ArrayList<Square> lettersSelected = new ArrayList<Square>();
	Word currentWord = new Word(lettersSelected);

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

	/*
	 * This over-arching version of the method should assign the level name, the
	 * check box values creating the customized board, and the score values for
	 * each star level
	 */
	abstract boolean saveLevel();

	/**
	 * Every empty and active square in the board is filled with a random letter
	 * according to the distribution of letters as stored in the Letter class.
	 */
	public void fillEmptyWithRandomLetters() {
		board.fillEmptyActiveSquares();
	}

	public boolean addToLevelScore(int i) {
		currScore.addToScore(i);
		return true;
	}

	public boolean subtractFromLevelScore(int i) {
		currScore.subtractFromScore(i);
		return true;
	}

	public Board getBoard() {
		return board;
	}

	public Word getCurrentWord() {
		return currentWord;
	}

	public Score getCurrScore() {
		return currScore;
	}

	public void setCurrScore(Score s) {
		this.currScore = s;
	}

	public ArrayList<Square> getLettersSelected() {
		return lettersSelected;
	}

	public Score getOneStarScore() {
		return oneStarScore;
	}

	public Score getTwoStarScore() {
		return twoStarScore;
	}

	public Score getThreeStarScore() {
		return threeStarScore;
	}

	public void compareToGoalScores() {
		if (currScore.getScore() > oneStarScore.getScore())
			currScore.star1Filled = true;
		else
			currScore.star1Filled = false;

		if (currScore.getScore() > twoStarScore.getScore())
			currScore.star2Filled = true;
		else
			currScore.star1Filled = false;

		if (currScore.getScore() > threeStarScore.getScore())
			currScore.star3Filled = true;
		else
			currScore.star3Filled = false;
	}

	public void setOneStarScore(Score oneStarScore) {
		this.oneStarScore = oneStarScore;
	}

	public void setTwoStarScore(Score twoStarScore) {
		this.twoStarScore = twoStarScore;
	}

	public void setThreeStarScore(Score threeStarScore) {
		this.threeStarScore = threeStarScore;
	}

}
