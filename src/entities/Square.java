package entities;

public class Square {
	Letter contents;
	int row;
	int column;
	public boolean active = false;

	public Square(int row, int column, boolean active){
		this.row = row;
		this.column = column;
		this.active = active;
		
	}
	
	public void removeSquare(Square s) {
		contents = null;
	}

	public Square fillSquare(Letter l) {
		contents = l;
		return this;
	}

	public String getContentsString() {
		return contents.letterString;
	}

	public int getContentsPoints() {
		return contents.value;
	}

	public boolean isActive() {
		return active;
	}

	public void setActivity(boolean tf) {
		active = tf;
	}
}
