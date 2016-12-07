package entities;

/**
 * Open question: Are board squares indexed externally by zero or one?
 * 
 * @author Orion
 *
 */

public class Board {
	public Square[][] squares = new Square[6][6];

	public Board() {
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				squares[i][j] = new Square(i, j, true);
			}
		}
	}

	/**
	 * Returns the square (or null if not active) for coordinates [i][j].
	 * 
	 * @param i
	 *            Row of the board
	 * @param j
	 *            Column of the board
	 * @return returns active square object or null if not active.
	 */
	public Square getSquare(int i, int j) {
		return squares[i][j];
	}

	public Square[][] activeSquares() {
		Square[][] activeOnes = new Square[6][6];
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				if (squares[i][j].isActive()) {
					activeOnes[i][j] = squares[i][j];
				}
			}
		}
		return activeOnes;
	}

	public void deActivateSquare(int col, int row) {
		squares[col][row].setActivity(false);
	}

	public void activateSquare(int col, int row) {
		squares[col][row].setActivity(true);
	}

	public void floatUp() {
		for (int i = 0; i <= 5; i++) {
			for (int j = 0; j <= 5; j++) {
				if (squares[i][j].isEmptyAndActive()) {
					Letter contentsUp = nextBelowActiveSquare(squares[i][j]).getContents();
					nextBelowActiveSquare(squares[i][j]).removeContents();
					squares[i][j].setContents(contentsUp);
				}
			}
		}
	}

	public boolean isNextAboveSquareEmpty(Square s) {
		boolean tf = false;
		int k = 0;
		while (s.row - k >= 1) {
			if (squares[s.column][k].isEmptyAndActive())
				tf = true;
			k++;
		}
		if (s.row == 0)
			tf = false;
		return tf;

	}

	public Square nextAboveEmptySquare(Square s) {
		Square square = null;
		int k = 0;
		while (s.row - k >= 1) {
			if (squares[s.column][k].isEmptyAndActive())
				square = squares[s.column][k];
			k++;
		}
		return square;
	}

	public Square nextBelowActiveSquare(Square s) {
		Square square = null;
		int k = 0;
		while (s.row + k <= 5) {
			if (squares[s.column][k].notEmptyActive())
				square = squares[s.column][k];
			k++;
		}
		return square;
	}

	public void fillEmptyActiveSquares() {
		for (int i = 0; i <= 5; i++) {
			for (int j = 0; j <= 5; j++) {
				if (squares[i][j].isEmptyAndActive()) {
					squares[i][j].fillSquareWithRandom();
				}
			}
		}
	}
}