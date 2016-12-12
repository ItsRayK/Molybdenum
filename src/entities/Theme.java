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

	@Override
	public void undoWord() {
		try {
			if (previousLevels.size() != 0) {
				for (int i = 0; i < 6; i++) {
					for (int j = 0; j < 6; j++) {
						if (!board.squares[i][j].isEmpty()) {
							board.squares[i][j].setContents(previousLevels.get(previousLevels.size() - 1).getBoard()
									.getSquare(i, j).getContents());
						}
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

}
