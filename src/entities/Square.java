package entities;

public class Square {
	Letter contents;
	int row;
	int column;
	boolean active;

	public void removeSquare(Square s) {
		contents = null;
	}

	public Square fillSquare(Letter l) {
		contents = l;
		return this;
	}

	public boolean isActive() {
		if (contents != null)
			return true;
		else
			return false;
	}
}
