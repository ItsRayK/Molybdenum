package entities;

import java.util.ArrayList;
import java.util.StringJoiner;

public class Word {
	private ArrayList<Square> squares = new ArrayList<Square>();
	private int points;
	private String wordString;

	public Word(ArrayList<Square> sqs) {
		squares = sqs;
		setWordString();
		setPoints();

	}

	public Word makeWord(Square square) {
		squares.add(squares.size() - 1, square);
		setWordString();
		setPoints();
		return this;
	}

	public void setWordString() {
		StringJoiner joiner = new StringJoiner("");
		if (squares.size() == 1) {
			wordString = squares.get(0).getContentsString();
		} else {
			for (int i = squares.size() - 1; i >= 0; i--) {
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

	public void setPoints() {
		for (Square s : squares) {
			points += s.getContentsPoints();
		}
	}
}
