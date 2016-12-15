package entities;

import java.util.ArrayList;

/**
 * The Entities class for the level.
 * <p>
 * 
 * Creation date: (12/5/2016)
 * 
 * @author Thomas Hagen, Rachel Hahn, Rayyan Khan, Hannah Olshansky, Lauren
 *         Pontbriant (Molybdenum)
 * 
 */

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
	ArrayList<Level> previousLevels = new ArrayList<Level>();

	Level(String n, Board b) {
		name = n;
		board = b;
		currScore = new Score(0);
	}

	// player functions
	abstract void submitWord();

	abstract void undoWord();

	// builder functions

	/**
	 * Every empty and active square in the board is filled with a random letter
	 * according to the distribution of letters as stored in the Letter class.
	 */
	public void fillEmptyWithRandomLetters() {
		board.fillEmptyActiveSquares();
	}

	/**
	 * This function clears the board of all the squares that currently occupy
	 * the board
	 */
	public void clearBoardLetters() {
		board.clearAllActiveSquares();

	}

	/**
	 * This function adds to the current score of the level with the i parameter
	 * 
	 * @param i The amount of points to add to the current score
	 * @return boolean dependent on if the points were added
	 */
	public boolean addToLevelScore(int i) {
		currScore.addToScore(i);
		return true;
	}

	/**
	 * Subtracts from the current score of the level with the i parameter.
	 * @param i The amount of points to subtract from the current score
	 * @return boolean dependent on if the points were subtracted
	 */
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

	public String getLevelName() {
		return name;
	}

	/**
	 * This function serves to determine if the stars need to be filled in or
	 * not. It compares the current score's value to the score thresholds for
	 * the stars and sets the booleans of the star filled to either true or
	 * false.
	 */
	public void compareToGoalScores() {
		if (currScore.getScore() >= oneStarScore.getScore())
			currScore.star1Filled = true;
		else
			currScore.star1Filled = false;

		if (currScore.getScore() >= twoStarScore.getScore())
			currScore.star2Filled = true;
		else
			currScore.star2Filled = false;

		if (currScore.getScore() >= threeStarScore.getScore())
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

	public ArrayList<Level> getPreviousLevels() {
		return previousLevels;
	}

	public ArrayList<Word> getWordsFound() {
		return wordsFound;
	}

	public void setCurrentWord(Word currentWord) {
		this.currentWord = currentWord;
	}
}
