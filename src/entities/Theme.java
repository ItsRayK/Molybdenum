package entities;

import java.util.ArrayList;
import java.util.Iterator;

public class Theme extends Level {
	int numWords;

	public Theme(String n, Board b) {
		super(n, b);
		// TODO Auto-generated constructor stub
	}

	String themeName;
	ArrayList<Word> keyWords = new ArrayList<Word>();

	/*
	 * Player Functions
	 */
	@Override
	boolean hasWon() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * This function submits the current word and at the same time saves the
	 * state of the level to a list of previous states. After it is done, the
	 * current word will then be cleared.
	 */

	@Override
	public void submitWord() {
		Board b = new Board(getBoard());
		Score s = new Score(getCurrScore().getScore());
		Theme previous = new Theme(getLevelName(), b);
		getPreviousLevels().add(previous);

		subtractWordsLeft();
		currScore.addToScoreTheme();
		wordsFound.add(currentWord);
		// Be sure to remove content for all squares in the word.
		Iterator<Square> it = currentWord.getSquares().iterator();
		while (it.hasNext()) {
			it.next().removeContents();
		}

	}

	@Override
	void reset() {
		// TODO Auto-generated method stub

	}

	/**
	 * This function goes through the previous levels list and sets the values
	 * of the puzzle attributes to the ones of the last previous level. And
	 * throws an exception if the there are no more previous levels to undo to.
	 */
	@Override
	public void undoWord() {
		try {
			if (previousLevels.size() != 0) {
				for (int i = 0; i < 6; i++) {
					for (int j = 0; j < 6; j++) {
						board.squares[i][j].setContents(
								previousLevels.get(previousLevels.size() - 1).getBoard().getSquare(i, j).getContents());
					}
				}

				getCurrentWord().getSquares().clear();
				getCurrentWord().setWordString();
				setCurrScore(previousLevels.get(previousLevels.size() - 1).currScore);

				previousLevels.remove(previousLevels.size() - 1);
				addWordsLeft();
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.print("There are no previous moves made!");
		}
	}

	/*
	 * Builder functions
	 */
	@Override
	boolean saveLevel() {
		// save name of theme and words to be found
		// needs to be saved to a disk (look at online form discussion for more
		// about where)
		return false;
	}

	public void setThemeName(String name) {
		themeName = name;
	}

	public String getThemeName() {
		return themeName;
	}

	public int getWordLimit() {
		return numWords;
	}

	public void setWordLimit(int val) {
		numWords = val;
	}

	public void subtractWordsLeft() {
		numWords--;
	}

	public void addWordsLeft() {
		numWords++;
	}

	public ArrayList<Word> getKeyWords() {
		return keyWords;
	}

}
