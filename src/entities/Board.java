package entities;

/**
 * The Entities class for the board.
 * <p>
 * 
 * Creation date: (12/5/2016)
 * 
 * @author Thomas Hagen, Rachel Hahn, Rayyan Khan, Hannah Olshansky, Lauren
 *         Pontbriant (Molybdenum)
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

	public Board(Board b) {
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				squares[i][j] = new Square(i, j, b.getSquare(i, j).isActive());
				Letter temp = b.getSquare(i, j).getContents();
				Letter newOne = new Letter();
				if (squares[i][j].isActive()) {
					squares[i][j].fillSquare(newOne.setLetter(b.getSquare(i, j).getContents().getLetterString(),
							b.getSquare(i, j).getContents().getLetterVal()));
				}

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
	public void floatUp() {
		boolean filled;
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				filled = false;
				if (squares[i][j].isEmptyAndActive()) {
					for (int k = j + 1; k < 6; k++) {
						if (squares[i][k].isActive() && ((!(squares[i][k].getEmpty())) && !filled)) {
							squares[i][j].setContents(squares[i][k].getContents());
							squares[i][k].removeContents();
							filled = true;
						}
					}
					// }

					if (!filled) {
						squares[i][j].fillSquareWithRandom();
						filled = true;
					}
				}
			}
		}
	}

	/**
	 * For all empty squares (i.e, active squares whose contents are empty) go
	 * through board and move up letters to fill these squares. This process may
	 * make other squares empty, so the process repeats until all letters have
	 * floated up to fill the empty squares in the board.
	 * 
	 * Note: when done, the only empty squares that remain are left empty
	 */

	public void floatUpTheme() {
		boolean filled;
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				filled = false;
				if (squares[i][j].isEmptyAndActive()) {
					for (int k = j + 1; k < 6; k++) {
						if (squares[i][k].isActive() && ((!(squares[i][k].getEmpty())) && !filled)) {
							squares[i][j].setContents(squares[i][k].getContents());
							squares[i][k].removeContents();
							filled = true;
						}
					}
					// }

					if (!filled) {
						filled = false;
					}
				}
			}
		}
	}

	/**
	 * Determines if the square above is empty.
	 * @param s Square to check the square above it
	 * @return boolean dependent on if the square above the given square is empty
	 */
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

	/**
	 * Finds next above square that is empty
	 * @param s Square to check the square above it
	 * @return Square that is the next empty square above the given square
	 */
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

	/**
	 * Finds next below square that is not empty and active
	 * @param s Square to check the square below it
	 * @return Square that is the next not empty and active square below the given square
	 */
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

	/**
	 * Fills all empty and active squares with a random letter.
	 */
	public void fillEmptyActiveSquares() {
		for (int i = 0; i <= 5; i++) {
			for (int j = 0; j <= 5; j++) {
				if (squares[i][j].isEmptyAndActive()) {
					squares[i][j].fillSquareWithRandom();
				}
			}
		}
	}

	/**
	 * Removes the contents of all active squares.
	 */
	public void clearAllActiveSquares() {
		for (int i = 0; i <= 5; i++) {
			for (int j = 0; j <= 5; j++) {
				if (squares[i][j].isActive()) {
					squares[i][j].removeContents();
					;
				}
			}
		}
	}
}