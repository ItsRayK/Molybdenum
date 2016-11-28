package entities;

import java.util.ArrayList;

public class Word {
	ArrayList<Square> squares = new ArrayList<Square>();
	int points;
	String wordString;

	public Word(ArrayList<Square> sqs){
		squares = sqs;
	}

	public Word makeWord(Square square){
		squares.add(square);
		return this;
	}
}
