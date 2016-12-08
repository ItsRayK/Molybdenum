package entities;

import java.util.Iterator;

public class Puzzle extends Level {
	int numWords;

	public Puzzle(String name, Board b) {
		super(name, b);
	}
	
	public Puzzle(String name, Board b, Score score){
		super(name, b);
		this.currScore = score;
	}

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
		Board b = new Board(this.board);
		Puzzle previous = new Puzzle(this.name, b, this.getCurrScore());
		previousLevels.add(previous);
		currScore.addToScore(currentWord.getPoints() * (currentWord.getSquares().size() - 2));
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
	void undoWord() {
		// TODO Auto-generated method stub

	}

	/*
	 * Builder functions
	 */
	@Override
	boolean saveLevel() {
		// TODO Auto-generated method stub
		return false;
	}

}
