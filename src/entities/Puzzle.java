package entities;

import java.util.Iterator;

/**
 * The Entities class for puzzle levels.
 * <p>
 * 
 * Creation date: (12/5/2016)
 * 
 * @author Thomas Hagen, Rachel Hahn, Rayyan Khan, Hannah Olshansky, Lauren
 *         Pontbriant (Molybdenum)
 * 
 */

public class Puzzle extends Level {
	int numWords;

	public Puzzle(String name, Board b) {
		super(name, b);
	}

	public Puzzle(String name, Board b, Score score) {
		super(name, b);
		this.currScore = score;
	}

	/*
	 * Player Functions
	 */

	/**
	 * This function submits the current word and at the same time saves the
	 * state of the level to a list of previous states. After it is done, the
	 * current word will then be cleared.
	 */
	@Override
	public void submitWord() {
		Board b = new Board(getBoard());
		Score s = new Score(getCurrScore().getScore());
		Puzzle previous = new Puzzle(getLevelName(), b, s);
		getPreviousLevels().add(previous);

		subtractWordsLeft();
		currScore.addToScore(currentWord.getPoints() * (currentWord.getSquares().size() - 2));
		wordsFound.add(currentWord);
		// Be sure to remove content for all squares in the word.
		Iterator<Square> it = currentWord.getSquares().iterator();
		while (it.hasNext()) {
			it.next().removeContents();
		}
	}

	/**
	 * This function goes through the previous levels list and sets the values
	 * of the puzzle attributes to the ones of the last previous level. And
	 * throws an exception if the there are no more previous levels to undo to.
	 */
	@Override
	public void undoWord() {
		// TODO Auto-generated method stub
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

	public int getWordLimit() {
		return numWords;
	}

	public void setWordLimit(int val) {
		numWords = val;
	}

	public void subtractWordsLeft() {
		numWords--;

	}

	public int getNumWords() {
		return numWords;
	}

	public void addWordsLeft() {
		numWords++;
	}

}
