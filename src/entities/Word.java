package entities;

import java.util.ArrayList;
import java.util.StringJoiner;

/**
 * The Entities class for the word.
 * <p>
 * 
 * Creation date: (12/5/2016)
 * 
 * @author Thomas Hagen, Rachel Hahn, Rayyan Khan, Hannah Olshansky, Lauren
 *         Pontbriant (Molybdenum)
 * 
 */

public class Word {
	private ArrayList<Square> squares = new ArrayList<Square>();
	private int points;
	private String wordString;

	public Word(ArrayList<Square> sqs) {
		squares = sqs;
		setWordString();
		if (sqs.iterator().hasNext())
			setPoints(sqs.iterator().next().getContentsPoints());
		else
			setPoints(0);
	}

	/**
	 * Returns the last square in a list of squares.
	 * 
	 * @return
	 */
	public Square getLastSquare() {
		return squares.get(squares.size() - 1);
	}

	public ArrayList<Square> getSquares() {
		return squares;
	}

	/**
	 * Adds a square to the current word.
	 */
	public Word makeWord(Square square) {
		squares.add(squares.size(), square);
		setWordString();
		setPoints(this.getLastSquare().getContentsPoints());
		return this;
	}

	/**
	 * Returns the word without the last square added.
	 */
	public Word unMakeWord() {
		removePoints(this.getLastSquare().getContentsPoints());
		wordString = squares.remove(squares.size() - 1).getContentsString();
		setWordString();
		return this;
	}

	/**
	 * Sets the string of the word to the contents of the word squares.
	 */
	public void setWordString() {
		StringJoiner joiner = new StringJoiner("");
		if (squares.size() == 0)
			wordString = "";
		else if (squares.size() == 1)
			wordString = squares.get(0).getContentsString();
		else {
			for (int i = 0; i <= squares.size() - 1; i++) {
				joiner.add(squares.get(i).getContentsString());
			}
			wordString = joiner.toString();

		}

	}

	public String getWordString() {
		return wordString;
	}

	public int getPoints() {
		return points;
	}

	public boolean setPoints(int i) {
		points += i;
		return true;
	}

	public boolean removePoints(int i) {
		points -= i;
		return true;
	}
}
