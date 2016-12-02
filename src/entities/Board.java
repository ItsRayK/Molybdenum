package entities;

public class Board {
	public Square[][] squares = new Square[6][6];

	public Board() {
		for (int i = 0; i <= 5; i++) {
			for (int j = 0; j <= 5; j++) {
				squares[i][j] = new Square(i, j, true);
			}
		}
	}

	public Square[][] activeSquares() {
		Square[][] activeOnes = new Square[6][6];
		for (int i = 1; i <= 6; i++) {
			for (int j = 1; j <= 6; j++) {
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

}
