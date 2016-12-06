package entities;

/**
 * Open question: are board squares indexed externally by zero or one
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
	 * @param i   Row of the board
	 * @param j   Column of the board
	 * @return    returns active square object or null if not active.
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

}
