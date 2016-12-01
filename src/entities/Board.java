package entities;

public class Board {
	Square[][] squares = new Square[6][6];
//test to see if i show up as a contributor

	public Square[][] activeSquares() {
		Square[][] activeOnes = new Square[6][6];
		for(int i = 1; i<=6; i++){
			for(int j = 1; j<=6; j++){
				if(squares[i][j].isActive()){
					activeOnes[i][j] = squares[i][j];
				}
			}
		}
		return activeOnes;
	}
	public void activateSquare(Square s){
		s.setActivity(true);
	}

}
