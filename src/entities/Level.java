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
	 * For all empty squares (i.e, active squares whose contents are empty) go
	 * through board and move up letters to fill these squares. This process may
	 * make other squares empty, so the process repeats until all letters have
	 * floated up to fill the empty squares in the board.
	 * 
	 * Note: when done, the only empty squares that remain are "from the bottom
	 * up" and will need to be filled with random letters in all levels except
	 * for Theme
	 */
	public void moveLettersUp() {
		board.floatUp();
	}

	/**
	 * Every empty and active square in the board is filled with a random letter
	 * according to the distribution of letters are stored by the Letter class.
	 */
	public void fillEmptyWithRandomLetters() {
		// TODO:
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

	public ArrayList<Square> getLettersSelected() {
		return lettersSelected;
	}
}
